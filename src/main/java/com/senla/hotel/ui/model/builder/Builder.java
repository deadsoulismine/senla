package com.senla.hotel.ui.model.builder;

import com.senla.hotel.ui.model.action.IAction;
import com.senla.hotel.ui.model.menu.Menu;
import com.senla.hotel.ui.model.menu.MenuItem;
import com.senla.hotel.util.dependency.IBeanFactory;
import com.senla.hotel.util.dependency.annotation.Autowired;
import com.senla.hotel.util.dependency.stereotype.Component;

@Component
public class Builder implements IBuilder {
    @Autowired(className = "BeanFactory")
    private IBeanFactory beanFactory;

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
        mainMenu.addMenuItem(new MenuItem("Residence", residenceMenu, null));
        mainMenu.addMenuItem(new MenuItem("Load/Save data", serialisationMenu, null));
        mainMenu.addMenuItem(new MenuItem("Exit", null, (IAction) beanFactory.getBean("Exit")));

        objectsAddMenu.addMenuItem(new MenuItem("Add new room", null,
                (IAction) beanFactory.getBean("AddRoomAction")));
        objectsAddMenu.addMenuItem(new MenuItem("Add new guest", null,
                (IAction) beanFactory.getBean("AddGuestAction")));
        objectsAddMenu.addMenuItem(new MenuItem("Add new service", null,
                (IAction) beanFactory.getBean("AddServiceAction")));
        objectsAddMenu.addMenuItem(new MenuItem("Back", objectsAddMenu.getPrevMenu(), null));

        objectsDeleteMenu.addMenuItem(new MenuItem("Delete room", null,
                (IAction) beanFactory.getBean("DeleteRoomAction")));
        objectsDeleteMenu.addMenuItem(new MenuItem("Delete guest", null,
                (IAction) beanFactory.getBean("DeleteGuestAction")));
        objectsDeleteMenu.addMenuItem(new MenuItem("Delete service", null,
                (IAction) beanFactory.getBean("DeleteServicesAction")));
        objectsDeleteMenu.addMenuItem(new MenuItem("Back", objectsDeleteMenu.getPrevMenu(), null));

        changeMenu.addMenuItem(new MenuItem("Room", changeRoomMenu, null));
        changeMenu.addMenuItem(new MenuItem("Guest", changeGuestMenu, null));
        changeMenu.addMenuItem(new MenuItem("Service", changeServiceMenu, null));
        changeMenu.addMenuItem(new MenuItem("Back", changeMenu.getPrevMenu(), null));

        changeRoomMenu.addMenuItem(new MenuItem("Price of room", null,
                (IAction) beanFactory.getBean("ChangeRoomPriceAction")));
        changeRoomMenu.addMenuItem(new MenuItem("Number of room", null,
                (IAction) beanFactory.getBean("ChangeRoomNumberAction")));
        changeRoomMenu.addMenuItem(new MenuItem("Status of room", null,
                (IAction) beanFactory.getBean("ChangeRoomStatusAction")));
        changeRoomMenu.addMenuItem(new MenuItem("Back", changeRoomMenu.getPrevMenu(), null));

        changeGuestMenu.addMenuItem(new MenuItem("Name of guest", null,
                (IAction) beanFactory.getBean("ChangeGuestNameAction")));
        changeGuestMenu.addMenuItem(new MenuItem("Age of guest", null,
                (IAction) beanFactory.getBean("ChangeGuestAgeAction")));
        changeGuestMenu.addMenuItem(new MenuItem("Back", changeGuestMenu.getPrevMenu(), null));

        changeServiceMenu.addMenuItem(new MenuItem("Title of service", null,
                (IAction) beanFactory.getBean("ChangeServiceTitleAction")));
        changeServiceMenu.addMenuItem(new MenuItem("Price of service", null,
                (IAction) beanFactory.getBean("ChangeServicePriceAction")));
        changeServiceMenu.addMenuItem(new MenuItem("Back", changeServiceMenu.getPrevMenu(), null));

        residenceMenu.addMenuItem(new MenuItem("Settle", null, (IAction) beanFactory.getBean("SettleAction")));
        residenceMenu.addMenuItem(new MenuItem("Evict", null, (IAction) beanFactory.getBean("EvictAction")));
        residenceMenu.addMenuItem(new MenuItem("Add to guest service", null,
                (IAction) beanFactory.getBean("AddServicesAction")));
        residenceMenu.addMenuItem(new MenuItem("Delete service from guest", null,
                (IAction) beanFactory.getBean("DeleteServicesAction")));
        //residenceMenu.addMenuItem(new MenuItem("List of busy rooms", null, null));
        residenceMenu.addMenuItem(new MenuItem("Back", residenceMenu.getPrevMenu(), null));

        serialisationMenu.addMenuItem(new MenuItem("Load data from file", loadObjects, null));
        serialisationMenu.addMenuItem(new MenuItem("Save data to file", saveObjects, null));
        serialisationMenu.addMenuItem(new MenuItem("Back", serialisationMenu.getPrevMenu(), null));

        loadObjects.addMenuItem(new MenuItem("Room", null, (IAction) beanFactory.getBean("FileLoadRoomAction")));
        loadObjects.addMenuItem(new MenuItem("Guest", null, (IAction) beanFactory.getBean("FileLoadGuestAction")));
        loadObjects.addMenuItem(new MenuItem("Service", null, (IAction) beanFactory.getBean("FileLoadServiceAction")));
        loadObjects.addMenuItem(new MenuItem("Back", serialisationMenu, null));

        saveObjects.addMenuItem(new MenuItem("Room", null, (IAction) beanFactory.getBean("FileSaveRoomAction")));
        saveObjects.addMenuItem(new MenuItem("Guest", null, (IAction) beanFactory.getBean("FileSaveGuestAction")));
        saveObjects.addMenuItem(new MenuItem("Service", null, (IAction) beanFactory.getBean("FileSaveServiceAction")));
        saveObjects.addMenuItem(new MenuItem("Back", serialisationMenu, null));

        return mainMenu;
    }
}
