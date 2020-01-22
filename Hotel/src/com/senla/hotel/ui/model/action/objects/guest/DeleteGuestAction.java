package com.senla.hotel.ui.model.action.objects.guest;

import com.senla.hotel.backend.service.IService;
import com.senla.hotel.ui.exception.ListIsEmptyException;
import com.senla.hotel.ui.exception.ObjectNotExistException;
import com.senla.hotel.ui.model.action.IAction;
import com.senla.hotel.util.DI.annotation.Autowired;
import com.senla.hotel.util.DI.stereotype.Component;
import com.senla.hotel.util.scanner.IScannerService;

@Component
public class DeleteGuestAction implements IAction {
    @Autowired(className = "ServiceImpl")
    private IService service;
    @Autowired(className = "ScannerService")
    private IScannerService utilScanner;

    //Удаляем постояльца из списка
    @Override
    public void execute() throws InterruptedException {
        Thread thread = new Thread(() -> {
            try {
                service.printGuestList();
            } catch (ListIsEmptyException e) {
                System.out.println(e);
            }
            System.out.println("Enter ID of guest for delete");
            try {
                service.deleteGuest(utilScanner.intScanner());
            } catch (ObjectNotExistException e) {
                System.out.println(e);
            }
        });
        thread.start();
        thread.join();
        thread.interrupt();
    }
}
