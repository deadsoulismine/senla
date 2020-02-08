package com.senla.hotel.util.dependency;

import com.senla.hotel.util.dependency.annotation.Autowired;
import com.senla.hotel.util.dependency.stereotype.Component;
import io.github.classgraph.ClassGraph;
import io.github.classgraph.ClassInfo;
import io.github.classgraph.ScanResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Component
public class BeanFactory implements IBeanFactory {
    private static Map<String, Object> singletons = new HashMap<>();
    private Logger objectLogger;

    public Object getBean(String beanName) {
        return singletons.get(beanName);
    }

    public Map<String, Object> getSingletons() {
        return singletons;
    }

    public void init() {
        //Создание синглтонов
        instantiateSingletons();
        //инициализация
        populateProperties();
    }

    //Создание инстанса класса помеченного как @Instance
    @Override
    public Object instantiateInstance(String instanceName) {
        try (ScanResult scanner = new ClassGraph().enableAnnotationInfo().whitelistPackages("com.senla.hotel").scan()) {
            String name = Component.class.getName();
            return Class.forName((((Objects.requireNonNull(scanner.getClassesWithAnnotation((name)).stream().
                    filter(c -> !c.getAnnotationInfo(name).getParameterValues().getValue("type").equals("null")).
                    filter(c -> c.getSimpleName().equals(instanceName)).
                    findFirst().orElse(null))))).getName()).newInstance();
        } catch (IllegalAccessException | InstantiationException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    //Создание списка инстансов, помеченных как @Component
    @Override
    public void instantiateSingletons() {
        // Ищет классы, помеченные как @Component в списке классов
        try (ScanResult scanner = new ClassGraph().enableAnnotationInfo().whitelistPackages("com.senla.hotel").scan()) {
            for (ClassInfo classInfo : scanner.getClassesWithAnnotation(Component.class.getName())) {
                if (classInfo.getAnnotationInfo(Component.class.getName()).getParameterValues().getValue("type").equals("null")) {
                    Object instance = Class.forName(classInfo.getName()).newInstance();
                    //Обработка имени
                    objectLogger = LogManager.getLogger(instance.getClass().getDeclaringClass());
                    objectLogger.info("Object of class " + instance + " is created");
                    String beanName = classInfo.getSimpleName();
                    //Помещение инстанса в мап с ключом, который является обработанным названием класса
                    singletons.put(beanName, instance);
                }
            }
        } catch (IllegalAccessException | ClassNotFoundException | InstantiationException e) {
            e.printStackTrace();
        }
    }

    //Инициализация полей, помеченных аннотацией
    private void populateProperties() {
        String setterName;
        Method setter;
        try {
            for (Object object : singletons.values()) {
                for (Field field : object.getClass().getDeclaredFields()) {
                    if (field.isAnnotationPresent(Autowired.class)) {
                        String className = field.getAnnotation(Autowired.class).className();
                        objectLogger = LogManager.getLogger(object.getClass().getDeclaringClass());
                        //Инициализация интерфейсов
                        if (!className.equals("null")) {
                            field.setAccessible(true);
                            Object interfaceDependency = singletons.values().stream().filter(
                                    c -> c.getClass().getSimpleName().equals(className)).findFirst().orElse(null);
                            field.set(object, singletons.values().stream().filter(
                                    c -> c.getClass().getSimpleName().equals(className)).findFirst().orElse(null));
                            field.setAccessible(false);
                            objectLogger.info("Class " + interfaceDependency + " is initialized by Interface");
                            //Инициализация классов
                        } else {
                            for (Object dependency : singletons.values()) {
                                if (dependency.getClass().equals(field.getType())) {
                                    setterName = "set" + field.getName().substring(0, 1).toUpperCase() +
                                            field.getName().substring(1);
                                    setter = object.getClass().getMethod(setterName, dependency.getClass());
                                    setter.invoke(object, dependency);
                                    objectLogger.info("Class " + dependency + " is initialized by Class");
                                    break;
                                }
                            }
                        }
                    }
                }
            }

        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
