package com.senla.hotel.ui.model.action.serialisation.room;

import com.senla.hotel.ui.model.action.IAction;
import com.senla.hotel.util.UtilScanner;

import java.io.IOException;

import static com.senla.hotel.backend.Application.fileLoadRoom;

public class FileLoadRoomAction implements IAction {
    //Загрузка данных номеров из файла
    @Override
    public void execute() throws IOException {
        System.out.println("Enter name of file for load Room data");
        fileLoadRoom(UtilScanner.stringScanner());
    }
}
