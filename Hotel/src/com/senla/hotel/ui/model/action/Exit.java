package com.senla.hotel.ui.model.action;

import com.senla.hotel.util.Data;

public class Exit implements IAction {
    @Override
    public void execute() {
        Data.saveData();
        System.exit(0);
    }
}
