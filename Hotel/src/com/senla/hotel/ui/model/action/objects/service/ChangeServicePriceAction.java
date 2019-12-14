package com.senla.hotel.ui.model.action.objects.service;

import com.senla.hotel.ui.exception.ListIsEmptyException;
import com.senla.hotel.ui.exception.ObjectNotExistException;
import com.senla.hotel.ui.model.action.IAction;

import static com.senla.hotel.backend.Application.changeServicePrice;
import static com.senla.hotel.backend.Application.printServiceList;
import static com.senla.hotel.util.UtilScanner.intScanner;

public class ChangeServicePriceAction implements IAction {
    //Изменяем стоймость услуги
    @Override
    public void execute() throws ListIsEmptyException, ObjectNotExistException {
        printServiceList();
        System.out.println("Enter ID of Service for change price");
        int idService = intScanner();
        System.out.println("Enter new price");
        int price = intScanner();
        changeServicePrice(idService, price);
    }

}
