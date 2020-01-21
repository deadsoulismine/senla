package com.senla.hotel.ui.model.action.serialisation.room;

import com.senla.hotel.backend.service.IService;
import com.senla.hotel.ui.model.action.IAction;
import com.senla.hotel.util.DI.annotation.Autowired;
import com.senla.hotel.util.DI.stereotype.Component;
import com.senla.hotel.util.scanner.IScannerService;

@Component
public class FileLoadRoomAction implements IAction {
    @Autowired(className = "ServiceImpl")
    private IService service;
    @Autowired(className = "ScannerService")
    private IScannerService utilScanner;

    //Загрузка данных номеров из файла
    @Override
    public void execute() {
        System.out.println("Enter name of file for load Room data");
        service.fileLoadRoom(utilScanner.stringScanner());
    }

}
