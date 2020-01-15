package com.senla.hotel.ui.model.action.objects.room;

import com.senla.hotel.backend.service.IService;
import com.senla.hotel.ui.exception.ListIsEmptyException;
import com.senla.hotel.ui.exception.ObjectNotExistException;
import com.senla.hotel.ui.model.action.IAction;
import com.senla.hotel.util.DI.annotation.Autowired;
import com.senla.hotel.util.DI.stereotype.Component;
import com.senla.hotel.util.scanner.IScannerService;


@Component
public class DeleteRoomAction implements IAction {
    @Autowired(className = "ServiceImpl")
    private IService service;
    @Autowired(className = "ScannerService")
    private IScannerService utilScanner;

    //Удаляем номер из списка
    @Override
    public void execute() throws InterruptedException {
        Thread thread = new Thread(() -> {
            try {
                service.printRoomList();
            } catch (ListIsEmptyException e) {
                e.printStackTrace();
            }
            System.out.println("Enter number of room for delete");
            try {
                service.deleteRoom(utilScanner.intScanner());
            } catch (ObjectNotExistException | ListIsEmptyException e) {
                e.printStackTrace();
            }
        });
        thread.start();
        thread.join();
        thread.interrupt();
    }

}
