package com.senla.hotel.ui.model.navigator;

import com.senla.hotel.ui.exception.IndexException;
import com.senla.hotel.ui.model.menu.Menu;
import com.senla.hotel.ui.view.IViewController;
import com.senla.hotel.util.DI.annotation.Autowired;
import com.senla.hotel.util.DI.stereotype.Component;

import java.io.IOException;

@Component
public class Navigator implements INavigator {
    private static Menu currentMenu;

    @Autowired(className = "ViewController")
    IViewController viewController;

    public void setCurrentMenu(Menu currentMenu) {
        Navigator.currentMenu = currentMenu;
    }

    @Override
    public void printMenu() {
        viewController.printTitle(currentMenu);
        viewController.printMenuItemList(currentMenu);
    }

    @Override
    public void navigate(byte index) throws Exception {
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
        } catch (IndexException | IOException | ReflectiveOperationException e) {
            System.out.println(e.getMessage());
        }
    }

}
