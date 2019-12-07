package com.senla.hotel.ui.model.action.objects.room;

import com.senla.hotel.backend.Application;
import com.senla.hotel.ui.exception.SameObjectsException;
import com.senla.hotel.ui.model.action.IAction;
import com.senla.hotel.ui.model.action.util.UtilScanner;

public class AddRoomAction implements IAction {
    //Добавляем новую комнату в список
    @Override
    public void execute() {
        boolean flag;
        do {
            flag = false;
            System.out.println("Enter number of new Room");
            int number = UtilScanner.intScanner();
            System.out.println("Enter price of new Room");
            int price = UtilScanner.intScanner();
            try {
                Application.addRoom(number, price);
            } catch (SameObjectsException e) {
                System.out.println(e.getMessage());
                flag = true;
            }
        } while (flag);
    }

}
