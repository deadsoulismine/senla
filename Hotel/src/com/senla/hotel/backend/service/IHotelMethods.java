package com.senla.hotel.backend.service;

import com.senla.hotel.ui.exception.ObjectNotExistException;
import com.senla.hotel.ui.exception.SameObjectsException;

public interface IHotelMethods {
    //Добавляем новый номер в список
    void addRoom(int number, int price) throws SameObjectsException;

    //Добавляем новую услугу в список
    void addGuest(String name, int age);

    //Добавляем новую услугу в список
    void addService(int price, String title);

    //Удаление номера из списка
    void deleteRoom(int idRoom) throws ObjectNotExistException;

    //Удаление постояльца из списка
    void deleteGuest(int idGuest);

    //Удаление услуги из списка
    void deleteService(int idService);

    //Заселение
    void settle(int idGuest, int idRoom);

    //Выселение
    void evict(int idGuest);

    //Изменение статуса номера
    void changeRoomStatus(int idRoom);

    //Изменение цены номера
    void changeRoomPrice(int idRoom, int price);

    //Изменение цены услуги
    void changeServicePrice(int idRoom, int price);
}

