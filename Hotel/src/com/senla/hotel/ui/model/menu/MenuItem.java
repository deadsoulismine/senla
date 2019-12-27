package com.senla.hotel.ui.model.menu;

import com.senla.hotel.ui.model.action.IAction;
import com.senla.hotel.util.DI.stereotype.Component;

@Component(type = "Instance")
public class MenuItem {
    private String title;
    private Menu nextMenu;
    private IAction action;

    public MenuItem(String title, Menu nextMenu, IAction action) {
        this.title = title;
        this.nextMenu = nextMenu;
        this.action = action;
    }

    public String getTitle() {
        return title;
    }

    public Menu getNextMenu() {
        return nextMenu;
    }

    public IAction getAction() {
        return action;
    }

    public void setAction(IAction action) {
        this.action = action;
    }

}
