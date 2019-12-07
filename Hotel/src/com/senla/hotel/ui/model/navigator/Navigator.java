package com.senla.hotel.ui.model.navigator;

import com.senla.hotel.ui.exception.IndexException;
import com.senla.hotel.ui.model.menu.Menu;
import com.senla.hotel.ui.view.ViewController;

import java.io.IOException;

public class Navigator implements INavigator {
    private static Menu currentMenu;
    ViewController viewController = new ViewController();

    public static Menu getCurrentMenu() {
        return currentMenu;
    }

    public void setCurrentMenu(Menu currentMenu) {
        this.currentMenu = currentMenu;
    }

    @Override
    public void printMenu() {
        viewController.printTitle(currentMenu);
        viewController.printMenuItemList(currentMenu);
    }

    @Override
    public void navigate(byte index) throws IndexException {
        index--;
        try {
            if (index >= currentMenu.getItems().size() || index < 0) {
                throw new IndexException("Try again, this menu item is not exist!");
            } else {
                if (currentMenu.getItems().get(index).getNextMenu() != null) {
                    currentMenu = currentMenu.getItems().get(index).getNextMenu();
                } else {
                    currentMenu.getItems().get(index).getAction().execute();
                }
            }
        } catch (IndexException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
