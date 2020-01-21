package com.senla.hotel.ui.controller;

import com.senla.hotel.ui.exception.ListIsEmptyException;
import com.senla.hotel.ui.exception.ObjectNotExistException;
import com.senla.hotel.ui.exception.SameObjectsException;
import com.senla.hotel.ui.exception.TypeException;
import com.senla.hotel.ui.model.builder.IBuilder;
import com.senla.hotel.ui.model.navigator.INavigator;
import com.senla.hotel.util.DI.annotation.Autowired;
import com.senla.hotel.util.DI.stereotype.Component;

import java.util.Scanner;

@Component
public class MenuController implements IMenuController {
    @Autowired(className = "Builder")
    private IBuilder builder;
    @Autowired(className = "Navigator")
    private INavigator navigator;

    public void run() throws Exception {
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
