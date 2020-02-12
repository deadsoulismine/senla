package com.senla.hotel.ui.model.action.serialisation.service;

import com.senla.hotel.backend.service.IService;
import com.senla.hotel.ui.model.action.IAction;
import com.senla.hotel.util.dependency.annotation.Autowired;
import com.senla.hotel.util.dependency.stereotype.Component;
import scanner.IScannerService;

@Component
public class FileLoadServiceAction implements IAction {
    @Autowired(className = "ServiceImpl")
    private IService service;
    @Autowired(className = "ScannerService")
    private IScannerService utilScanner;

    //Загрузка данных услуг из файла
    @Override
    public void execute() {
        System.out.println("Enter name of file for load Service data");
        service.fileLoadService(utilScanner.stringScanner());
    }

}
