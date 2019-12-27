package com.senla.hotel.backend.repository.room;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.senla.hotel.backend.domain.Room;
import com.senla.hotel.backend.service.IService;
import com.senla.hotel.util.DI.annotation.Autowired;
import com.senla.hotel.util.DI.stereotype.Component;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

@Component
public class RoomSerialisation implements IRoomSerialisation {
    @Autowired(className = "ServiceImpl")
    private IService service;

    @Override
    public void fileLoadRoom(String name) {
        List<Room> roomList;
        try (JsonReader reader = new JsonReader(new FileReader(name))) {
            Type itemsType = new TypeToken<List<Room>>() {
            }.getType();
            roomList = new Gson().fromJson(reader, itemsType);
            roomList.forEach(r -> service.getRoomGeneral().getRooms().add(r));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void fileSaveRoom(String name) {
        try (JsonWriter writer = new JsonWriter(new FileWriter(name))) {
            Type itemsType = new TypeToken<List<Room>>() {
            }.getType();
            new Gson().toJson(service.getRoomGeneral().getRooms(), itemsType, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
