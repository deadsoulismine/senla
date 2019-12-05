package com.senla.hotel.backend.domain;

public class Service {
    private static int idService = 0;

    private int id;
    private int price;
    private String name;

    public Service(int price, String name) {
        this.id = idService;
        idService++;
        this.price = price;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
