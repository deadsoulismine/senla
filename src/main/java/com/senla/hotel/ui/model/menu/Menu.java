package com.senla.hotel.ui.model.menu;

import com.senla.hotel.util.dependency.stereotype.Component;

import java.util.ArrayList;
import java.util.Optional;

@Component(type = "Instance")
public class Menu {
    private ArrayList<MenuItem> items = new ArrayList<>();
    private String title;
    private Menu prevMenu;

    public Menu(String title, Menu prevMenu) {
        this.title = title;
        this.prevMenu = prevMenu;
    }

    public Menu getPrevMenu() {
        return prevMenu;
    }

    public String getTitle() {
        return title;
    }

    public ArrayList<MenuItem> getItems() {
        return items;
    }

    //Добавляем новый пункт меню в список
    public void addMenuItem(MenuItem menuItem) {
        Optional.ofNullable(menuItem).ifPresent(getItems()::add);
    }

}
