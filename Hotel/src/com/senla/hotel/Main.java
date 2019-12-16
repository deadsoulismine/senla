package com.senla.hotel;

import com.senla.hotel.ui.controller.MenuController;
import com.senla.hotel.ui.model.builder.Builder;
import com.senla.hotel.ui.model.navigator.Navigator;
import com.senla.hotel.util.Data;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, IllegalAccessException, NoSuchFieldException {
        Data.loadData();
        MenuController menuController = new MenuController(new Builder(), new Navigator());
        menuController.run();
    }
}
