package com.senla.hotel.ui.model.builder;

import com.senla.hotel.ui.model.menu.Menu;
import com.senla.hotel.ui.model.menu.MenuItem;

public class Builder implements IBuilder {
    @Override
    public Menu buildMenu() {
        Menu mainMenu = new Menu("Welcome, choose the action, please", null);
        Menu objectsMenu = new Menu("Choose the item, please", mainMenu);
        Menu addMenu = new Menu("Enter fields of the new item, please", objectsMenu);
        Menu deleteMenu = new Menu("Enter the item for delete, please", objectsMenu);
        Menu loadMenu = new Menu("Enter the name of file for read", mainMenu);
        Menu saveMenu = new Menu("Enter the name of file for save", mainMenu);

        mainMenu.addMenuItem(new MenuItem("Add object", objectsMenu, null));
        mainMenu.addMenuItem(new MenuItem("Delete object", objectsMenu, null));
        mainMenu.addMenuItem(new MenuItem("Load data from file", loadMenu));
        mainMenu.addMenuItem(new MenuItem("Save data to file", saveMenu));
        mainMenu.addMenuItem(new MenuItem("Exit", null));

        objectsMenu.addMenuItem(new MenuItem("Room", addMenu, null));
        objectsMenu.addMenuItem(new MenuItem("Guest", addMenu, null));
        objectsMenu.addMenuItem(new MenuItem("Service",addMenu, null));

        objectsMenu.addMenuItem(new MenuItem("Room", deleteMenu, null));
        objectsMenu.addMenuItem(new MenuItem("Guest", deleteMenu, null));
        objectsMenu.addMenuItem(new MenuItem("Service", deleteMenu, null));

        objectsMenu.addMenuItem(new MenuItem("Back",null, null));

        return mainMenu;
    }
}
