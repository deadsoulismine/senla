package com.senla.hotel.backend.repository.room;

import com.senla.hotel.backend.domain.Room;
import com.senla.hotel.ui.exception.ListIsEmptyException;
import com.senla.hotel.ui.exception.ObjectNotExistException;
import com.senla.hotel.ui.exception.SameObjectsException;

import java.util.ArrayList;

public interface IRoomGeneral {
    ArrayList<Room> getRooms();

    //Добавляем новый номер в список
    void addRoom(int number, int price) throws SameObjectsException;

    //Удаление комнаты из списка
    void deleteRoom(int roomNumber) throws ObjectNotExistException;

    //Изменение статуса номера
    void changeRoomStatus(int roomNumber) throws ObjectNotExistException;

    //Изменение цены номера
    void changeRoomPrice(int idRoom, int price) throws ObjectNotExistException;

    //Список всех номеров
    void printRoomList() throws ListIsEmptyException;

    //Список пустых номеров
    void printFreeRoomList() throws ListIsEmptyException;

    Room checkRoom(int roomNumber) throws ObjectNotExistException;
}
