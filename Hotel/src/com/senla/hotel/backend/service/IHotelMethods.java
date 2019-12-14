package com.senla.hotel.backend.service;

import com.senla.hotel.ui.exception.ListIsEmptyException;
import com.senla.hotel.ui.exception.ObjectNotExistException;
import com.senla.hotel.ui.exception.SameObjectsException;

public interface IHotelMethods {
    //Добавляем новый номер в список
    void addRoom(int number, int price) throws SameObjectsException;

    //Добавляем новую услугу в список
    void addGuest(String name, int age);

    //Добавляем новую услугу в список
    void addService(int price, String title) throws SameObjectsException;

    //Удаление номера из списка
    void deleteRoom(int idRoom) throws ObjectNotExistException, ListIsEmptyException;

    //Удаление постояльца из списка
    void deleteGuest(int idGuest) throws ObjectNotExistException;

    //Удаление услуги из списка
    void deleteService(int idService) throws ObjectNotExistException;

    //Заселение
    void settle(int idGuest, int roomNumber) throws ObjectNotExistException;

    //Изменение статуса номера
    void changeRoomStatus(int idRoom) throws ObjectNotExistException;

    //Изменение цены номера
    void changeRoomPrice(int idRoom, int price) throws ObjectNotExistException;

    //Изменение цены услуги
    void changeServicePrice(int idRoom, int price) throws ObjectNotExistException;
}

