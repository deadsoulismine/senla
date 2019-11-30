package com.senla.hotel.ui.model.action.guest;

import com.senla.hotel.backend.Application;
import com.senla.hotel.ui.model.action.IAction;

import java.util.Scanner;

public class DeleteGuestAction implements IAction {
    //Удаляем постояльца из списка
    @Override
    public void execute() {
        Scanner in = new Scanner(System.in);
        Application.printGuestList();
        System.out.println("Enter ID of Guest for delete");
        int id = in.nextInt();
        Application.deleteGuest(id);
        Application.printGuestList();
    }

}
