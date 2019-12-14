package com.senla.hotel.ui.model.action.objects.room;

import com.senla.hotel.ui.exception.ListIsEmptyException;
import com.senla.hotel.ui.exception.ObjectNotExistException;
import com.senla.hotel.ui.model.action.IAction;

import static com.senla.hotel.backend.Application.changeRoomStatus;
import static com.senla.hotel.backend.Application.printRoomList;
import static com.senla.hotel.util.Data.getProp;
import static com.senla.hotel.util.UtilScanner.intScanner;
import static java.lang.Boolean.parseBoolean;

public class ChangeRoomStatusAction implements IAction {
    //Изменяем статус номера
    @Override
    public void execute() throws ListIsEmptyException, ObjectNotExistException {
        if (parseBoolean(getProp().getProperty("status"))) {
            printRoomList();
            System.out.println("Enter number of room for change status");
            changeRoomStatus(intScanner());
        } else {
            System.out.println("Access to change this field is closed!");
        }
    }

}
