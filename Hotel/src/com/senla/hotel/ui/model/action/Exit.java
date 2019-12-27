package com.senla.hotel.ui.model.action;

import com.senla.hotel.util.DI.annotation.Autowired;
import com.senla.hotel.util.DI.stereotype.Component;
import com.senla.hotel.util.data.IData;

@Component
public class Exit implements IAction {
    @Autowired(className = "Data")
    private IData data;

    @Override
    public void execute() {
        data.saveData();
        System.exit(0);
    }
}
