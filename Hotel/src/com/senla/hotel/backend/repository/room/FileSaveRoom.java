package com.senla.hotel.backend.repository.room;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonWriter;
import com.senla.hotel.backend.Application;
import com.senla.hotel.backend.domain.Room;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class FileSaveRoom {
//    public static void fileSaveRoom(String name) {
//        try {
//            try (FileWriter fileWriter = new FileWriter(name)) {
//                for (Room room : Application.getHotel().roomList()) {
//                    fileWriter.write((room.getNumber()) + ", ");
//                    fileWriter.write((room.getPrice()) + ", ");
//                    fileWriter.write("\n");
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    public static void fileSaveRoom(String name) {
        List<Room> roomList = Application.getHotel().roomList();
        try (JsonWriter writer = new JsonWriter(new FileWriter(name))) {
            Type itemsType = new TypeToken<List<Room>>() {
            }.getType();
            new Gson().toJson(roomList, itemsType, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
