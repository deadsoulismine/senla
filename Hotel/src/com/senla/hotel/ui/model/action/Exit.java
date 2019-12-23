package com.senla.hotel.ui.model.action;

import com.senla.hotel.util.DI.annotation.Autowired;
import com.senla.hotel.util.DI.stereotype.Component;
import com.senla.hotel.util.data.Data;

@Component
public class Exit implements IAction {
    @Autowired
    Data data;

    public void setData(Data data) {
        this.data = data;
    }

    @Override
    public void execute() {
        data.saveData();
        System.exit(0);
    }
}
