package com.senla.hotel.ui.model.navigator;

import com.senla.hotel.ui.exception.IndexException;
import com.senla.hotel.ui.exception.ListIsEmptyException;
import com.senla.hotel.ui.exception.ObjectNotExistException;
import com.senla.hotel.ui.exception.SameObjectsException;
import com.senla.hotel.ui.model.menu.Menu;
import com.senla.hotel.ui.view.IViewController;
import com.senla.hotel.util.dependency.annotation.Autowired;
import com.senla.hotel.util.dependency.stereotype.Component;

import java.io.IOException;
import java.sql.SQLException;

@Component
public class Navigator implements INavigator {
    private static Menu currentMenu;

    @Autowired(className = "ViewController")
    private IViewController viewController;

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
                    byte finalIndex = index;
                    Thread thread = new Thread(() -> {
                        try {
                            currentMenu.getItems().get(finalIndex).getAction().execute();
                        } catch (IOException | InterruptedException | ReflectiveOperationException |
                                SameObjectsException | ObjectNotExistException |
                                ListIsEmptyException | SQLException e) {
                            System.out.println(e.getMessage());
                        }
                    });
                    thread.start();
                    thread.join();
                }
            }
        } catch (IndexException e) {
            System.out.println(e.getMessage());
        }
    }

}
