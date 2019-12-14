package com.senla.hotel.ui.model.action.serialisation.service;

import com.senla.hotel.ui.model.action.IAction;
import com.senla.hotel.util.UtilScanner;

import java.io.IOException;

import static com.senla.hotel.backend.Application.fileLoadService;

public class FileLoadServiceAction implements IAction {
    //Загрузка данных услуг из файла
    @Override
    public void execute() throws IOException {
        System.out.println("Enter name of file for load Service data");
        fileLoadService(UtilScanner.stringScanner());
    }
}
