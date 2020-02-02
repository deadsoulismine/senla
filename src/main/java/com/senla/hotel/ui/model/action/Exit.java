package com.senla.hotel.ui.model.action;

import com.senla.hotel.util.data.IData;
import com.senla.hotel.util.dependency.annotation.Autowired;
import com.senla.hotel.util.dependency.stereotype.Component;
import com.senla.hotel.util.mail.IMail;

@Component
public class Exit implements IAction {
    @Autowired(className = "Data")
    private IData data;
    @Autowired(className = "Mail")
    private IMail mail;

    @Override
    public void execute() {
        System.exit(0);
    }
}
