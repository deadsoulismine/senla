package com.senla.hotel.ui.model.action.serialisation.room;

import com.senla.hotel.ui.model.action.IAction;
import com.senla.hotel.util.UtilScanner;

import static com.senla.hotel.backend.Application.fileSaveRoom;

public class FileSaveRoomAction implements IAction {
    //Сохранение данных номеров в файл
    @Override
    public void execute() {
        System.out.println("Enter name of file for save Room data");
        fileSaveRoom(UtilScanner.stringScanner());
    }
}
