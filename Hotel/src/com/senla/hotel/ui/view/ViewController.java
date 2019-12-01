package com.senla.hotel.ui.view;

import com.senla.hotel.ui.model.menu.Menu;
import com.senla.hotel.ui.model.menu.MenuItem;

public class ViewController {

    public void printTitle(Menu currentMenu) {
        System.out.println(currentMenu.getTitle());
    }

    public void printList(Menu currentMenu) {
        for (MenuItem n : currentMenu.getItems()) {
            System.out.println(n.getTitle());
        }
    }

}
