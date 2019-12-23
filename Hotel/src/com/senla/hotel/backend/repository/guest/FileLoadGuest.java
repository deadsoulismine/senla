package com.senla.hotel.backend.repository.guest;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.senla.hotel.backend.Application;
import com.senla.hotel.backend.domain.Guest;
import com.senla.hotel.util.data.Data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class FileLoadGuest {
    public static void fileLoadGuest(String name) {
        List<Guest> jsonGuestList;
        try (JsonReader reader = new JsonReader(new FileReader(name))) {
            Type itemsType = new TypeToken<List<Guest>>() {
            }.getType();
            jsonGuestList = new Gson().fromJson(reader, itemsType);
            jsonGuestList.forEach(g -> Application.getHotel().guestList().add(g));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int loadGuestId() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(Data.getProp().getProperty("pathIdGuest")))) {
            return Integer.parseInt(bufferedReader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

}
