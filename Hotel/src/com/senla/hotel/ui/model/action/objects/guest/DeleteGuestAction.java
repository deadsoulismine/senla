package com.senla.hotel.ui.model.action.objects.guest;

import com.senla.hotel.backend.Application;
import com.senla.hotel.ui.model.action.IAction;
import com.senla.hotel.ui.model.action.util.UtilScanner;

public class DeleteGuestAction implements IAction {
    //Удаляем постояльца из списка
    @Override
    public void execute() {
        Application.printGuestList();
        System.out.println("Enter ID of Guest for delete");
        int id = UtilScanner.intScanner();
        Application.deleteGuest(id);
    }
}
