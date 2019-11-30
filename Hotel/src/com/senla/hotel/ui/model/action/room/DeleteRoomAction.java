package com.senla.hotel.ui.model.action.room;

import com.senla.hotel.backend.Application;
import com.senla.hotel.ui.model.action.IAction;

import java.util.Scanner;

public class DeleteRoomAction implements IAction {
    //Удаляем комнату из списка
    @Override
    public void execute() {
        Scanner in = new Scanner(System.in);
        Application.printRoomList();
        System.out.println("Enter Number of Room for delete");
        Integer number = in.nextInt();
        Application.deleteRoom(number);
        Application.printRoomList();
    }
}
