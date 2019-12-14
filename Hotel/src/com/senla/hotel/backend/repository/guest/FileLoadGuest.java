package com.senla.hotel.backend.repository.guest;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.senla.hotel.backend.domain.Guest;
import com.senla.hotel.util.Data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class FileLoadGuest {
    public static void fileLoadGuest(String name) throws IOException {
        String currentLine;
        try (JsonReader reader = new JsonReader(new FileReader(name))) {
            Guest guest = new Gson().fromJson(reader, Guest.class);
            Type itemsType = new TypeToken<List<Guest>>() {
            }.getType();
        }
//        Application.getHotel().guestList().add(guest);
//        JsonParser parser = new JsonParser();
//        JsonObject obj = (JsonObject) parser.parse(new FileReader(name));
//        obj.get("name");
    }

    public static int loadGuestId() {
        String currentLine;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(Data.getProp().getProperty("pathIdGuest")))) {
            while ((currentLine = bufferedReader.readLine()) != null) {
                return Integer.parseInt(currentLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

}
