package com.senla.hotel.ui.model.action.residence;

import com.senla.hotel.backend.Application;
import com.senla.hotel.ui.model.action.IAction;
import com.senla.hotel.ui.model.action.util.UtilScanner;

public class EvictAction implements IAction {
    @Override
    public void execute() {
        Application.printGuestList();
        System.out.println("Enter ID of guest");
        Application.evict(UtilScanner.intScanner());
    }

}
