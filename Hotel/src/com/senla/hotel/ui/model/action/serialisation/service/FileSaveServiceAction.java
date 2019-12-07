package com.senla.hotel.ui.model.action.serialisation.service;

import com.senla.hotel.backend.Application;
import com.senla.hotel.ui.model.action.IAction;
import com.senla.hotel.ui.model.action.util.UtilScanner;

public class FileSaveServiceAction implements IAction {
    //Сохранение данных услуг в файл
    @Override
    public void execute() {
        System.out.println("Enter name of file for save Service data");
        Application.fileSaveService(UtilScanner.stringScanner());
    }
}
