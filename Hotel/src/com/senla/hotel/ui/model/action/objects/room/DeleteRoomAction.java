package com.senla.hotel.ui.model.action.objects.room;

import com.senla.hotel.ui.exception.ListIsEmptyException;
import com.senla.hotel.ui.exception.ObjectNotExistException;
import com.senla.hotel.ui.model.action.IAction;

import static com.senla.hotel.backend.Application.deleteRoom;
import static com.senla.hotel.backend.Application.printRoomList;
import static com.senla.hotel.util.UtilScanner.intScanner;

public class DeleteRoomAction implements IAction {
    //Удаляем номер из списка
    @Override
    public void execute() throws ListIsEmptyException, ObjectNotExistException {
        printRoomList();
        System.out.println("Enter number of room for delete");
        deleteRoom(intScanner());
    }
}
