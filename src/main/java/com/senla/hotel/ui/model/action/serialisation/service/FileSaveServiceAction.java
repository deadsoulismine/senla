package com.senla.hotel.ui.model.action.serialisation.service;

import com.senla.hotel.backend.service.IService;
import com.senla.hotel.ui.model.action.IAction;
import com.senla.hotel.util.dependency.annotation.Autowired;
import com.senla.hotel.util.dependency.stereotype.Component;
import scanner.IScannerService;

@Component
public class FileSaveServiceAction implements IAction {
    @Autowired(className = "ServiceImpl")
    private IService service;
    @Autowired(className = "ScannerService")
    private IScannerService utilScanner;

    //Сохранение данных услуг в файл
    @Override
    public void execute() {
        System.out.println("Enter name of file for save Service data");
        service.fileSaveService(utilScanner.stringScanner());
    }

}
