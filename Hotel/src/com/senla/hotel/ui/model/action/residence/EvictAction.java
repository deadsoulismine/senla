package com.senla.hotel.ui.model.action.residence;

import com.senla.hotel.ui.exception.ListIsEmptyException;
import com.senla.hotel.ui.exception.ObjectNotExistException;
import com.senla.hotel.ui.model.action.IAction;

import static com.senla.hotel.backend.Application.evict;
import static com.senla.hotel.backend.Application.printSettleGuests;
import static com.senla.hotel.util.UtilScanner.intScanner;

public class EvictAction implements IAction {
    @Override
    public void execute() throws ListIsEmptyException, ObjectNotExistException {
        printSettleGuests();
        System.out.println("Enter ID of guest for evict");
        int idGuest = intScanner();
        evict(idGuest);
    }

}
