package com.senla.hotel.ui.model.action.serialisation.guest;

import com.senla.hotel.backend.Application;
import com.senla.hotel.ui.model.action.IAction;
import com.senla.hotel.util.DI.annotation.Autowired;
import com.senla.hotel.util.DI.stereotype.Component;
import com.senla.hotel.util.scanner.IUtilScanner;

@Component
public class FileLoadGuestAction implements IAction {
    @Autowired(className = "UtilScanner")
    private IUtilScanner utilScanner;

    //Загрузка данных постояльцев из файла
    @Override
    public void execute() {
        System.out.println("Enter name of file for load Guest data");
        Application.fileLoadGuest(utilScanner.stringScanner());
    }
}
