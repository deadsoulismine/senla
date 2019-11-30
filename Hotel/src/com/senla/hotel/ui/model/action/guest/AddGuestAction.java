package com.senla.hotel.ui.model.action.guest;

import com.senla.hotel.backend.Application;
import com.senla.hotel.ui.model.action.IAction;

import java.util.Scanner;

public class AddGuestAction implements IAction {
    //Добавляем нового постояльца в список
    @Override
    public void execute() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter name of new Guest");
        String name = in.nextLine();
        System.out.println("Enter age of new Guest");
        int age = in.nextInt();
        Application.addGuest(name, age, null);
    }
}
