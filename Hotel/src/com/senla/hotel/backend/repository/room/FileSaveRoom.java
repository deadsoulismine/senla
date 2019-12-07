package com.senla.hotel.backend.repository.room;

import com.senla.hotel.backend.Application;
import com.senla.hotel.backend.domain.Room;

import java.io.FileWriter;
import java.io.IOException;

public class FileSaveRoom {
    public static void fileSaveRoom(String name) {
        try (FileWriter fileWriter = new FileWriter(name)) {
            for (Room room : Application.getHotel().roomList()) {
                fileWriter.write((room.getNumber()) + ", ");
                fileWriter.write((room.getPrice()) + ", ");
                fileWriter.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
