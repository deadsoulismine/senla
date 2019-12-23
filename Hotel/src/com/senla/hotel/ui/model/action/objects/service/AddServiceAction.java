package com.senla.hotel.ui.model.action.objects.service;

import com.senla.hotel.backend.Application;
import com.senla.hotel.ui.exception.SameObjectsException;
import com.senla.hotel.ui.model.action.IAction;
import com.senla.hotel.util.DI.annotation.Autowired;
import com.senla.hotel.util.DI.stereotype.Component;
import com.senla.hotel.util.scanner.IUtilScanner;

@Component
public class AddServiceAction implements IAction {
    @Autowired(className = "UtilScanner")
    private IUtilScanner utilScanner;

    //Добавляем новую услугу в список
    @Override
    public void execute() throws SameObjectsException {
        System.out.println("Enter title of new Service");
        String title = utilScanner.stringScanner();
        System.out.println("Enter price of new Service");
        int price = utilScanner.intScanner();
        Application.addService(title, price);
    }

}
