package com.senla.hotel.ui.model.menu;

import java.util.ArrayList;
import java.util.Optional;

public class Menu {
    private ArrayList<MenuItem> items = new ArrayList<>();
    private String title;
    private Menu prevMenu;

    public Menu(String title, Menu prevMenu) {
        this.title = title;
        this.prevMenu = prevMenu;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<MenuItem> getItems() {
        return items;
    }

    //Добавляем новый номер в список
    public void addMenuItem(MenuItem menuItem) {
        Optional.ofNullable(menuItem).ifPresent(getItems()::add);
    }

}
