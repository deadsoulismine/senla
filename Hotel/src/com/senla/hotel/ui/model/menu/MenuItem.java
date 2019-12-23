package com.senla.hotel.ui.model.menu;

import com.senla.hotel.ui.model.action.IAction;
import com.senla.hotel.util.DI.stereotype.Instance;

@Instance
public class MenuItem {
    private String title;
    private Menu nextMenu;
    private IAction action;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Menu getNextMenu() {
        return nextMenu;
    }

    public void setNextMenu(Menu nextMenu) {
        this.nextMenu = nextMenu;
    }

    public IAction getAction() {
        return action;
    }

    public void setAction(IAction action) {
        this.action = action;
    }

}
