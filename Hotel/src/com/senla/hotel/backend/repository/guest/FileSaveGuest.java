package com.senla.hotel.backend.repository.guest;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonWriter;
import com.senla.hotel.backend.Application;
import com.senla.hotel.backend.domain.Guest;
import com.senla.hotel.util.data.Data;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class FileSaveGuest {
    public static void fileSaveGuest(String name) {
        List<Guest> guestList = Application.getHotel().guestList();
        try (JsonWriter writer = new JsonWriter(new FileWriter(name))) {
            Type itemsType = new TypeToken<List<Guest>>() {
            }.getType();
            new Gson().toJson(guestList, itemsType, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveGuestId() {
        try (FileWriter fileWriter = new FileWriter(Data.getProp().getProperty("pathIdGuest"))) {
            fileWriter.write(String.valueOf(Guest.getIdGuest()));
            fileWriter.write("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
