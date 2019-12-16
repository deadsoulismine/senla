package com.senla.hotel.backend.repository.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.senla.hotel.backend.Application;
import com.senla.hotel.backend.domain.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import static com.senla.hotel.util.Data.getProp;

public class FileLoadService {
//    public static void fileLoadService(String name) throws IOException {
//        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(name))) {
//            String currentLine;
//
//            while ((currentLine = bufferedReader.readLine()) != null) {
//                String[] room = currentLine.split(", ");
//
//                Application.getHotel().serviceList().add(new Service(Integer.parseInt(room[0]), room[1]));
//            }
//        }
//    }

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
        try (BufferedReader buffRead = new BufferedReader(new FileReader(getProp().getProperty("pathIdService")))) {
            return Integer.parseInt(buffRead.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

}

