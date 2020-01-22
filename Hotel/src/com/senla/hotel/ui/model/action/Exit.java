package com.senla.hotel.ui.model.action;

import com.senla.hotel.util.DI.annotation.Autowired;
import com.senla.hotel.util.DI.stereotype.Component;
import com.senla.hotel.util.data.IData;
import com.senla.hotel.util.mail.IMail;

@Component
public class Exit implements IAction {
    @Autowired(className = "Data")
    private IData data;
    @Autowired(className = "Mail")
    private IMail mail;

    @Override
    public void execute() {
        data.saveData();
        mail.closeThread();
        System.exit(0);
    }
}
