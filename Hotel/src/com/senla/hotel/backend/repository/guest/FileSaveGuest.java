package com.senla.hotel.backend.repository.guest;

import com.google.gson.Gson;
import com.senla.hotel.backend.Application;
import com.senla.hotel.backend.domain.Guest;

import java.io.FileWriter;
import java.io.IOException;

import static com.senla.hotel.util.Data.getProp;

public class FileSaveGuest {
    public static void fileSaveGuest(String name) {
        Gson gson = new Gson();
        try (FileWriter fileWriter = new FileWriter(name)) {
            for (Guest guest : Application.getHotel().guestList()) {
                String json = gson.toJson(guest);
                fileWriter.write(json);
                fileWriter.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveGuestId() {
        try (FileWriter fileWriter = new FileWriter(getProp().getProperty("pathIdGuest"))) {
            fileWriter.write(String.valueOf(Guest.idGuest));
            fileWriter.write("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
