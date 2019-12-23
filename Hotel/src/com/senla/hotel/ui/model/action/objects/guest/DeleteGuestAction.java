package com.senla.hotel.ui.model.action.objects.guest;

import com.senla.hotel.backend.Application;
import com.senla.hotel.ui.exception.ListIsEmptyException;
import com.senla.hotel.ui.exception.ObjectNotExistException;
import com.senla.hotel.ui.model.action.IAction;
import com.senla.hotel.util.DI.annotation.Autowired;
import com.senla.hotel.util.DI.stereotype.Component;
import com.senla.hotel.util.scanner.IUtilScanner;

@Component
public class DeleteGuestAction implements IAction {
    @Autowired(className = "UtilScanner")
    private IUtilScanner utilScanner;

    //Удаляем постояльца из списка
    @Override
    public void execute() throws ListIsEmptyException, ObjectNotExistException {
        Application.printGuestList();
        System.out.println("Enter ID of Guest for delete");
        Application.deleteGuest(utilScanner.intScanner());
    }
}
