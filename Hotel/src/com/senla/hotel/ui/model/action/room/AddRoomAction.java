package com.senla.hotel.ui.model.action.room;

import com.senla.hotel.backend.domain.Hotel;
import com.senla.hotel.backend.domain.Room;

import java.util.Optional;

public class AddRoomAction {
    //Добавляем новый номер в список
    public void addRoom(Hotel hotel, Room room) {
        Optional.ofNullable(room).ifPresent(hotel.roomList()::add);
    }
}
