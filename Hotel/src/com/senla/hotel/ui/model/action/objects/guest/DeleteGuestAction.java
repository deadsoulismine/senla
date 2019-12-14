package com.senla.hotel.ui.model.action.objects.guest;

import com.senla.hotel.ui.exception.ListIsEmptyException;
import com.senla.hotel.ui.exception.ObjectNotExistException;
import com.senla.hotel.ui.model.action.IAction;

import static com.senla.hotel.backend.Application.deleteGuest;
import static com.senla.hotel.backend.Application.printGuestList;
import static com.senla.hotel.util.UtilScanner.intScanner;

public class DeleteGuestAction implements IAction {
    //Удаляем постояльца из списка
    @Override
    public void execute() throws ListIsEmptyException, ObjectNotExistException {
        printGuestList();
        System.out.println("Enter ID of Guest for delete");
        deleteGuest(intScanner());
    }
}
