package com.senla.hotel.ui.controller;

import com.senla.hotel.ui.exception.ListIsEmptyException;
import com.senla.hotel.ui.exception.ObjectNotExistException;
import com.senla.hotel.ui.exception.SameObjectsException;
import com.senla.hotel.ui.exception.TypeException;
import com.senla.hotel.ui.model.builder.Builder;
import com.senla.hotel.ui.model.navigator.Navigator;

import java.util.Scanner;

public class MenuController {
    private Builder builder;
    private Navigator navigator;

    public MenuController(Builder builder, Navigator navigator) {
        this.builder = builder;
        this.navigator = navigator;
    }

    public void run() {
        Scanner in = new Scanner(System.in);
        navigator.setCurrentMenu(builder.buildMenu());
        do {
            navigator.printMenu();
            try {
                if (!in.hasNextByte()) {
                    throw new TypeException("Enter the number of menu item!");
                } else {
                    navigator.navigate(in.nextByte());
                }
            } catch (TypeException e) {
                System.out.println(e.getMessage());
                in.next();
            } catch (ObjectNotExistException | ListIsEmptyException | SameObjectsException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

}
