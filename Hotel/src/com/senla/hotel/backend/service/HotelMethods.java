package com.senla.hotel.backend.service;

import com.senla.hotel.backend.domain.Guest;
import com.senla.hotel.backend.domain.Hotel;
import com.senla.hotel.backend.domain.Room;
import com.senla.hotel.backend.domain.Service;

import java.util.Optional;

public class HotelMethods implements IHotel {

    //Добавляем новый номер в список
    @Override
    public void addRoom(Hotel hotel, Room room) {
        Optional.ofNullable(room).ifPresent(hotel.roomList()::add);
    }

    //Добавляем новую услугу в список
    @Override
    public void addGuest(Hotel hotel, Guest guest) {
        Optional.ofNullable(guest).ifPresent(hotel.guestList()::add);
    }

    //Добавляем новую услугу в список
    @Override
    public void addService(Hotel hotel, Service service) {
        Optional.ofNullable(service).ifPresent(hotel.serviceList()::add);
    }

    //Поиск свободного номера
    private Room getFreeRoom(Hotel hotel) {
        for (Room n : hotel.roomList()) {
            if (n.getStatus() == true && n.getFree() == true) {
                n.setFree(false);
                return n;
            } else {
                System.out.println("Нет свободных номеров!");
            }
        }
        return null;
    }

    //Заселение
    public void settle(Hotel hotel, Guest guest) {
        Optional<Room> tempRoom = Optional.ofNullable(getFreeRoom(hotel));
        hotel.guestList().add(guest);
        if (tempRoom.isPresent()) {
            guest.setRoomId(tempRoom.get().getNumber());
            System.out.println("Постоялец " + guest.getName() + " заселен в номер: " + tempRoom.get().getNumber());
        }
    }

    //Выселение
    public void evict(Hotel hotel, Guest guest) {
        for (Room n : hotel.roomList()) {
            if (n.getNumber() == guest.getRoomId()) {
                n.setFree(true);
                hotel.guestList().remove(guest);
                System.out.println("Постоялец " + guest.getName() + " выселен из номера: " + n.getNumber());
            }
        }
    }

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
