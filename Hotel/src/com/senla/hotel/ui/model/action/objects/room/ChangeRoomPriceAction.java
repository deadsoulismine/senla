package com.senla.hotel.ui.model.action.objects.room;

import com.senla.hotel.backend.Application;
import com.senla.hotel.ui.model.action.IAction;
import com.senla.hotel.ui.model.action.util.UtilScanner;

public class ChangeRoomPriceAction implements IAction {
    //Изменяем цену номера
    @Override
    public void execute() {
        Application.printRoomList();
        System.out.println("Enter ID of Room for change price");
        int idRoom = UtilScanner.intScanner();
        System.out.println("Enter new price");
        int price = UtilScanner.intScanner();
        Application.changeRoomPrice(idRoom, price);
    }
}
