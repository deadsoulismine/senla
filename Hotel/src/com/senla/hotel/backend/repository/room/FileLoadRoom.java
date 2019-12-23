package com.senla.hotel.backend.repository.room;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.senla.hotel.backend.Application;
import com.senla.hotel.backend.domain.Room;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class FileLoadRoom {
    public static void fileLoadRoom(String name) {
        List<Room> roomList;
        try (JsonReader reader = new JsonReader(new FileReader(name))) {
            Type itemsType = new TypeToken<List<Room>>() {
            }.getType();
            roomList = new Gson().fromJson(reader, itemsType);
            roomList.forEach(r -> Application.getHotel().roomList().add(r));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
