package com.senla.hotel.ui.model.action.objects.room;

import com.senla.hotel.backend.service.IService;
import com.senla.hotel.ui.exception.ListIsEmptyException;
import com.senla.hotel.ui.exception.ObjectNotExistException;
import com.senla.hotel.ui.model.action.IAction;
import com.senla.hotel.util.data.IData;
import com.senla.hotel.util.dependency.annotation.Autowired;
import com.senla.hotel.util.dependency.stereotype.Component;
import scanner.IScannerService;

import static java.lang.Boolean.parseBoolean;

@Component
public class ChangeRoomStatusAction implements IAction {
    @Autowired(className = "ServiceImpl")
    private IService service;
    @Autowired(className = "ScannerService")
    private IScannerService utilScanner;
    @Autowired(className = "Data")
    private IData data;

    //Изменяем статус номера
    @Override
    public void execute() throws ObjectNotExistException, ListIsEmptyException {
        if (parseBoolean(data.getProp().getProperty("status"))) {
            service.printRoomList();
            System.out.println("Enter number of room for change status");
            service.changeRoomStatus(utilScanner.intScanner());
        } else {
            System.out.println("Access to change this field is closed!");
        }
    }

}
