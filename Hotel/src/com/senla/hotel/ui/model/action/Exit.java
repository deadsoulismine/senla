package com.senla.hotel.ui.model.action;

public class Exit implements IAction {
    @Override
    public void execute() {
        System.exit(0);
    }
}
