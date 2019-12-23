package com.senla.hotel.ui.model.action.objects.service;

import com.senla.hotel.backend.Application;
import com.senla.hotel.ui.exception.ListIsEmptyException;
import com.senla.hotel.ui.exception.ObjectNotExistException;
import com.senla.hotel.ui.model.action.IAction;
import com.senla.hotel.util.DI.annotation.Autowired;
import com.senla.hotel.util.DI.stereotype.Component;
import com.senla.hotel.util.scanner.IUtilScanner;

@Component
public class DeleteServiceAction implements IAction {
    @Autowired(className = "UtilScanner")
    private IUtilScanner utilScanner;

    //Удаляем услугу из списка
    @Override
    public void execute() throws ObjectNotExistException, ListIsEmptyException {
        Application.printServiceList();
        System.out.println("Enter ID of Service for delete");
        Application.deleteService(utilScanner.intScanner());
    }
}
