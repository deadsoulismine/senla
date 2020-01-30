package com.senla.hotel.ui.model.action.objects.guest;

import com.senla.hotel.backend.service.IService;
import com.senla.hotel.ui.model.action.IAction;
import com.senla.hotel.util.dependency.annotation.Autowired;
import com.senla.hotel.util.dependency.stereotype.Component;
import com.senla.hotel.util.scanner.IScannerService;

import java.sql.SQLException;

@Component
public class AddGuestAction implements IAction {
    @Autowired(className = "ScannerService")
    private IScannerService utilScanner;
    @Autowired(className = "ServiceImpl")
    private IService service;

    @Override
    public void execute() throws ReflectiveOperationException, SQLException {
        System.out.println("Enter name of new guest");
        String name = utilScanner.stringScanner();
        System.out.println("Enter age of new guest");
        int age = utilScanner.intScanner();
        service.addGuest(name, age);
    }

}
