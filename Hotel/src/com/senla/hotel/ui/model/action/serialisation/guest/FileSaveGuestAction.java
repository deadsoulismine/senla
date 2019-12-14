package com.senla.hotel.ui.model.action.serialisation.guest;

import com.senla.hotel.ui.model.action.IAction;
import com.senla.hotel.util.UtilScanner;

import static com.senla.hotel.backend.Application.fileSaveGuest;

public class FileSaveGuestAction implements IAction {
    //Сохранение данных постояльцев в файл
    @Override
    public void execute() {
        System.out.println("Enter name of file for save Guest data");
        fileSaveGuest(UtilScanner.stringScanner());
    }
}
