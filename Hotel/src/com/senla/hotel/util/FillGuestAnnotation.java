package com.senla.hotel.util;

import com.senla.hotel.backend.Application;
import com.senla.hotel.backend.domain.Guest;
import com.senla.hotel.resources.FillGuest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FillGuestAnnotation {
    private static final String PATH_TO_PROPERTIES_OF_FIELD = "Hotel/src/com/senla/hotel/resources/fillGuest.properties";
    private static Properties propField = new Properties();

    public static void action() throws IOException, NoSuchFieldException {
        FileInputStream fileInputStreamField = new FileInputStream(PATH_TO_PROPERTIES_OF_FIELD);
        propField.load(fileInputStreamField);
        //Обработка аннотации
        Guest guest = new Guest("", 0);
        guest.setName(propField.getProperty(
                Guest.class.getDeclaredField("name").getAnnotation(FillGuest.class).propertyName()));
        guest.setAge(Integer.parseInt(propField.getProperty(
                Guest.class.getDeclaredField("age").getAnnotation(FillGuest.class).propertyName())));
        Application.getHotel().guestList().add(guest);
    }
}
