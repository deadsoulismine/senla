package com.senla.hotel.util.data;

import com.senla.hotel.backend.service.IService;
import com.senla.hotel.util.dependency.annotation.Autowired;
import com.senla.hotel.util.dependency.stereotype.Component;
import com.senla.hotel.util.mail.IMail;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

@Component
public class Data implements IData {
    private static final String PATH_TO_PROPERTIES_OF_DATA = "src/main/java/com/senla/hotel/resources/config.properties";
    private Properties propData;

    @Autowired(className = "ServiceImpl")
    private IService service;
    @Autowired(className = "FillField")
    private IFillField fillField;
    @Autowired(className = "Mail")
    private IMail mail;

    public Data() {
        this.propData = new Properties();
    }

    @Override
    public Properties getProp() {
        return propData;
    }

    //Загрузка данных
    public void load() throws IOException, ReflectiveOperationException, SQLException {
        FileInputStream fileInputStreamData = new FileInputStream(PATH_TO_PROPERTIES_OF_DATA);
        propData.load(fileInputStreamData);

//        service.fileLoadGuest(propData.getProperty("pathGuestList"));
//        service.fileLoadRoom(propData.getProperty("pathRoomList"));
//        service.fileLoadService(propData.getProperty("pathServiceList"));

        fillField.action();
    }

    //Сохранение данных
    @Override
    public void saveData() {
//        service.fileSaveGuest(propData.getProperty("pathGuestList"));
//        service.fileSaveRoom(propData.getProperty("pathRoomList"));
//        service.fileSaveService(propData.getProperty("pathServiceList"));
    }

}
