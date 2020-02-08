package com.senla.hotel.ui.model.action.serialisation.guest;

import com.senla.hotel.backend.service.IService;
import com.senla.hotel.ui.model.action.IAction;
import com.senla.hotel.util.dependency.annotation.Autowired;
import com.senla.hotel.util.dependency.stereotype.Component;
import com.senla.hotel.util.scanner.IScannerService;

@Component
public class FileSaveGuestAction implements IAction {
    @Autowired(className = "ServiceImpl")
    private IService service;
    @Autowired(className = "ScannerService")
    private IScannerService utilScanner;

    //Сохранение данных постояльцев в файл
    @Override
    public void execute() {
        System.out.println("Enter name of file for save Guest data");
        service.fileSaveGuest(utilScanner.stringScanner());
    }

}
