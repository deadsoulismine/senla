package com.senla.hotel.ui.model.action.residence;

import com.senla.hotel.backend.service.IService;
import com.senla.hotel.ui.exception.ListIsEmptyException;
import com.senla.hotel.ui.exception.ObjectNotExistException;
import com.senla.hotel.ui.model.action.IAction;
import com.senla.hotel.util.DI.annotation.Autowired;
import com.senla.hotel.util.DI.stereotype.Component;
import com.senla.hotel.util.scanner.IScannerService;

@Component
public class SettleAction implements IAction {
    @Autowired(className = "ServiceImpl")
    private IService service;
    @Autowired(className = "ScannerService")
    private IScannerService utilScanner;

    //Заселение
    @Override
    public void execute() throws ObjectNotExistException, ListIsEmptyException {
        service.printWaitingGuests();
        System.out.println("Enter ID of guest for settle");
        int idGuest = utilScanner.intScanner();
        service.printFreeRoomList();
        System.out.println("Enter number of free room");
        int roomNumber = utilScanner.intScanner();
        service.settle(idGuest, roomNumber);
    }

}
