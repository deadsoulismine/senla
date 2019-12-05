package com.senla.hotel.ui.model.action.objects.room;

import com.senla.hotel.backend.Application;
import com.senla.hotel.ui.exception.ObjectNotExistException;
import com.senla.hotel.ui.model.action.IAction;
import com.senla.hotel.ui.model.action.util.UtilScanner;

public class DeleteRoomAction implements IAction {
    //Удаляем номер из списка
    @Override
    public void execute() {
        boolean flag;
        do {
            flag = false;
            Application.printRoomList();
            System.out.println("Enter ID of Room for delete");
            int id = UtilScanner.intScanner();
            try {
                Application.deleteRoom(id);
            } catch (ObjectNotExistException e) {
                System.out.println(e.getMessage());
                flag = true;
            }
        } while (flag);
        Application.printRoomList();
    }
}
