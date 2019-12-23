package com.senla.hotel.ui.model.action.serialisation.service;

import com.senla.hotel.backend.Application;
import com.senla.hotel.ui.model.action.IAction;
import com.senla.hotel.util.DI.annotation.Autowired;
import com.senla.hotel.util.DI.stereotype.Component;
import com.senla.hotel.util.scanner.IUtilScanner;

@Component
public class FileSaveServiceAction implements IAction {
    @Autowired(className = "UtilScanner")
    private IUtilScanner utilScanner;

    //Сохранение данных услуг в файл
    @Override
    public void execute() {
        System.out.println("Enter name of file for save Service data");
        Application.fileSaveService(utilScanner.stringScanner());
    }
}
