package com.senla.hotel.backend.repository;

import com.senla.hotel.backend.domain.Room;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileLoad {
    public void fileRead(ArrayList<Room> roomList) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("roomRead.txt"));
        String currentLine;

        while ((currentLine = bufferedReader.readLine()) != null) {
            String[] room = currentLine.split(" ");

            int number = Integer.parseInt(room[0]);
            int price = Integer.parseInt(room[1]);
            boolean free = Boolean.parseBoolean(room[2]);
            boolean status = Boolean.parseBoolean(room[3]);

            Room roomObject = new Room(number, price, free, status);
            roomList.add(roomObject);
        }
        bufferedReader.close();
    }
}
