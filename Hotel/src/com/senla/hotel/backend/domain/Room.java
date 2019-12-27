package com.senla.hotel.backend.domain;

import com.senla.hotel.util.DI.stereotype.Component;

import java.util.ArrayList;

@Component(type = "Instance")
public class Room {
    private Integer idGuest;
    private int number;
    private int price;
    private boolean status;
    private ArrayList<Guest> history = new ArrayList<>();

    public ArrayList<Guest> getHistory() {
        return history;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Integer getIdGuest() {
        return idGuest;
    }

    public void setIdGuest(Integer idGuest) {
        this.idGuest = idGuest;
    }

}

