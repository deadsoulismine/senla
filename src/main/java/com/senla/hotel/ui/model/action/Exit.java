package com.senla.hotel.ui.model.action;

import com.senla.hotel.util.dependency.stereotype.Component;

@Component
public class Exit implements IAction {

    @Override
    public void execute() {
        System.exit(0);
    }
}
