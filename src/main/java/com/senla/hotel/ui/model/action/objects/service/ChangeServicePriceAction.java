package com.senla.hotel.ui.model.action.objects.service;

import com.senla.hotel.backend.service.IService;
import com.senla.hotel.ui.exception.ListIsEmptyException;
import com.senla.hotel.ui.exception.ObjectNotExistException;
import com.senla.hotel.ui.model.action.IAction;
import com.senla.hotel.util.dependency.annotation.Autowired;
import com.senla.hotel.util.dependency.stereotype.Component;
import com.senla.hotel.util.scanner.IScannerService;

@Component
public class ChangeServicePriceAction implements IAction {
    @Autowired(className = "ServiceImpl")
    private IService service;
    @Autowired(className = "ScannerService")
    private IScannerService utilScanner;

    //Изменяем стоймость услуги
    @Override
    public void execute() throws ObjectNotExistException, ListIsEmptyException {
        service.printServiceList();
        System.out.println("Enter ID of service for change price");
        int idService = utilScanner.intScanner();
        System.out.println("Enter new price");
        int price = utilScanner.intScanner();
        service.changeServicePrice(idService, price);
    }

}
