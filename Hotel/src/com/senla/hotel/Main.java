package com.senla.hotel;

import com.senla.hotel.ui.controller.MenuController;
import com.senla.hotel.ui.model.builder.Builder;
import com.senla.hotel.ui.model.navigator.Navigator;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class Main {
    public static final String PATH_TO_PROPERTIES = "src/com/senla/hotel/resources/config.properties";
    public static FileInputStream fileInputStream;
    public static Properties prop = new Properties();

    static {
        try {
            fileInputStream = new FileInputStream(PATH_TO_PROPERTIES);
        } catch (FileNotFoundException e) {
            System.out.println("Error: file " + PATH_TO_PROPERTIES + " is not found!");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MenuController menuController = new MenuController(new Builder(), new Navigator());
        menuController.run();
    }
}
