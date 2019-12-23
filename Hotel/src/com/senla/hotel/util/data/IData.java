package com.senla.hotel.util.data;

import java.io.IOException;

public interface IData {

    void load() throws IOException, NoSuchFieldException;

    void saveData();
}
