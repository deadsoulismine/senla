package com.senla.hotel.ui.model.action.residence;

import com.senla.hotel.backend.service.IService;
import com.senla.hotel.ui.exception.ListIsEmptyException;
import com.senla.hotel.ui.exception.ObjectNotExistException;
import com.senla.hotel.ui.model.action.IAction;
import com.senla.hotel.util.DI.annotation.Autowired;
import com.senla.hotel.util.DI.stereotype.Component;
import com.senla.hotel.util.scanner.IScannerService;

@Component
public class SettleAction implements IAction {
    @Autowired(className = "ServiceImpl")
    private IService service;
    @Autowired(className = "ScannerService")
    private IScannerService utilScanner;

    //Заселение
    @Override
    public void execute() throws InterruptedException {
        Thread thread = new Thread(() -> {
            try {
                service.printWaitingGuests();
            } catch (ListIsEmptyException e) {
                e.printStackTrace();
            }
            System.out.println("Enter ID of guest for settle");
            int idGuest = utilScanner.intScanner();
            try {
                service.printFreeRoomList();
            } catch (ListIsEmptyException e) {
                e.printStackTrace();
            }
            System.out.println("Enter number of free room");
            int roomNumber = utilScanner.intScanner();
            try {
                service.settle(idGuest, roomNumber);
            } catch (ObjectNotExistException e) {
                e.printStackTrace();
            }
        });
        thread.start();
        thread.join();
        thread.interrupt();
    }

}
