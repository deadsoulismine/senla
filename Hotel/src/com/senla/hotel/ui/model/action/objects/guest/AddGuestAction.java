package com.senla.hotel.ui.model.action.objects.guest;

import com.senla.hotel.backend.Application;
import com.senla.hotel.ui.model.action.IAction;
import com.senla.hotel.ui.model.action.util.UtilScanner;

public class AddGuestAction implements IAction {
    //Добавляем нового постояльца в список
    @Override
    public void execute() {
        System.out.println("Enter name of new Guest");
        String name = UtilScanner.stringScanner();
        System.out.println("Enter age of new Guest");
        int age = UtilScanner.intScanner();
        Application.addGuest(name, age);
    }
}
