package com.senla.hotel.ui.model.action.serialisation.service;

import com.senla.hotel.backend.Application;
import com.senla.hotel.ui.model.action.IAction;
import com.senla.hotel.util.DI.annotation.Autowired;
import com.senla.hotel.util.DI.stereotype.Component;
import com.senla.hotel.util.scanner.IUtilScanner;

import java.io.IOException;

@Component
public class FileLoadServiceAction implements IAction {
    @Autowired(className = "UtilScanner")
    private IUtilScanner utilScanner;

    //Загрузка данных услуг из файла
    @Override
    public void execute() throws IOException {
        System.out.println("Enter name of file for load Service data");
        Application.fileLoadService(utilScanner.stringScanner());
    }
}
