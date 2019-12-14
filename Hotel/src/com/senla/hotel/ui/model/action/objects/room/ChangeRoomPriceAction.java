package com.senla.hotel.ui.model.action.objects.room;

import com.senla.hotel.ui.exception.ListIsEmptyException;
import com.senla.hotel.ui.exception.ObjectNotExistException;
import com.senla.hotel.ui.model.action.IAction;

import static com.senla.hotel.backend.Application.changeRoomPrice;
import static com.senla.hotel.backend.Application.printRoomList;
import static com.senla.hotel.util.UtilScanner.intScanner;

public class ChangeRoomPriceAction implements IAction {
    //Изменяем цену номера
    @Override
    public void execute() throws ListIsEmptyException, ObjectNotExistException {
        printRoomList();
        System.out.println("Enter number of room for change price");
        int idRoom = intScanner();
        System.out.println("Enter new price");
        int price = intScanner();
        changeRoomPrice(idRoom, price);
    }
}
