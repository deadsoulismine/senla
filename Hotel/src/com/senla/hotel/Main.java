package com.senla.hotel;

import com.senla.hotel.ui.controller.MenuController;
import com.senla.hotel.ui.model.builder.Builder;
import com.senla.hotel.ui.model.navigator.Navigator;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        MenuController menuController = new MenuController(new Builder(), new Navigator());
        menuController.run();
    }
}
