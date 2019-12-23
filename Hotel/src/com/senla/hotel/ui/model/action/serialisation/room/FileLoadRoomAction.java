package com.senla.hotel.ui.model.action.serialisation.room;

import com.senla.hotel.backend.Application;
import com.senla.hotel.ui.model.action.IAction;
import com.senla.hotel.util.DI.annotation.Autowired;
import com.senla.hotel.util.DI.stereotype.Component;
import com.senla.hotel.util.scanner.IUtilScanner;

@Component
public class FileLoadRoomAction implements IAction {
    @Autowired(className = "UtilScanner")
    private IUtilScanner utilScanner;

    //Загрузка данных номеров из файла
    @Override
    public void execute() {
        System.out.println("Enter name of file for load Room data");
        Application.fileLoadRoom(utilScanner.stringScanner());
    }
}
