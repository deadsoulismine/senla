package com.senla.hotel.ui.model.action.serialisation.room;

import com.senla.hotel.backend.Application;
import com.senla.hotel.ui.model.action.IAction;
import com.senla.hotel.util.DI.annotation.Autowired;
import com.senla.hotel.util.DI.stereotype.Component;
import com.senla.hotel.util.scanner.IUtilScanner;

@Component
public class FileSaveRoomAction implements IAction {
    @Autowired(className = "UtilScanner")
    private IUtilScanner utilScanner;

    //Сохранение данных номеров в файл
    @Override
    public void execute() {
        System.out.println("Enter name of file for save Room data");
        Application.fileSaveRoom(utilScanner.stringScanner());
    }
}
