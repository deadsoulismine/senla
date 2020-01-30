package com.senla.hotel.backend.repository.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.senla.hotel.backend.domain.Service;
import com.senla.hotel.backend.service.IService;
import com.senla.hotel.util.data.IData;
import com.senla.hotel.util.dependency.annotation.Autowired;
import com.senla.hotel.util.dependency.stereotype.Component;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

@Component
public class ServiceSerialisation implements IServiceSerialisation {
    @Autowired(className = "ServiceImpl")
    private IService service;
    @Autowired(className = "Data")
    private IData data;

    @Override
    public void fileLoadService(String name) {
        List<Service> serviceList;
        try (JsonReader reader = new JsonReader(new FileReader(name))) {
            Type itemsType = new TypeToken<List<Service>>() {
            }.getType();
            serviceList = new Gson().fromJson(reader, itemsType);
            serviceList.forEach(s -> service.getServiceDao().findAllService().add(s));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void fileSaveService(String name) {
        try (JsonWriter writer = new JsonWriter(new FileWriter(name))) {
            Type itemsType = new TypeToken<List<Service>>() {
            }.getType();
            new Gson().toJson(service.getServiceDao().findAllService(), itemsType, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

