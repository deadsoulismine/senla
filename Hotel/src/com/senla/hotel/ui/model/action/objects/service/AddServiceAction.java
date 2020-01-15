package com.senla.hotel.ui.model.action.objects.service;

import com.senla.hotel.backend.service.IService;
import com.senla.hotel.ui.exception.SameObjectsException;
import com.senla.hotel.ui.model.action.IAction;
import com.senla.hotel.util.DI.annotation.Autowired;
import com.senla.hotel.util.DI.stereotype.Component;
import com.senla.hotel.util.scanner.IScannerService;

@Component
public class AddServiceAction implements IAction {
    @Autowired(className = "ServiceImpl")
    private IService service;
    @Autowired(className = "ScannerService")
    private IScannerService utilScanner;

    //Добавляем новую услугу в список
    @Override
    public void execute() throws InterruptedException {
        Thread thread = new Thread(() -> {
            System.out.println("Enter title of new service");
            String title = utilScanner.stringScanner();
            System.out.println("Enter price of new service");
            int price = utilScanner.intScanner();
            try {
                service.addService(price, title);
            } catch (SameObjectsException e) {
                e.printStackTrace();
            }
        });
        thread.start();
        thread.join();
        thread.interrupt();
    }

}
