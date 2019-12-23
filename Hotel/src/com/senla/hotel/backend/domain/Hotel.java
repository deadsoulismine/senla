package com.senla.hotel.backend.domain;

import com.senla.hotel.backend.service.IHotelMethods;
import com.senla.hotel.util.DI.annotation.Autowired;
import com.senla.hotel.util.DI.stereotype.Component;

import java.util.ArrayList;

@Component
public class Hotel {
    private ArrayList<Room> rooms;
    private ArrayList<Service> services;
    private ArrayList<Guest> guests;

    @Autowired(className = "HotelMethodsImpl")
    private IHotelMethods hotelMethods;

    public Hotel() {
        this.rooms = new ArrayList<>();
        this.services = new ArrayList<>();
        this.guests = new ArrayList<>();
    }

    public IHotelMethods getHotelMethods() {
        return hotelMethods;
    }

    public ArrayList<Room> roomList() {
        return rooms;
    }

    public ArrayList<Guest> guestList() {
        return guests;
    }

    public ArrayList<Service> serviceList() {
        return services;
    }

}

