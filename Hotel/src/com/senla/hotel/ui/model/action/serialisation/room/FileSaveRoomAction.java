package com.senla.hotel.ui.model.action.serialisation.room;

import com.senla.hotel.backend.Application;
import com.senla.hotel.ui.model.action.IAction;
import com.senla.hotel.ui.model.action.util.UtilScanner;

public class FileSaveRoomAction implements IAction {
    //Сохранение данных номеров в файл
    @Override
    public void execute() {
        System.out.println("Enter name of file for save Room data");
        Application.fileSaveRoom(UtilScanner.stringScanner());
    }
}
