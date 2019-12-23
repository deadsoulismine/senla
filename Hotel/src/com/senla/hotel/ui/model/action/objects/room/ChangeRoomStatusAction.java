package com.senla.hotel.ui.model.action.objects.room;

import com.senla.hotel.backend.Application;
import com.senla.hotel.ui.exception.ListIsEmptyException;
import com.senla.hotel.ui.exception.ObjectNotExistException;
import com.senla.hotel.ui.model.action.IAction;
import com.senla.hotel.util.DI.annotation.Autowired;
import com.senla.hotel.util.DI.stereotype.Component;
import com.senla.hotel.util.data.Data;
import com.senla.hotel.util.data.IData;
import com.senla.hotel.util.scanner.IUtilScanner;

import static java.lang.Boolean.parseBoolean;

@Component
public class ChangeRoomStatusAction implements IAction {
    @Autowired(className = "UtilScanner")
    private IUtilScanner utilScanner;

    @Autowired(className = "Data")
    private IData data;

    //Изменяем статус номера
    @Override
    public void execute() throws ListIsEmptyException, ObjectNotExistException {
        if (parseBoolean(Data.getProp().getProperty("status"))) {
            Application.printRoomList();
            System.out.println("Enter number of room for change status");
            Application.changeRoomStatus(utilScanner.intScanner());
        } else {
            System.out.println("Access to change this field is closed!");
        }
    }

}
