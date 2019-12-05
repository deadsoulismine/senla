package com.senla.hotel.backend.repository.guest;

import com.senla.hotel.backend.Application;
import com.senla.hotel.backend.domain.Guest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileLoadGuest {
    public static void fileLoadGuest(String name) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(name));
        String currentLine;

        while ((currentLine = bufferedReader.readLine()) != null) {
            String[] room = currentLine.split(", ");

            Application.getHotel().guestList().add(new Guest(room[0], Integer.parseInt(room[1])));
        }
        bufferedReader.close();
    }
}
