package com.senla.hotel.backend.repository.room;

public interface IRoomSerialisation {
    void fileLoadRoom(String name);

    void fileSaveRoom(String name);
}
