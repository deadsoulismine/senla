package com.senla.hotel.ui.model.action.serialisation.guest;

import com.senla.hotel.backend.service.IService;
import com.senla.hotel.ui.model.action.IAction;
import com.senla.hotel.util.DI.annotation.Autowired;
import com.senla.hotel.util.DI.stereotype.Component;
import com.senla.hotel.util.scanner.IScannerService;

@Component
public class FileLoadGuestAction implements IAction {
    @Autowired(className = "ServiceImpl")
    private IService service;
    @Autowired(className = "ScannerService")
    private IScannerService utilScanner;

    //Загрузка данных постояльцев из файла
    @Override
    public void execute() throws InterruptedException {
        Thread thread = new Thread(() -> {
            System.out.println("Enter name of file for load Guest data");
            service.fileLoadGuest(utilScanner.stringScanner());
        });
        thread.start();
        thread.join();
        thread.interrupt();
    }

}
