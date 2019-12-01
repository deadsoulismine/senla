package com.senla.hotel.ui.controller;

import com.senla.hotel.ui.model.builder.Builder;
import com.senla.hotel.ui.model.navigator.Navigator;

import java.io.IOException;
import java.util.Scanner;

public class MenuController {
    Builder builder;
    Navigator navigator;

    public MenuController(Builder builder, Navigator navigator) {
        this.builder = builder;
        this.navigator = navigator;
    }

    public void run() throws IOException {
        Scanner in = new Scanner(System.in);
        byte choice = 0;
        navigator.setCurrentMenu(builder.buildMenu());
        do {
            navigator.printMenu();
            choice = in.nextByte();
            navigator.navigate(choice);
        } while (true);
    }

}
