package com.senla.hotel.backend.repository.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.senla.hotel.backend.Application;
import com.senla.hotel.backend.domain.Service;
import com.senla.hotel.util.data.Data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class FileLoadService {
    public static void fileLoadService(String name) {
        List<Service> serviceList;
        try (JsonReader reader = new JsonReader(new FileReader(name))) {
            Type itemsType = new TypeToken<List<Service>>() {
            }.getType();
            serviceList = new Gson().fromJson(reader, itemsType);
            serviceList.forEach(s -> Application.getHotel().serviceList().add(s));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int loadServiceId() {
        try (BufferedReader buffRead = new BufferedReader(new FileReader(Data.getProp().getProperty("pathIdService")))) {
            return Integer.parseInt(buffRead.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

}

