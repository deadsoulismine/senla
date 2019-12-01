package com.senla.hotel.ui.model.builder;

import com.senla.hotel.ui.model.action.Exit;
import com.senla.hotel.ui.model.action.guest.*;
import com.senla.hotel.ui.model.action.room.*;
import com.senla.hotel.ui.model.action.serialisation.FileLoadAction;
import com.senla.hotel.ui.model.action.serialisation.FileSaveAction;
import com.senla.hotel.ui.model.action.service.*;
import com.senla.hotel.ui.model.menu.Menu;
import com.senla.hotel.ui.model.menu.MenuItem;

public class Builder implements IBuilder {
    @Override
    public Menu buildMenu() {
        Menu mainMenu = new Menu("| Welcome to menu for manage Hotel. Choose the action, please: |", null);
        Menu objectsAddMenu = new Menu("| Choose the item for add, please: |", mainMenu);
        Menu objectsDeleteMenu = new Menu("| Choose the item for delete, please: |", mainMenu);
        Menu serialisation = new Menu("| Menu for Load/Save data |", mainMenu);

        mainMenu.addMenuItem(new MenuItem("Add object", objectsAddMenu, null));
        mainMenu.addMenuItem(new MenuItem("Delete object", objectsDeleteMenu, null));
        mainMenu.addMenuItem(new MenuItem("Load/Save data", serialisation, null));
        mainMenu.addMenuItem(new MenuItem("Exit", null, new Exit()));

        objectsAddMenu.addMenuItem(new MenuItem("Add new room", null, new AddRoomAction()));
        objectsAddMenu.addMenuItem(new MenuItem("Add new guest", null, new AddGuestAction()));
        objectsAddMenu.addMenuItem(new MenuItem("Add new service", null, new AddServiceAction()));
        objectsAddMenu.addMenuItem(new MenuItem("Back", objectsAddMenu.getPrevMenu(), null));

        objectsDeleteMenu.addMenuItem(new MenuItem("Delete room", null, new DeleteRoomAction()));
        objectsDeleteMenu.addMenuItem(new MenuItem("Delete guest", null, new DeleteGuestAction()));
        objectsDeleteMenu.addMenuItem(new MenuItem("Delete service", null, new DeleteServiceAction()));
        objectsDeleteMenu.addMenuItem(new MenuItem("Back", objectsDeleteMenu.getPrevMenu(), null));

        serialisation.addMenuItem(new MenuItem("Load file", null, new FileLoadAction()));
        serialisation.addMenuItem(new MenuItem("Save file", null, new FileSaveAction()));
        serialisation.addMenuItem(new MenuItem("Back", serialisation.getPrevMenu(), null));

        return mainMenu;
    }
}
