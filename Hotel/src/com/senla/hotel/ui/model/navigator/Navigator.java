package com.senla.hotel.ui.model.navigator;

import com.senla.hotel.ui.model.menu.Menu;
import com.senla.hotel.ui.view.ViewController;

import java.io.IOException;

public class Navigator implements INavigator {
    private Menu currentMenu;
    ViewController viewController = new ViewController();

    public Menu getCurrentMenu() {
        return currentMenu;
    }

    public void setCurrentMenu(Menu currentMenu) {
        this.currentMenu = currentMenu;
    }

    @Override
    public void printMenu() {
        viewController.printTitle(currentMenu);
        viewController.printList(currentMenu);
    }

    @Override
    public void navigate(byte index) throws IOException {
        index--;
        if (currentMenu.getItems().get(index).getNextMenu() != null) {
            currentMenu = currentMenu.getItems().get(index).getNextMenu();
        } else {
            currentMenu.getItems().get(index).getAction().execute();
        }
    }
}
