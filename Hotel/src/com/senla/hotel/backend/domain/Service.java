package com.senla.hotel.backend.domain;

import com.senla.hotel.backend.repository.service.FileLoadService;
import com.senla.hotel.util.DI.annotation.Autowired;
import com.senla.hotel.util.DI.stereotype.Instance;

@Instance
public class Service {
    public static int idService = FileLoadService.loadServiceId();
    @Autowired(className = "FileLoadService")
    private FileLoadService fileLoadService;
    private int id;
    private int price;
    private String title;

    public Service(int price, String title) {
        this.id = idService++;
        this.price = price;
        this.title = title;
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
