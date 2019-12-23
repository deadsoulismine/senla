package com.senla.hotel.ui.model.action.residence;

import com.senla.hotel.backend.Application;
import com.senla.hotel.ui.exception.ListIsEmptyException;
import com.senla.hotel.ui.exception.ObjectNotExistException;
import com.senla.hotel.ui.model.action.IAction;
import com.senla.hotel.util.DI.annotation.Autowired;
import com.senla.hotel.util.DI.stereotype.Component;
import com.senla.hotel.util.scanner.IUtilScanner;

import static com.senla.hotel.backend.Application.evict;

@Component
public class EvictAction implements IAction {
    @Autowired(className = "UtilScanner")
    private IUtilScanner utilScanner;

    @Override
    public void execute() throws ListIsEmptyException, ObjectNotExistException {
        Application.printSettleGuests();
        System.out.println("Enter ID of guest for evict");
        int idGuest = utilScanner.intScanner();
        evict(idGuest);
    }

}
