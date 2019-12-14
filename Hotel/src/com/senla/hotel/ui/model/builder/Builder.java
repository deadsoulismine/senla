package com.senla.hotel.ui.model.builder;

import com.senla.hotel.ui.model.action.Exit;
import com.senla.hotel.ui.model.action.objects.guest.AddGuestAction;
import com.senla.hotel.ui.model.action.objects.guest.DeleteGuestAction;
import com.senla.hotel.ui.model.action.objects.room.AddRoomAction;
import com.senla.hotel.ui.model.action.objects.room.ChangeRoomPriceAction;
import com.senla.hotel.ui.model.action.objects.room.ChangeRoomStatusAction;
import com.senla.hotel.ui.model.action.objects.room.DeleteRoomAction;
import com.senla.hotel.ui.model.action.objects.service.AddServiceAction;
import com.senla.hotel.ui.model.action.objects.service.ChangeServicePriceAction;
import com.senla.hotel.ui.model.action.objects.service.DeleteServiceAction;
import com.senla.hotel.ui.model.action.residence.EvictAction;
import com.senla.hotel.ui.model.action.residence.SettleAction;
import com.senla.hotel.ui.model.action.serialisation.guest.FileLoadGuestAction;
import com.senla.hotel.ui.model.action.serialisation.guest.FileSaveGuestAction;
import com.senla.hotel.ui.model.action.serialisation.room.FileLoadRoomAction;
import com.senla.hotel.ui.model.action.serialisation.room.FileSaveRoomAction;
import com.senla.hotel.ui.model.action.serialisation.service.FileLoadServiceAction;
import com.senla.hotel.ui.model.action.serialisation.service.FileSaveServiceAction;
import com.senla.hotel.ui.model.menu.Menu;
import com.senla.hotel.ui.model.menu.MenuItem;

public class Builder implements IBuilder {
    @Override
    public Menu buildMenu() {
        Menu mainMenu = new Menu("| Welcome to menu for manage Hotel. Choose the action: |", null);
        Menu objectsAddMenu = new Menu("| Choose the item for add: |", mainMenu);
        Menu objectsDeleteMenu = new Menu("| Choose the item for delete: |", mainMenu);
        Menu changeMenu = new Menu("| Choose the item, which you need to change: |", mainMenu);
        Menu residenceMenu = new Menu("| Choose the action: |", mainMenu);
        Menu changeRoomMenu = new Menu("| Choose the change: |", changeMenu);
        Menu changeGuestMenu = new Menu("| Choose the change: |", changeMenu);
        Menu changeServiceMenu = new Menu("| Choose the change: |", changeMenu);
        Menu serialisationMenu = new Menu("| Menu for choice Load or Save data |", mainMenu);
        Menu loadObjects = new Menu("| Choose the object for load data |", mainMenu);
        Menu saveObjects = new Menu("| Choose the object for save data |", mainMenu);

        mainMenu.addMenuItem(new MenuItem("Add object", objectsAddMenu, null));
        mainMenu.addMenuItem(new MenuItem("Delete object", objectsDeleteMenu, null));
        mainMenu.addMenuItem(new MenuItem("Change object", changeMenu, null));
        mainMenu.addMenuItem(new MenuItem("Settle/Evict guest", residenceMenu, null));
        mainMenu.addMenuItem(new MenuItem("Load/Save data", serialisationMenu, null));
        mainMenu.addMenuItem(new MenuItem("Exit", null, new Exit()));

        objectsAddMenu.addMenuItem(new MenuItem("Add new room", null, new AddRoomAction()));
        objectsAddMenu.addMenuItem(new MenuItem("Add new guest", null, new AddGuestAction()));
        objectsAddMenu.addMenuItem(new MenuItem("Add new service", null, new AddServiceAction()));
        objectsAddMenu.addMenuItem(new MenuItem("Back", objectsAddMenu.getPrevMenu(), null));

        objectsDeleteMenu.addMenuItem(new MenuItem("Delete room", null, new DeleteRoomAction()));
        objectsDeleteMenu.addMenuItem(new MenuItem("Delete guest", null, new DeleteGuestAction()));
        objectsDeleteMenu.addMenuItem(new MenuItem("Delete service", null, new DeleteServiceAction()));
        objectsDeleteMenu.addMenuItem(new MenuItem("Back", objectsDeleteMenu.getPrevMenu(), null));

        changeMenu.addMenuItem(new MenuItem("Room", changeRoomMenu, null));
        changeMenu.addMenuItem(new MenuItem("Guest", changeGuestMenu, null));
        changeMenu.addMenuItem(new MenuItem("Service", changeServiceMenu, null));
        changeMenu.addMenuItem(new MenuItem("Back", changeMenu.getPrevMenu(), null));

        changeRoomMenu.addMenuItem(new MenuItem("Price of room", null, new ChangeRoomPriceAction()));
        //changeRoomMenu.addMenuItem(new MenuItem("Number of room", null, null));
        changeRoomMenu.addMenuItem(new MenuItem("Status of room", null, new ChangeRoomStatusAction()));
        changeRoomMenu.addMenuItem(new MenuItem("Back", changeRoomMenu.getPrevMenu(), null));

        //changeGuestMenu.addMenuItem(new MenuItem("Name of guest", null, null));
        //changeGuestMenu.addMenuItem(new MenuItem("Age of guest", null, null));
        changeGuestMenu.addMenuItem(new MenuItem("Back", changeGuestMenu.getPrevMenu(), null));

        //changeServiceMenu.addMenuItem(new MenuItem("Title of service", null, null));
        changeServiceMenu.addMenuItem(new MenuItem("Price of service", null,
                new ChangeServicePriceAction()));
        changeServiceMenu.addMenuItem(new MenuItem("Back", changeServiceMenu.getPrevMenu(), null));

        residenceMenu.addMenuItem(new MenuItem("Settle", null, new SettleAction()));
        residenceMenu.addMenuItem(new MenuItem("Evict", null, new EvictAction()));
        //residenceMenu.addMenuItem(new MenuItem("List of busy rooms", null, null));
        residenceMenu.addMenuItem(new MenuItem("Back", residenceMenu.getPrevMenu(), null));

        serialisationMenu.addMenuItem(new MenuItem("Load data from file", loadObjects, new FileLoadRoomAction()));
        serialisationMenu.addMenuItem(new MenuItem("Save data to file", saveObjects, new FileSaveRoomAction()));
        serialisationMenu.addMenuItem(new MenuItem("Back", serialisationMenu.getPrevMenu(), null));

        loadObjects.addMenuItem(new MenuItem("Room", null, new FileLoadRoomAction()));
        loadObjects.addMenuItem(new MenuItem("Guest", null, new FileLoadGuestAction()));
        loadObjects.addMenuItem(new MenuItem("Service", null, new FileLoadServiceAction()));
        loadObjects.addMenuItem(new MenuItem("Back", serialisationMenu, null));

        saveObjects.addMenuItem(new MenuItem("Room", null, new FileSaveRoomAction()));
        saveObjects.addMenuItem(new MenuItem("Guest", null, new FileSaveGuestAction()));
        saveObjects.addMenuItem(new MenuItem("Service", null, new FileSaveServiceAction()));
        saveObjects.addMenuItem(new MenuItem("Back", serialisationMenu, null));

        return mainMenu;
    }
}
