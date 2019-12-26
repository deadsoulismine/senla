package com.senla.hotel.ui.model.action.objects.service;

import com.senla.hotel.backend.service.IService;
import com.senla.hotel.ui.exception.ListIsEmptyException;
import com.senla.hotel.ui.exception.ObjectNotExistException;
import com.senla.hotel.ui.model.action.IAction;
import com.senla.hotel.util.DI.annotation.Autowired;
import com.senla.hotel.util.DI.stereotype.Component;
import com.senla.hotel.util.scanner.IScannerService;

@Component
public class DeleteServiceAction implements IAction {
    @Autowired(className = "ServiceImpl")
    private IService service;
    @Autowired(className = "ScannerService")
    private IScannerService utilScanner;

    //Удаляем услугу из списка
    @Override
    public void execute() throws ObjectNotExistException, ListIsEmptyException {
        service.printServiceList();
        System.out.println("Enter ID of service for delete");
        service.deleteService(utilScanner.intScanner());
    }
}
