package com.senla.hotel.backend.service;

import com.senla.hotel.backend.domain.Guest;
import com.senla.hotel.backend.domain.Hotel;
import com.senla.hotel.backend.domain.Room;
import com.senla.hotel.backend.domain.Service;

public interface IHotel {
    void addRoom(Hotel hotel, Room room);

    void addGuest(Hotel hotel, Guest guest);

    void addService(Hotel hotel, Service service);

    void settle(Hotel hotel, Guest guest);

    void evict(Hotel hotel, Guest guest);
}

