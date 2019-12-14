package com.senla.hotel.ui.model.navigator;

import com.senla.hotel.ui.exception.ListIsEmptyException;
import com.senla.hotel.ui.exception.ObjectNotExistException;
import com.senla.hotel.ui.exception.SameObjectsException;

import java.io.IOException;

public interface INavigator {
    void printMenu();

    void navigate(byte index) throws IOException, ListIsEmptyException, ObjectNotExistException, SameObjectsException;
}
