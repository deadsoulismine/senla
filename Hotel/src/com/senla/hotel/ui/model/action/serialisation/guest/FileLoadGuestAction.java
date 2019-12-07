package com.senla.hotel.ui.model.action.serialisation.guest;

import com.senla.hotel.backend.Application;
import com.senla.hotel.ui.model.action.IAction;
import com.senla.hotel.ui.model.action.util.UtilScanner;

import java.io.IOException;

public class FileLoadGuestAction implements IAction {
    //Загрузка данных постояльцев из файла
    @Override
    public void execute() throws IOException {
        System.out.println("Enter name of file for load Guest data");
        Application.fileLoadGuest(UtilScanner.stringScanner());
    }
}
