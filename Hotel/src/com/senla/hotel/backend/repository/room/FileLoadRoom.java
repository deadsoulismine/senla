package com.senla.hotel.backend.repository.room;

import com.senla.hotel.backend.Application;
import com.senla.hotel.backend.domain.Room;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileLoadRoom {
    public static void fileLoadRoom(String name) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(name));
        String currentLine;

        while ((currentLine = bufferedReader.readLine()) != null) {
            String[] room = currentLine.split(", ");
            Application.getHotel().roomList().add(new Room(Integer.parseInt(room[0]), Integer.parseInt(room[1])));
        }
        bufferedReader.close();
    }

}
