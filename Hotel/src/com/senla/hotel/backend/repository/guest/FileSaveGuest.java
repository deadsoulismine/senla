package com.senla.hotel.backend.repository.guest;

import com.senla.hotel.backend.Application;
import com.senla.hotel.backend.domain.Guest;

import java.io.FileWriter;
import java.io.IOException;

public class FileSaveGuest {
    public static void fileSaveGuest(String name) {
        try (FileWriter fileWriter = new FileWriter(name)) {
            for (Guest guest : Application.getHotel().guestList()) {
                fileWriter.write((guest.getName()) + ", ");
                fileWriter.write((guest.getAge()) + ", ");
                fileWriter.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
