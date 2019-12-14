package com.senla.hotel.ui.model.action.objects.service;

import com.senla.hotel.ui.exception.ListIsEmptyException;
import com.senla.hotel.ui.exception.ObjectNotExistException;
import com.senla.hotel.ui.model.action.IAction;

import static com.senla.hotel.backend.Application.deleteService;
import static com.senla.hotel.backend.Application.printServiceList;
import static com.senla.hotel.util.UtilScanner.intScanner;

public class DeleteServiceAction implements IAction {
    //Удаляем услугу из списка
    @Override
    public void execute() throws ObjectNotExistException, ListIsEmptyException {
        printServiceList();
        System.out.println("Enter ID of Service for delete");
        deleteService(intScanner());
    }
}
