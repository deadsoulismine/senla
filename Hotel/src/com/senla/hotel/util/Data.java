package com.senla.hotel.util;

import com.senla.hotel.backend.Application;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static com.senla.hotel.backend.repository.guest.FileLoadGuest.loadGuestId;
import static com.senla.hotel.backend.repository.guest.FileSaveGuest.saveGuestId;
import static com.senla.hotel.backend.repository.service.FileLoadService.loadServiceId;
import static com.senla.hotel.backend.repository.service.FileSaveService.saveServiceId;

public class Data {
    private static final String PATH_TO_PROPERTIES_OF_DATA = "Hotel/src/com/senla/hotel/resources/config.properties";
    private static Properties propData = new Properties();

    public static Properties getProp() {
        return propData;
    }

    public static void loadData() throws IOException, NoSuchFieldException {
        FileInputStream fileInputStreamData = new FileInputStream(PATH_TO_PROPERTIES_OF_DATA);
        propData.load(fileInputStreamData);
        Application.fileLoadGuest(propData.getProperty("pathGuestList"));
        Application.fileLoadRoom(propData.getProperty("pathRoomList"));
        Application.fileLoadService(propData.getProperty("pathServiceList"));
        loadGuestId();
        loadServiceId();
        FillGuestAnnotation.action();
    }

    public static void saveData() {
        Application.fileSaveGuest(propData.getProperty("pathGuestList"));
        Application.fileSaveRoom(propData.getProperty("pathRoomList"));
        Application.fileSaveService(propData.getProperty("pathServiceList"));
        saveGuestId();
        saveServiceId();
    }

}
