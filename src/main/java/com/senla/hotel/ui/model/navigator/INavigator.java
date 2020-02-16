package com.senla.hotel.ui.model.navigator;

import com.senla.hotel.ui.model.menu.Menu;

public interface INavigator {
    void printMenu();

    void navigate(byte index) throws Exception;

    void setCurrentMenu(Menu buildMenu);
}
