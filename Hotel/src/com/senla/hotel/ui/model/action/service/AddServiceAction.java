package com.senla.hotel.ui.model.action.service;

import com.senla.hotel.backend.Application;
import com.senla.hotel.ui.model.action.IAction;

import java.util.Scanner;

public class AddServiceAction implements IAction {
    //Добавляем новую услугу в список
    @Override
    public void execute() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter title of new Service");
        String title = in.nextLine();
        System.out.println("Enter price of new Service");
        int price = in.nextInt();
        Application.addService(title, price);
    }
}
