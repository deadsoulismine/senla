package com.senla.hotel.ui.model.action.objects.guest;

import com.senla.hotel.backend.service.IService;
import com.senla.hotel.ui.exception.ListIsEmptyException;
import com.senla.hotel.ui.exception.ObjectNotExistException;
import com.senla.hotel.ui.model.action.IAction;
import com.senla.hotel.util.dependency.annotation.Autowired;
import com.senla.hotel.util.dependency.stereotype.Component;
import com.senla.hotel.util.scanner.IScannerService;

@Component
public class ChangeGuestNameAction implements IAction {
    @Autowired(className = "ServiceImpl")
    private IService service;
    @Autowired(className = "ScannerService")
    private IScannerService utilScanner;

    //Изменяем цену номера
    @Override
    public void execute() throws ObjectNotExistException, ListIsEmptyException {
        service.printGuestList();
        System.out.println("Enter id of guest for change name");
        int idGuest = utilScanner.intScanner();
        System.out.println("Enter new name");
        String name = utilScanner.stringScanner();
        service.changeGuestName(idGuest, name);
    }
}
