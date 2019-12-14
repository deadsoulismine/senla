package com.senla.hotel.ui.model.action.serialisation.service;

import com.senla.hotel.ui.model.action.IAction;
import com.senla.hotel.util.UtilScanner;

import static com.senla.hotel.backend.Application.fileSaveService;

public class FileSaveServiceAction implements IAction {
    //Сохранение данных услуг в файл
    @Override
    public void execute() {
        System.out.println("Enter name of file for save Service data");
        fileSaveService(UtilScanner.stringScanner());
    }
}
