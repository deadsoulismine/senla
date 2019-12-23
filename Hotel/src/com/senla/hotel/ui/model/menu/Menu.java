package com.senla.hotel.ui.model.menu;

import com.senla.hotel.util.DI.stereotype.Instance;

import java.util.ArrayList;
import java.util.Optional;

@Instance
public class Menu {
    private ArrayList<MenuItem> items = new ArrayList<>();
    private String title;
    private Menu prevMenu;

    public Menu getPrevMenu() {
        return prevMenu;
    }

    public void setPrevMenu(Menu prevMenu) {
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

    //Добавляем новый пункт меню в список
    public void addMenuItem(MenuItem menuItem) {
        Optional.ofNullable(menuItem).ifPresent(getItems()::add);
    }

}
