package com.senla.hotel.ui.model.action.objects.service;

import com.senla.hotel.backend.Application;
import com.senla.hotel.ui.model.action.IAction;

import java.util.Scanner;

public class DeleteServiceAction implements IAction {
    //Удаляем услугу из списка
    @Override
    public void execute() {
        Scanner in = new Scanner(System.in);
        Application.printServiceList();
        System.out.println("Enter ID of Service for delete");
        int id = in.nextInt();
        Application.deleteService(id);
        Application.printServiceList();
    }
}
