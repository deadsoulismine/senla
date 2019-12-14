package com.senla.hotel.backend.domain;

public class Service {
    private static int idService = 0;
    private int id;
    private int price;
    private String title;

    public Service(int price, String title) {
        this.id = idService;
        idService++;
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
