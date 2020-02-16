package com.senla.hotel.util.data;

import java.io.IOException;
import java.sql.SQLException;

public interface IFillField {
    void action() throws IOException, ReflectiveOperationException, SQLException;
}
