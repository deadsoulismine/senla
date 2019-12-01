package com.senla.hotel.ui.model.navigator;

import java.io.IOException;

public interface INavigator {
    void printMenu();

    void navigate(byte index) throws IOException;
}
