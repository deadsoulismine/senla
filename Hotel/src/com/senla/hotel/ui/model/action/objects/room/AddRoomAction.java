package com.senla.hotel.ui.model.action.objects.room;

import com.senla.hotel.ui.exception.SameObjectsException;
import com.senla.hotel.ui.model.action.IAction;

import static com.senla.hotel.backend.Application.addRoom;
import static com.senla.hotel.util.UtilScanner.intScanner;

public class AddRoomAction implements IAction {
    //Добавляем новую комнату в список
    @Override
    public void execute() throws SameObjectsException {
        System.out.println("Enter number of new room");
        int number = intScanner();
        System.out.println("Enter price of new room");
        int price = intScanner();
        addRoom(number, price);
    }

}
