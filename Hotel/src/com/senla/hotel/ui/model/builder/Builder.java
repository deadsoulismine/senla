package com.senla.hotel.ui.model.builder;

import com.senla.hotel.ui.model.action.IAction;
import com.senla.hotel.ui.model.menu.Menu;
import com.senla.hotel.ui.model.menu.MenuItem;
import com.senla.hotel.util.DI.BeanFactory;
import com.senla.hotel.util.DI.annotation.Autowired;
import com.senla.hotel.util.DI.stereotype.Component;

@Component
public class Builder implements IBuilder {
    @Autowired(className = "BeanFactory")
    BeanFactory beanFactory;

    @Override
    public Menu buildMenu() throws ReflectiveOperationException {
        MenuItem tempMenuItem;

        Menu mainMenu = (Menu) beanFactory.instantiateInstance("Menu");
        mainMenu.setTitle("| Welcome to menu for manage Hotel. Choose the action: |");
        mainMenu.setPrevMenu(null);

        Menu objectsAddMenu = (Menu) beanFactory.instantiateInstance("Menu");
        objectsAddMenu.setTitle("| Choose the item for add: |");
        objectsAddMenu.setPrevMenu(mainMenu);

        Menu objectsDeleteMenu = (Menu) beanFactory.instantiateInstance("Menu");
        objectsDeleteMenu.setTitle("| Choose the item for delete: |");
        objectsDeleteMenu.setPrevMenu(mainMenu);

        Menu changeMenu = (Menu) beanFactory.instantiateInstance("Menu");
        changeMenu.setTitle("| Choose the item, which you need to change: |");
        changeMenu.setPrevMenu(mainMenu);

        Menu residenceMenu = (Menu) beanFactory.instantiateInstance("Menu");
        residenceMenu.setTitle("| Choose the action: |");
        residenceMenu.setPrevMenu(mainMenu);

        Menu changeRoomMenu = (Menu) beanFactory.instantiateInstance("Menu");
        changeRoomMenu.setTitle("| Choose the change: |");
        changeRoomMenu.setPrevMenu(changeMenu);

        Menu changeGuestMenu = (Menu) beanFactory.instantiateInstance("Menu");
        changeGuestMenu.setTitle("| Choose the change: |");
        changeGuestMenu.setPrevMenu(changeMenu);

        Menu changeServiceMenu = (Menu) beanFactory.instantiateInstance("Menu");
        changeServiceMenu.setTitle("| Choose the change: |");
        changeServiceMenu.setPrevMenu(changeMenu);

        Menu serialisationMenu = (Menu) beanFactory.instantiateInstance("Menu");
        serialisationMenu.setTitle("| Menu for choice Load or Save data |");
        serialisationMenu.setPrevMenu(mainMenu);

        Menu loadObjects = (Menu) beanFactory.instantiateInstance("Menu");
        loadObjects.setTitle("| Choose the object for load data |");
        loadObjects.setPrevMenu(mainMenu);

        Menu saveObjects = (Menu) beanFactory.instantiateInstance("Menu");
        saveObjects.setTitle("| Choose the object for save data |");
        saveObjects.setPrevMenu(mainMenu);

        tempMenuItem = (MenuItem) beanFactory.instantiateInstance("MenuItem");
        tempMenuItem.setTitle("Add object");
        tempMenuItem.setNextMenu(objectsAddMenu);
        tempMenuItem.setAction(null);
        mainMenu.addMenuItem(tempMenuItem);

        tempMenuItem = (MenuItem) beanFactory.instantiateInstance("MenuItem");
        tempMenuItem.setTitle("Delete object");
        tempMenuItem.setNextMenu(objectsDeleteMenu);
        tempMenuItem.setAction(null);
        mainMenu.addMenuItem(tempMenuItem);

        tempMenuItem = (MenuItem) beanFactory.instantiateInstance("MenuItem");
        tempMenuItem.setTitle("Change object");
        tempMenuItem.setNextMenu(changeMenu);
        tempMenuItem.setAction(null);
        mainMenu.addMenuItem(tempMenuItem);

        tempMenuItem = (MenuItem) beanFactory.instantiateInstance("MenuItem");
        tempMenuItem.setTitle("Settle/Evict guest");
        tempMenuItem.setNextMenu(residenceMenu);
        tempMenuItem.setAction(null);
        mainMenu.addMenuItem(tempMenuItem);

        tempMenuItem = (MenuItem) beanFactory.instantiateInstance("MenuItem");
        tempMenuItem.setTitle("Load/Save data");
        tempMenuItem.setNextMenu(serialisationMenu);
        tempMenuItem.setAction(null);
        mainMenu.addMenuItem(tempMenuItem);

        tempMenuItem = (MenuItem) beanFactory.instantiateInstance("MenuItem");
        tempMenuItem.setTitle("Exit");
        tempMenuItem.setNextMenu(null);
        tempMenuItem.setAction((IAction) BeanFactory.getBean("Exit"));
        mainMenu.addMenuItem(tempMenuItem);

        tempMenuItem = (MenuItem) beanFactory.instantiateInstance("MenuItem");
        tempMenuItem.setTitle("Add new room");
        tempMenuItem.setNextMenu(null);
        tempMenuItem.setAction((IAction) BeanFactory.getBean("AddRoomAction"));
        objectsAddMenu.addMenuItem(tempMenuItem);

        tempMenuItem = (MenuItem) beanFactory.instantiateInstance("MenuItem");
        tempMenuItem.setTitle("Add new guest");
        tempMenuItem.setNextMenu(null);
        tempMenuItem.setAction((IAction) BeanFactory.getBean("AddGuestAction"));
        objectsAddMenu.addMenuItem(tempMenuItem);

        tempMenuItem = (MenuItem) beanFactory.instantiateInstance("MenuItem");
        tempMenuItem.setTitle("Add new service");
        tempMenuItem.setNextMenu(null);
        tempMenuItem.setAction((IAction) BeanFactory.getBean("AddServiceAction"));
        objectsAddMenu.addMenuItem(tempMenuItem);

        tempMenuItem = (MenuItem) beanFactory.instantiateInstance("MenuItem");
        tempMenuItem.setTitle("Back");
        tempMenuItem.setNextMenu(objectsAddMenu.getPrevMenu());
        tempMenuItem.setAction(null);
        objectsAddMenu.addMenuItem(tempMenuItem);

        tempMenuItem = (MenuItem) beanFactory.instantiateInstance("MenuItem");
        tempMenuItem.setTitle("Delete room");
        tempMenuItem.setNextMenu(null);
        tempMenuItem.setAction((IAction) BeanFactory.getBean("DeleteRoomAction"));
        objectsDeleteMenu.addMenuItem(tempMenuItem);

        tempMenuItem = (MenuItem) beanFactory.instantiateInstance("MenuItem");
        tempMenuItem.setTitle("Delete guest");
        tempMenuItem.setNextMenu(null);
        tempMenuItem.setAction((IAction) BeanFactory.getBean("DeleteGuestAction"));
        objectsDeleteMenu.addMenuItem(tempMenuItem);

        tempMenuItem = (MenuItem) beanFactory.instantiateInstance("MenuItem");
        tempMenuItem.setTitle("Delete service");
        tempMenuItem.setNextMenu(null);
        tempMenuItem.setAction((IAction) BeanFactory.getBean("DeleteServiceAction"));
        objectsDeleteMenu.addMenuItem(tempMenuItem);

        tempMenuItem = (MenuItem) beanFactory.instantiateInstance("MenuItem");
        tempMenuItem.setTitle("Back");
        tempMenuItem.setNextMenu(objectsDeleteMenu.getPrevMenu());
        tempMenuItem.setAction(null);
        objectsDeleteMenu.addMenuItem(tempMenuItem);

        tempMenuItem = (MenuItem) beanFactory.instantiateInstance("MenuItem");
        tempMenuItem.setTitle("Room");
        tempMenuItem.setNextMenu(changeRoomMenu);
        tempMenuItem.setAction(null);
        changeMenu.addMenuItem(tempMenuItem);

        tempMenuItem = (MenuItem) beanFactory.instantiateInstance("MenuItem");
        tempMenuItem.setTitle("Guest");
        tempMenuItem.setNextMenu(changeGuestMenu);
        tempMenuItem.setAction(null);
        changeMenu.addMenuItem(tempMenuItem);

        tempMenuItem = (MenuItem) beanFactory.instantiateInstance("MenuItem");
        tempMenuItem.setTitle("Service");
        tempMenuItem.setNextMenu(changeServiceMenu);
        tempMenuItem.setAction(null);
        changeMenu.addMenuItem(tempMenuItem);

        tempMenuItem = (MenuItem) beanFactory.instantiateInstance("MenuItem");
        tempMenuItem.setTitle("Back");
        tempMenuItem.setNextMenu(changeMenu.getPrevMenu());
        tempMenuItem.setAction(null);
        changeMenu.addMenuItem(tempMenuItem);

        tempMenuItem = (MenuItem) beanFactory.instantiateInstance("MenuItem");
        tempMenuItem.setTitle("Price of room");
        tempMenuItem.setNextMenu(null);
        tempMenuItem.setAction((IAction) beanFactory.getBean("ChangeRoomPriceAction"));
        changeRoomMenu.addMenuItem(tempMenuItem);

//        //changeRoomMenu.addMenuItem(new MenuItem("Number of room", null, null));

        tempMenuItem = (MenuItem) beanFactory.instantiateInstance("MenuItem");
        tempMenuItem.setTitle("Status of room");
        tempMenuItem.setNextMenu(null);
        tempMenuItem.setAction((IAction) beanFactory.getBean("ChangeRoomStatusAction"));
        changeRoomMenu.addMenuItem(tempMenuItem);

        tempMenuItem = (MenuItem) beanFactory.instantiateInstance("MenuItem");
        tempMenuItem.setTitle("Back");
        tempMenuItem.setNextMenu(changeRoomMenu.getPrevMenu());
        tempMenuItem.setAction(null);
        changeRoomMenu.addMenuItem(tempMenuItem);

//        //changeGuestMenu.addMenuItem(new MenuItem("Name of guest", null, null));
//        //changeGuestMenu.addMenuItem(new MenuItem("Age of guest", null, null));

        tempMenuItem = (MenuItem) beanFactory.instantiateInstance("MenuItem");
        tempMenuItem.setTitle("Back");
        tempMenuItem.setNextMenu(changeGuestMenu.getPrevMenu());
        tempMenuItem.setAction(null);
        changeGuestMenu.addMenuItem(tempMenuItem);

//        //changeServiceMenu.addMenuItem(new MenuItem("Title of service", null, null));

        tempMenuItem = (MenuItem) beanFactory.instantiateInstance("MenuItem");
        tempMenuItem.setTitle("Price of service");
        tempMenuItem.setNextMenu(null);
        tempMenuItem.setAction((IAction) beanFactory.getBean("ChangeServicePriceAction"));
        changeServiceMenu.addMenuItem(tempMenuItem);

        tempMenuItem = (MenuItem) beanFactory.instantiateInstance("MenuItem");
        tempMenuItem.setTitle("Back");
        tempMenuItem.setNextMenu(changeServiceMenu.getPrevMenu());
        tempMenuItem.setAction(null);
        changeServiceMenu.addMenuItem(tempMenuItem);

        tempMenuItem = (MenuItem) beanFactory.instantiateInstance("MenuItem");
        tempMenuItem.setTitle("Settle");
        tempMenuItem.setNextMenu(null);
        tempMenuItem.setAction((IAction) BeanFactory.getBean("SettleAction"));
        residenceMenu.addMenuItem(tempMenuItem);

        tempMenuItem = (MenuItem) beanFactory.instantiateInstance("MenuItem");
        tempMenuItem.setTitle("Evict");
        tempMenuItem.setNextMenu(null);
        tempMenuItem.setAction((IAction) beanFactory.getBean("EvictAction"));
        residenceMenu.addMenuItem(tempMenuItem);

//        //residenceMenu.addMenuItem(new MenuItem("List of busy rooms", null, null));

        tempMenuItem = (MenuItem) beanFactory.instantiateInstance("MenuItem");
        tempMenuItem.setTitle("Back");
        tempMenuItem.setNextMenu(residenceMenu.getPrevMenu());
        tempMenuItem.setAction(null);
        residenceMenu.addMenuItem(tempMenuItem);

        tempMenuItem = (MenuItem) beanFactory.instantiateInstance("MenuItem");
        tempMenuItem.setTitle("Load data from file");
        tempMenuItem.setNextMenu(loadObjects);
        tempMenuItem.setAction(null);
        serialisationMenu.addMenuItem(tempMenuItem);

        tempMenuItem = (MenuItem) beanFactory.instantiateInstance("MenuItem");
        tempMenuItem.setTitle("Save data to file");
        tempMenuItem.setNextMenu(saveObjects);
        tempMenuItem.setAction(null);
        serialisationMenu.addMenuItem(tempMenuItem);

        tempMenuItem = (MenuItem) beanFactory.instantiateInstance("MenuItem");
        tempMenuItem.setTitle("Back");
        tempMenuItem.setNextMenu(serialisationMenu.getPrevMenu());
        tempMenuItem.setAction(null);
        serialisationMenu.addMenuItem(tempMenuItem);

        tempMenuItem = (MenuItem) beanFactory.instantiateInstance("MenuItem");
        tempMenuItem.setTitle("Room");
        tempMenuItem.setNextMenu(null);
        tempMenuItem.setAction((IAction) beanFactory.getBean("FileLoadRoomAction"));
        loadObjects.addMenuItem(tempMenuItem);

        tempMenuItem = (MenuItem) beanFactory.instantiateInstance("MenuItem");
        tempMenuItem.setTitle("Guest");
        tempMenuItem.setNextMenu(null);
        tempMenuItem.setAction((IAction) beanFactory.getBean("FileLoadGuestAction"));
        loadObjects.addMenuItem(tempMenuItem);

        tempMenuItem = (MenuItem) beanFactory.instantiateInstance("MenuItem");
        tempMenuItem.setTitle("Service");
        tempMenuItem.setNextMenu(null);
        tempMenuItem.setAction((IAction) beanFactory.getBean("FileLoadServiceAction"));
        loadObjects.addMenuItem(tempMenuItem);

        tempMenuItem = (MenuItem) beanFactory.instantiateInstance("MenuItem");
        tempMenuItem.setTitle("Back");
        tempMenuItem.setNextMenu(loadObjects.getPrevMenu());
        tempMenuItem.setAction(null);
        loadObjects.addMenuItem(tempMenuItem);

        tempMenuItem = (MenuItem) beanFactory.instantiateInstance("MenuItem");
        tempMenuItem.setTitle("Room");
        tempMenuItem.setNextMenu(null);
        tempMenuItem.setAction((IAction) beanFactory.getBean("FileSaveRoomAction"));
        saveObjects.addMenuItem(tempMenuItem);

        tempMenuItem = (MenuItem) beanFactory.instantiateInstance("MenuItem");
        tempMenuItem.setTitle("Guest");
        tempMenuItem.setNextMenu(null);
        tempMenuItem.setAction((IAction) beanFactory.getBean("FileSaveGuestAction"));
        saveObjects.addMenuItem(tempMenuItem);

        tempMenuItem = (MenuItem) beanFactory.instantiateInstance("MenuItem");
        tempMenuItem.setTitle("Service");
        tempMenuItem.setNextMenu(null);
        tempMenuItem.setAction((IAction) beanFactory.getBean("FileSaveServiceAction"));
        saveObjects.addMenuItem(tempMenuItem);

        tempMenuItem = (MenuItem) beanFactory.instantiateInstance("MenuItem");
        tempMenuItem.setTitle("Back");
        tempMenuItem.setNextMenu(saveObjects.getPrevMenu());
        tempMenuItem.setAction(null);
        saveObjects.addMenuItem(tempMenuItem);

        return mainMenu;
    }
}
