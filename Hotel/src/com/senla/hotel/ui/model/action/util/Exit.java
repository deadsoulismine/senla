package com.senla.hotel.ui.model.action.util;

import com.senla.hotel.ui.model.action.IAction;

public class Exit implements IAction {
    @Override
    public void execute() {
        System.exit(0);
    }
}
