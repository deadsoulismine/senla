package com.senla.hotel.ui.model.action.residence;

import com.senla.hotel.backend.service.IService;
import com.senla.hotel.ui.exception.ListIsEmptyException;
import com.senla.hotel.ui.model.action.IAction;
import com.senla.hotel.util.dependency.annotation.Autowired;
import com.senla.hotel.util.dependency.stereotype.Component;
import com.senla.hotel.util.scanner.IScannerService;

@Component
public class DeleteServicesAction implements IAction {
    @Autowired(className = "ServiceImpl")
    private IService service;
    @Autowired(className = "ScannerService")
    private IScannerService utilScanner;

    @Override
    public void execute() throws ListIsEmptyException {
        service.printSettleGuests();
        System.out.println("Enter ID of guest for delete service");
        int idGuest = utilScanner.intScanner();
        service.printServiceList();
        System.out.println("Enter ID of service for delete from guest");
        int idService = utilScanner.intScanner();
        service.deleteServices(idGuest, idService);
    }
}
