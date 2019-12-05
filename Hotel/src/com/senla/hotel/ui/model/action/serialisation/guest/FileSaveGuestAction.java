package com.senla.hotel.ui.model.action.serialisation.guest;

import com.senla.hotel.backend.Application;
import com.senla.hotel.ui.model.action.IAction;
import com.senla.hotel.ui.model.action.util.UtilScanner;

public class FileSaveGuestAction implements IAction {
    //Сохранение данных постояльцев в файл
    @Override
    public void execute() {
        System.out.println("Enter name of file for save Guest data");
        Application.fileSaveGuest(UtilScanner.stringScanner());
    }
}
