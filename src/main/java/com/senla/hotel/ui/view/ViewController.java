package com.senla.hotel.ui.view;

import com.senla.hotel.ui.model.menu.Menu;
import com.senla.hotel.util.dependency.stereotype.Component;

@Component
public class ViewController implements IViewController {
    @Override
    public void printTitle(Menu currentMenu) {
        System.out.println(currentMenu.getTitle());
    }

    @Override
    public void printMenuItemList(Menu currentMenu) {
        for (int i = 0; i < currentMenu.getItems().size(); i++) {
            System.out.println("# " + (i + 1) + ": " + currentMenu.getItems().get(i).getTitle());
        }
    }

}
