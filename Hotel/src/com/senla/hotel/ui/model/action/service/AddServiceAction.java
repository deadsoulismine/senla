package com.senla.hotel.ui.model.action.service;

import com.senla.hotel.backend.Application;
import com.senla.hotel.ui.model.action.IAction;

import java.util.Scanner;

public class AddServiceAction implements IAction {
    //Добавляем новую услугу в список
    @Override
    public void execute() {
        Scanner in = new Scanner(System.in);
        Application.addService(in.nextLine(), in.nextInt());
    }
}
