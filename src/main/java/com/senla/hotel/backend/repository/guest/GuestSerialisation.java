package com.senla.hotel.backend.repository.guest;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.senla.hotel.backend.domain.Guest;
import com.senla.hotel.backend.service.IService;
import com.senla.hotel.util.data.IData;
import com.senla.hotel.util.database.hibernate.ISession;
import com.senla.hotel.util.dependency.annotation.Autowired;
import com.senla.hotel.util.dependency.stereotype.Component;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

@Component
public class GuestSerialisation implements IGuestSerialisation {
    @Autowired(className = "ServiceImpl")
    private IService service;
    @Autowired(className = "Data")
    private IData data;
    @Autowired(className = "Session")
    private ISession session;

    @Override
    public void fileLoadGuest(String name) {
        List<Guest> jsonGuestList;
        try (JsonReader reader = new JsonReader(new FileReader(name))) {
            Type itemsType = new TypeToken<List<Guest>>() {
            }.getType();
            jsonGuestList = new Gson().fromJson(reader, itemsType);
            List<Guest> list = service.getGuestDao().findAllGuest();
            list.addAll(jsonGuestList);
            session.updateList(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void fileSaveGuest(String name) {
        try (JsonWriter writer = new JsonWriter(new FileWriter(name))) {
            Type itemsType = new TypeToken<List<Guest>>() {
            }.getType();
            List<Guest> list = service.getGuestDao().findAllGuest();
            new Gson().toJson(list, itemsType, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
