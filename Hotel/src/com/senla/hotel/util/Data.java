package com.senla.hotel.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static com.senla.hotel.backend.repository.guest.FileLoadGuest.fileLoadGuest;
import static com.senla.hotel.backend.repository.guest.FileLoadGuest.loadGuestId;
import static com.senla.hotel.backend.repository.guest.FileSaveGuest.fileSaveGuest;
import static com.senla.hotel.backend.repository.guest.FileSaveGuest.saveGuestId;

public class Data {
    private static final String PATH_TO_PROPERTIES = "Hotel/src/com/senla/hotel/resources/config.properties";
    private static Properties prop = new Properties();

    public static Properties getProp() {
        return prop;
    }

    public static void loadData() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(PATH_TO_PROPERTIES);
        prop.load(fileInputStream);
        fileLoadGuest(prop.getProperty("pathGuestList"));
        loadGuestId();
    }

    public static void saveData() {
        fileSaveGuest(prop.getProperty("pathGuestList"));
        saveGuestId();
    }
}
