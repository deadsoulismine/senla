package com.senla.hotel.ui.model.action.residence;

import com.senla.hotel.backend.service.IService;
import com.senla.hotel.ui.exception.ListIsEmptyException;
import com.senla.hotel.ui.exception.ObjectNotExistException;
import com.senla.hotel.ui.model.action.IAction;
import com.senla.hotel.util.DI.annotation.Autowired;
import com.senla.hotel.util.DI.stereotype.Component;
import com.senla.hotel.util.scanner.IScannerService;

@Component
public class EvictAction implements IAction {
    @Autowired(className = "ServiceImpl")
    private IService service;
    @Autowired(className = "ScannerService")
    private IScannerService utilScanner;

    @Override
    public void execute() throws ListIsEmptyException, ObjectNotExistException {
        service.printSettleGuests();
        System.out.println("Enter ID of guest for evict");
        int idGuest = utilScanner.intScanner();
        service.evict(idGuest);
    }

}
