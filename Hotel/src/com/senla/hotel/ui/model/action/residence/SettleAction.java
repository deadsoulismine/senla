package com.senla.hotel.ui.model.action.residence;

import com.senla.hotel.ui.exception.ListIsEmptyException;
import com.senla.hotel.ui.exception.ObjectNotExistException;
import com.senla.hotel.ui.model.action.IAction;

import static com.senla.hotel.backend.Application.*;
import static com.senla.hotel.util.UtilScanner.intScanner;

public class SettleAction implements IAction {
    //Заселение
    @Override
    public void execute() throws ObjectNotExistException, ListIsEmptyException {
        printWaitingGuests();
        System.out.println("Enter ID of guest for settle");
        int idGuest = intScanner();
        printFreeRoomList();
        System.out.println("Enter number of free room");
        int roomNumber = intScanner();
        settle(idGuest, roomNumber);
    }
}
