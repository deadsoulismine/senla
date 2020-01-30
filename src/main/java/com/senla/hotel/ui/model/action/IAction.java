package com.senla.hotel.ui.model.action;

import com.senla.hotel.ui.exception.ListIsEmptyException;
import com.senla.hotel.ui.exception.ObjectNotExistException;
import com.senla.hotel.ui.exception.SameObjectsException;

import java.io.IOException;
import java.sql.SQLException;

public interface IAction {
    void execute() throws IOException, RuntimeException, ListIsEmptyException, ObjectNotExistException,
            SameObjectsException, ReflectiveOperationException, InterruptedException, SQLException;
}
