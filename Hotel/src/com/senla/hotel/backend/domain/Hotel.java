package com.senla.hotel.backend.domain;

import java.util.ArrayList;

public class Hotel {
    private String name;
    private ArrayList<Room> rooms = new ArrayList<>();
    private ArrayList<Service> services = new ArrayList<>();
    private ArrayList<Guest> guests = new ArrayList<>();

    public Hotel(String name) {
        this.name = name;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public ArrayList<Room> roomList() {
        return getRooms();
    }

    public ArrayList<Guest> getGuests() {
        return guests;
    }

    public ArrayList<Guest> guestList() {
        return getGuests();
    }

    public ArrayList<Service> getServices() {
        return services;
    }

    public ArrayList<Service> serviceList() {
        return getServices();
    }

}

