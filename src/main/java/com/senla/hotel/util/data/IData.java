package com.senla.hotel.util.data;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

public interface IData {

    void load() throws IOException, ReflectiveOperationException, InterruptedException, SQLException;

    void saveData();

    Properties getProp();
}
