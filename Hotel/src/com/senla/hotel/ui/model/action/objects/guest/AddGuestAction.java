package com.senla.hotel.ui.model.action.objects.guest;

import com.senla.hotel.backend.Application;
import com.senla.hotel.ui.model.action.IAction;
import com.senla.hotel.util.DI.annotation.Autowired;
import com.senla.hotel.util.DI.stereotype.Component;
import com.senla.hotel.util.scanner.IUtilScanner;

@Component
public class AddGuestAction implements IAction {
    @Autowired(className = "UtilScanner")
    private IUtilScanner utilScanner;

    //Добавляем нового постояльца в список
    @Override
    public void execute() throws ReflectiveOperationException {
        System.out.println("Enter name of new Guest");
        String name = utilScanner.stringScanner();
        System.out.println("Enter age of new Guest");
        int age = utilScanner.intScanner();
        Application.addGuest(name, age);
    }
}
