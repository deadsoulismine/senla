package com.senla.hotel.util.data;

import java.io.IOException;
import java.util.Properties;

public interface IData {

    void load() throws IOException, ReflectiveOperationException;

    void saveData();

    Properties getProp();
}
