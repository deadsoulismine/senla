package com.senla.hotel.ui.model.action.objects.room;

import com.senla.hotel.backend.service.IService;
import com.senla.hotel.ui.exception.ListIsEmptyException;
import com.senla.hotel.ui.exception.ObjectNotExistException;
import com.senla.hotel.ui.model.action.IAction;
import com.senla.hotel.util.dependency.annotation.Autowired;
import com.senla.hotel.util.dependency.stereotype.Component;
import scanner.IScannerService;

@Component
public class ChangeRoomPriceAction implements IAction {
    @Autowired(className = "ServiceImpl")
    private IService service;
    @Autowired(className = "ScannerService")
    private IScannerService utilScanner;

    //Изменяем цену номера
    @Override
    public void execute() throws ObjectNotExistException, ListIsEmptyException {
        service.printRoomList();
        System.out.println("Enter number of room for change price");
        int idRoom = utilScanner.intScanner();
        System.out.println("Enter new price");
        int price = utilScanner.intScanner();
        service.changeRoomPrice(idRoom, price);
    }

}
