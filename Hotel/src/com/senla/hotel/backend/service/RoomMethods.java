package com.senla.hotel.backend.service;

import com.senla.hotel.backend.domain.Room;

public class RoomMethods {
    public String free(Room room) {
        if (room.getFree() && room.getStatus()) {
            return "свободно";
        } else {
            return "занято";
        }
    }

    public String status(Room room) {
        if (room.getStatus()) {
            return "обслуживаемый";
        } else {
            return "ремонтируемый";
        }
    }

}
