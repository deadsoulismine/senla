package com.senla.hotel.ui.model.action.serialisation.room;

import com.senla.hotel.backend.Application;
import com.senla.hotel.ui.model.action.IAction;
import com.senla.hotel.ui.model.action.util.UtilScanner;

import java.io.IOException;

public class FileLoadRoomAction implements IAction {
    //Загрузка данных номеров из файла
    @Override
    public void execute() throws IOException {
        System.out.println("Enter name of file for load Room data");
        Application.fileLoadRoom(UtilScanner.stringScanner());
    }
}
