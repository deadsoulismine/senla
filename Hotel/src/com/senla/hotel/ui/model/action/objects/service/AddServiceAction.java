package com.senla.hotel.ui.model.action.objects.service;

import com.senla.hotel.ui.exception.SameObjectsException;
import com.senla.hotel.ui.model.action.IAction;

import static com.senla.hotel.backend.Application.addService;
import static com.senla.hotel.util.UtilScanner.intScanner;
import static com.senla.hotel.util.UtilScanner.stringScanner;

public class AddServiceAction implements IAction {
    //Добавляем новую услугу в список
    @Override
    public void execute() throws SameObjectsException {
        System.out.println("Enter title of new Service");
        String title = stringScanner();
        System.out.println("Enter price of new Service");
        int price = intScanner();
        addService(title, price);
    }

}
