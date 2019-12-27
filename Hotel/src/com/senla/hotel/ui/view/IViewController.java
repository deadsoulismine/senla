package com.senla.hotel.ui.view;

import com.senla.hotel.ui.model.menu.Menu;

public interface IViewController {
    void printTitle(Menu currentMenu);

    void printMenuItemList(Menu currentMenu);
}
