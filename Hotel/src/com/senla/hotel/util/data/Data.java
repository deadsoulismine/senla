package com.senla.hotel.util.data;

import com.senla.hotel.backend.Application;
import com.senla.hotel.backend.repository.guest.FileLoadGuest;
import com.senla.hotel.backend.repository.guest.FileSaveGuest;
import com.senla.hotel.backend.repository.service.FileLoadService;
import com.senla.hotel.backend.repository.service.FileSaveService;
import com.senla.hotel.util.DI.stereotype.Component;
import com.senla.hotel.util.FillGuestAnnotation;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@Component
public class Data implements IData {
    private static final String PATH_TO_PROPERTIES_OF_DATA = "Hotel/src/com/senla/hotel/resources/config.properties";
    private static Properties propData = new Properties();

    public static Properties getProp() {
        return propData;
    }

    //Загрузка данных
    public void load() throws IOException, NoSuchFieldException {
        FileInputStream fileInputStreamData = new FileInputStream(PATH_TO_PROPERTIES_OF_DATA);
        propData.load(fileInputStreamData);

        Application.fileLoadGuest(propData.getProperty("pathGuestList"));
        Application.fileLoadRoom(propData.getProperty("pathRoomList"));
        Application.fileLoadService(propData.getProperty("pathServiceList"));

        FileLoadGuest.loadGuestId();
        FileLoadService.loadServiceId();

        FillGuestAnnotation.action();
    }

    //Сохранение данных
    @Override
    public void saveData() {
        Application.fileSaveGuest(propData.getProperty("pathGuestList"));
        Application.fileSaveRoom(propData.getProperty("pathRoomList"));
        Application.fileSaveService(propData.getProperty("pathServiceList"));
        FileSaveGuest.saveGuestId();
        FileSaveService.saveServiceId();
    }
}
