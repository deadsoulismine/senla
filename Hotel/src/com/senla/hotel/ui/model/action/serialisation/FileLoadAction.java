package com.senla.hotel.ui.model.action.serialisation;

import com.senla.hotel.backend.Application;
import com.senla.hotel.ui.model.action.IAction;

import java.io.IOException;
import java.util.Scanner;

public class FileLoadAction implements IAction {
    //Загрузка данных из файла
    @Override
    public void execute() throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter name of file for load data");
        String name = in.nextLine();
        Application.fileLoad(name);

    }
}
