package com.senla.hotel.backend.domain;

import com.senla.hotel.util.DI.stereotype.Component;
import com.senla.hotel.util.data.LoadID;

@Component(type = "Instance")
public class Service {
    private static int idService = LoadID.loadServiceId();

    private int id;
    private int price;
    private String title;

    public Service() {
        this.id = idService++;
    }

    public static int getIdService() {
        return idService;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
