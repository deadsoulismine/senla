package com.senla.hotel.ui.model.action.objects.room;

import com.senla.hotel.backend.Application;
import com.senla.hotel.ui.exception.SameObjectsException;
import com.senla.hotel.ui.model.action.IAction;
import com.senla.hotel.util.DI.annotation.Autowired;
import com.senla.hotel.util.DI.stereotype.Component;
import com.senla.hotel.util.scanner.IUtilScanner;

@Component
public class AddRoomAction implements IAction {
    @Autowired(className = "UtilScanner")
    private IUtilScanner utilScanner;

    //Добавляем новую комнату в список
    @Override
    public void execute() throws SameObjectsException {
        System.out.println("Enter number of new room");
        int number = utilScanner.intScanner();
        System.out.println("Enter price of new room");
        int price = utilScanner.intScanner();
        Application.addRoom(number, price);
    }

}
