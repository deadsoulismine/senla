package com.senla.hotel.ui.model.action.room;

import com.senla.hotel.backend.Application;
import com.senla.hotel.ui.model.action.IAction;

import java.util.Scanner;

public class AddRoomAction implements IAction {
    //Добавляем новую комнату в список
    @Override
    public void execute() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter number of new Room");
        int number = in.nextInt();
        System.out.println("Enter price of new Room");
        int price = in.nextInt();
        Application.addRoom(number, price);
    }
}
