package com.senla.hotel.ui.view;

import com.senla.hotel.ui.model.menu.Menu;

public class ViewController {

    public void printTitle(Menu currentMenu) {
        System.out.println(currentMenu.getTitle());
    }

    public void printMenuItemList(Menu currentMenu) {
        for (int i = 0; i < currentMenu.getItems().size(); i++) {
            System.out.println("# " + (i + 1) + ": " + currentMenu.getItems().get(i).getTitle());
        }
    }

    public String checkPrint(Object object) {
        if (object != null) {
            return "[Не указано]";
        } else {
            return object.toString();
        }
    }

}
