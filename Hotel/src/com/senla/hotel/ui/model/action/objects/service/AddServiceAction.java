package com.senla.hotel.ui.model.action.objects.service;

import com.senla.hotel.backend.Application;
import com.senla.hotel.ui.model.action.IAction;
import com.senla.hotel.ui.model.action.util.UtilScanner;

public class AddServiceAction implements IAction {
    //Добавляем новую услугу в список
    @Override
    public void execute() {
        System.out.println("Enter title of new Service");
        String title = UtilScanner.stringScanner();
        System.out.println("Enter price of new Service");
        int price = UtilScanner.intScanner();
        Application.addService(title, price);
    }

}
