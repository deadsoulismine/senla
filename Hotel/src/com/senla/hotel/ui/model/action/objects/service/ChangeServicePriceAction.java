package com.senla.hotel.ui.model.action.objects.service;

import com.senla.hotel.backend.Application;
import com.senla.hotel.ui.model.action.IAction;
import com.senla.hotel.ui.model.action.util.UtilScanner;

public class ChangeServicePriceAction implements IAction {
    //Изменяем стоймость услуги
    @Override
    public void execute() {
        Application.printServiceList();
        System.out.println("Enter ID of Service for change price");
        int idService = UtilScanner.intScanner();
        System.out.println("Enter new price");
        int price = UtilScanner.intScanner();
        Application.changeServicePrice(idService, price);
    }

}
