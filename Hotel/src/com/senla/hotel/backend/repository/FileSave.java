package com.senla.hotel.backend.repository;

import com.senla.hotel.backend.domain.Hotel;
import com.senla.hotel.backend.domain.Room;

import java.io.FileWriter;
import java.io.IOException;

public class FileSave {
    public void fileSave(Hotel hotel) {
        try (FileWriter fileWriter = new FileWriter("roomSave.txt")) {
            for (Room room : hotel.roomList()) {
                fileWriter.write((room.getNumber()) + " ");
                fileWriter.write((room.getPrice()) + " ");
                fileWriter.write(room.getFree() + " ");
                fileWriter.write(room.getStatus() + " ");
                fileWriter.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
