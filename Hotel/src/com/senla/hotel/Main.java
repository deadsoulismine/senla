package com.senla.hotel;

import com.senla.hotel.ui.controller.MenuController;
import com.senla.hotel.ui.model.menu.Menu;

public class Main {
    public static void main(String[] args) {
        MenuController menuController = new MenuController();
        menuController.run();
    }
}
