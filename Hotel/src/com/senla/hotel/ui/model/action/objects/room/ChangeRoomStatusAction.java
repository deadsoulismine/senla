package com.senla.hotel.ui.model.action.objects.room;

import com.senla.hotel.Main;
import com.senla.hotel.backend.Application;
import com.senla.hotel.ui.model.action.IAction;
import com.senla.hotel.ui.model.action.util.UtilScanner;

public class ChangeRoomStatusAction implements IAction {
    //Изменяем статус номера
    @Override
    public void execute() {
        if (Boolean.parseBoolean(Main.prop.getProperty("status"))) {
            Application.printRoomList();
            System.out.println("Enter ID of Room for change status");
            Application.changeRoomStatus(UtilScanner.intScanner());
        } else {
            System.out.println("Access to change this field is closed!");
        }

    }

}
