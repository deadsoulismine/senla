package com.senla.hotel.backend.repository.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonWriter;
import com.senla.hotel.backend.Application;
import com.senla.hotel.backend.domain.Service;
import com.senla.hotel.util.data.Data;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class FileSaveService {
    public static void fileSaveService(String name) {
        List<Service> serviceList = Application.getHotel().serviceList();
        try (JsonWriter writer = new JsonWriter(new FileWriter(name))) {
            Type itemsType = new TypeToken<List<Service>>() {
            }.getType();
            new Gson().toJson(serviceList, itemsType, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveServiceId() {
        try (FileWriter fileWriter = new FileWriter(Data.getProp().getProperty("pathIdService"))) {
            fileWriter.write(String.valueOf(Service.idService));
            fileWriter.write("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
