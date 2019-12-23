package com.senla.hotel.ui.model.action.residence;

import com.senla.hotel.backend.Application;
import com.senla.hotel.ui.exception.ListIsEmptyException;
import com.senla.hotel.ui.exception.ObjectNotExistException;
import com.senla.hotel.ui.model.action.IAction;
import com.senla.hotel.util.DI.annotation.Autowired;
import com.senla.hotel.util.DI.stereotype.Component;
import com.senla.hotel.util.scanner.IUtilScanner;

@Component
public class SettleAction implements IAction {
    @Autowired(className = "UtilScanner")
    private IUtilScanner utilScanner;

    //Заселение
    @Override
    public void execute() throws ObjectNotExistException, ListIsEmptyException {
        Application.printWaitingGuests();
        System.out.println("Enter ID of guest for settle");
        int idGuest = utilScanner.intScanner();
        Application.printFreeRoomList();
        System.out.println("Enter number of free room");
        int roomNumber = utilScanner.intScanner();
        Application.settle(idGuest, roomNumber);
    }
}
