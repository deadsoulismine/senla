package com.senla.hotel.util;

import com.senla.hotel.backend.domain.Guest;
import com.senla.hotel.backend.service.IService;
import com.senla.hotel.util.DI.annotation.Autowired;
import com.senla.hotel.util.DI.stereotype.Component;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@Component
public class FillField implements IFillField{
    private static final String PATH_TO_PROPERTIES_OF_FIELD = "Hotel/src/com/senla/hotel/resources/fillGuest.properties";
    private static Properties propField = new Properties();
    @Autowired(className = "ServiceImpl")
    private IService service;

    public void action() throws IOException, ReflectiveOperationException {
        FileInputStream fileInputStreamField = new FileInputStream(PATH_TO_PROPERTIES_OF_FIELD);
        propField.load(fileInputStreamField);
        //Обработка аннотации
        String name = propField.getProperty(Guest.class.getDeclaredField("name").
                getAnnotation(Fill.class).propertyName());
        int age = Integer.parseInt(propField.getProperty(
                Guest.class.getDeclaredField("age").getAnnotation(Fill.class).propertyName()));
        service.addGuest(name, age);
    }
}
