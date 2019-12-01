package com.senla.hotel.backend.domain;

public class Room {
    private int number;
    private int price;
    private boolean status;
    private boolean free;
    private static int idRoom = 0;

    public Room(int number, int price, boolean free, boolean status) {
        this.idRoom = idRoom;
        idRoom++;
        this.number = number;
        this.price = price;
        this.free = free;
        this.status = status;
    }

    public int getId() {
        return idRoom;
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

    public Boolean getFree() {
        return free;
    }

    public void setFree(boolean free) {
        this.free = free;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

}

