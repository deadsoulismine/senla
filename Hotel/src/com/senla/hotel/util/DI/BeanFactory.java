package com.senla.hotel.util.DI;

import com.senla.hotel.util.DI.annotation.Autowired;
import com.senla.hotel.util.DI.stereotype.Component;
import com.senla.hotel.util.DI.stereotype.Instance;
import io.github.classgraph.ClassGraph;
import io.github.classgraph.ClassInfo;
import io.github.classgraph.ScanResult;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Component
public class BeanFactory implements IBeanFactory {
    private static Map<String, Object> singletons = new HashMap<>();
    //Сканирование существующих класов в корневом пакете

    public static Object getBean(String beanName) {
        return singletons.get(beanName);
    }

    public void init() throws ReflectiveOperationException {
        //Создание синглтонов
        instantiateSingletons();
        //инициализация
        populateProperties();
    }

    //Создание инстанса класса помеченного как @Instance
    public Object instantiateInstance(String instanceName) throws ReflectiveOperationException {
        ScanResult scanResult = new ClassGraph().enableAnnotationInfo().whitelistPackages("com.senla.hotel").scan();
        return Class.forName((Objects.requireNonNull(scanResult.getClassesWithAnnotation(Instance.class.getName()).
                stream().filter(c -> c.getSimpleName().equals(instanceName)).
                findFirst().orElse(null))).getName()).newInstance();
    }

    //Создание списка инстансов, помеченных как @Component
    private void instantiateSingletons() throws ReflectiveOperationException {
        // Ищет классы, помеченные как @Component в списке классов
        try (ScanResult scanResult = new ClassGraph().enableAnnotationInfo().whitelistPackages("com.senla.hotel").scan()) {
            for (ClassInfo classInfo : scanResult.getClassesWithAnnotation(Component.class.getName())) {
                //Создание инстанса
                Object instance = Class.forName(classInfo.getName()).newInstance();
                //Обработка имени
                String beanName = classInfo.getSimpleName();
                //Помещение инстанса в мап с ключом, который является обработанным названием класса
                singletons.put(beanName, instance);
            }
        }
    }

    //Инициализация полей, помеченных аннотацией
    private void populateProperties() throws ReflectiveOperationException {
        String setterName;
        Method setter;
        for (Object object : singletons.values()) {
            for (Field field : object.getClass().getDeclaredFields()) {
                if (field.isAnnotationPresent(Autowired.class)) {
                    for (Object dependency : singletons.values()) {
                        String className = field.getAnnotation(Autowired.class).className();
                        //Инициализация интерфейсов
                        if (!className.equals("null")) {
                            field.setAccessible(true);
                            field.set(object, singletons.values().stream().filter(
                                    c -> c.getClass().getSimpleName().equals(className)).findFirst().orElse(null));
                            field.setAccessible(false);
                        } else if (dependency.getClass().equals(field.getType())) {
                            setterName = "set" + field.getName().substring(0, 1).toUpperCase() +
                                    field.getName().substring(1);
                            setter = object.getClass().getMethod(setterName, dependency.getClass());
                            setter.invoke(object, dependency);
                        }
                    }
                }
            }
        }
    }

}
