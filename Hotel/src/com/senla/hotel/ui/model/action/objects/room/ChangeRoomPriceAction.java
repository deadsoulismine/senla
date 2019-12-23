package com.senla.hotel.ui.model.action.objects.room;

import com.senla.hotel.backend.Application;
import com.senla.hotel.ui.exception.ListIsEmptyException;
import com.senla.hotel.ui.exception.ObjectNotExistException;
import com.senla.hotel.ui.model.action.IAction;
import com.senla.hotel.util.DI.annotation.Autowired;
import com.senla.hotel.util.DI.stereotype.Component;
import com.senla.hotel.util.scanner.IUtilScanner;

@Component
public class ChangeRoomPriceAction implements IAction {
    @Autowired(className = "UtilScanner")
    private IUtilScanner utilScanner;

    //Изменяем цену номера
    @Override
    public void execute() throws ListIsEmptyException, ObjectNotExistException {
        Application.printRoomList();
        System.out.println("Enter number of room for change price");
        int idRoom = utilScanner.intScanner();
        System.out.println("Enter new price");
        int price = utilScanner.intScanner();
        Application.changeRoomPrice(idRoom, price);
    }
}
