package com.senla.hotel.ui.controller;

import com.senla.hotel.ui.model.builder.Builder;
import com.senla.hotel.ui.model.navigator.Navigator;
import com.senla.hotel.ui.view.ViewController;

import java.util.Scanner;

public class MenuController {
    Builder builder = new Builder();
    Navigator navigator = new Navigator();

    public void run () {
        Scanner in = new Scanner(System.in);
        byte choice = 0;
        navigator.setCurrentMenu(builder.buildMenu());
        do {
            navigator.printMenu();
            choice = in.nextByte();
            navigator.navigate(choice);
            if (choice == 0) {
                break;
            }
        } while (true);
    }

}
