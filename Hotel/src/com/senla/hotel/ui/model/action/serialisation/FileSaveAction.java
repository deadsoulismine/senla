package com.senla.hotel.ui.model.action.serialisation;

import com.senla.hotel.backend.Application;
import com.senla.hotel.ui.model.action.IAction;

import java.util.Scanner;

public class FileSaveAction implements IAction {
    //Сохранение данных в файл
    @Override
    public void execute() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter name of file for save data");
        String name = in.nextLine();
        Application.fileSave(name);
    }
}
