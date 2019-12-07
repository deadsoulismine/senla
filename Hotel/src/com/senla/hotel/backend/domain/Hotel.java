package com.senla.hotel.backend.domain;

import com.senla.hotel.backend.service.HotelMethods;

import java.util.ArrayList;

public class Hotel {
    private ArrayList<Room> rooms;
    private ArrayList<Service> services;
    private ArrayList<Guest> guests;
    private HotelMethods hotelMethods = new HotelMethods();

    public Hotel(ArrayList<Room> rooms, ArrayList<Service> services, ArrayList<Guest> guests) {
        this.rooms = rooms;
        this.services = services;
        this.guests = guests;
    }

    public HotelMethods getHotelMethods() {
        return hotelMethods;
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

