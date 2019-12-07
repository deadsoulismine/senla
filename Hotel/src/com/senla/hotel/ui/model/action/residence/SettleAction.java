package com.senla.hotel.ui.model.action.residence;

import com.senla.hotel.backend.Application;
import com.senla.hotel.ui.model.action.IAction;
import com.senla.hotel.ui.model.action.util.UtilScanner;

public class SettleAction implements IAction {
    //Заселение
    @Override
    public void execute() {
        Application.printGuestList();
        System.out.println("Enter ID of guest");
        int idGuest = UtilScanner.intScanner();
        Application.printFreeRoomList();
        System.out.println("Enter ID of free room");
        int idRoom = UtilScanner.intScanner();
        Application.settle(idGuest, idRoom);
    }
}
