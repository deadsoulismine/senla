package com.senla.hotel.ui.model.action.objects.room;

import com.senla.hotel.backend.service.IService;
import com.senla.hotel.ui.exception.SameObjectsException;
import com.senla.hotel.ui.model.action.IAction;
import com.senla.hotel.util.DI.annotation.Autowired;
import com.senla.hotel.util.DI.stereotype.Component;
import com.senla.hotel.util.scanner.IScannerService;

@Component
public class AddRoomAction implements IAction {
    @Autowired(className = "ServiceImpl")
    private IService service;
    @Autowired(className = "ScannerService")
    private IScannerService utilScanner;

    //Добавляем новую комнату в список
    @Override
    public void execute() throws SameObjectsException {
        System.out.println("Enter number of new room");
        int number = utilScanner.intScanner();
        System.out.println("Enter price of new room");
        int price = utilScanner.intScanner();
        service.addRoom(number, price);
    }

}
