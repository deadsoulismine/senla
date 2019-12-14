package com.senla.hotel.ui.model.action.objects.guest;

import com.senla.hotel.ui.model.action.IAction;

import static com.senla.hotel.backend.Application.addGuest;
import static com.senla.hotel.util.UtilScanner.intScanner;
import static com.senla.hotel.util.UtilScanner.stringScanner;

public class AddGuestAction implements IAction {
    //Добавляем нового постояльца в список
    @Override
    public void execute() {
        System.out.println("Enter name of new Guest");
        String name = stringScanner();
        System.out.println("Enter age of new Guest");
        int age = intScanner();
        addGuest(name, age);
    }
}
