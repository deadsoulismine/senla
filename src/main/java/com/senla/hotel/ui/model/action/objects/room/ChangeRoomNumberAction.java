package com.senla.hotel.ui.model.action.objects.room;

import com.senla.hotel.backend.service.IService;
import com.senla.hotel.ui.exception.ListIsEmptyException;
import com.senla.hotel.ui.exception.ObjectNotExistException;
import com.senla.hotel.ui.model.action.IAction;
import com.senla.hotel.util.dependency.annotation.Autowired;
import com.senla.hotel.util.dependency.stereotype.Component;
import com.senla.hotel.util.scanner.IScannerService;

@Component
public class ChangeRoomNumberAction implements IAction {
    @Autowired(className = "ServiceImpl")
    private IService service;
    @Autowired(className = "ScannerService")
    private IScannerService utilScanner;

    //Изменяем цену номера
    @Override
    public void execute() throws ObjectNotExistException, ListIsEmptyException {
        service.printRoomList();
        System.out.println("Enter id of room for change number");
        int idRoom = utilScanner.intScanner();
        System.out.println("Enter new number");
        int number = utilScanner.intScanner();
        service.changeRoomNumber(idRoom, number);
    }

}
