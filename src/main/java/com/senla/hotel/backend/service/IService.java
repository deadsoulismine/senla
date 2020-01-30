package com.senla.hotel.backend.service;

import com.senla.hotel.backend.repository.guest.IGuestDao;
import com.senla.hotel.backend.repository.guest.IGuestSerialisation;
import com.senla.hotel.backend.repository.residence.IResidence;
import com.senla.hotel.backend.repository.room.IRoomDao;
import com.senla.hotel.backend.repository.room.IRoomSerialisation;
import com.senla.hotel.backend.repository.service.IServiceDao;
import com.senla.hotel.backend.repository.service.IServiceSerialisation;
import com.senla.hotel.ui.exception.ListIsEmptyException;
import com.senla.hotel.ui.exception.ObjectNotExistException;
import com.senla.hotel.ui.exception.SameObjectsException;

import java.sql.SQLException;

public interface IService {
    //Добавляем новый номер в список
    void addRoom(int number, int price) throws SameObjectsException;

    //Добавляем новую услугу в список
    void addGuest(String name, int age) throws ReflectiveOperationException, SQLException;

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

    //Выселение
    void evict(int idGuest) throws ObjectNotExistException;

    //Изменение статуса номера
    void changeRoomStatus(int idRoom) throws ObjectNotExistException;

    //Изменение цены номера
    void changeRoomPrice(int idRoom, int price) throws ObjectNotExistException;

    //Изменение цены услуги
    void changeServicePrice(int idRoom, int price) throws ObjectNotExistException;

    //Вывод списка всех номеров
    void printRoomList() throws ListIsEmptyException;

    //Вывод списка всех постояльцев
    void printGuestList() throws ListIsEmptyException;

    //Вывод списка всех услуг
    void printServiceList() throws ListIsEmptyException;

    //Вывод списка всех свободных номеров
    void printFreeRoomList() throws ListIsEmptyException;

    //Вывод списка всех постояльцев без комнаты
    void printWaitingGuests() throws ListIsEmptyException;

    //Вывод списка заселённых постольцев
    void printSettleGuests() throws ListIsEmptyException;

    void fileLoadGuest(String stringScanner);

    void fileSaveGuest(String stringScanner);

    void fileLoadRoom(String stringScanner);

    void fileSaveRoom(String stringScanner);

    void fileLoadService(String stringScanner);

    void fileSaveService(String stringScanner);

    IGuestDao getGuestDao();

    IGuestSerialisation getGuestSerialisation();

    IRoomDao getRoomDao();

    IRoomSerialisation getRoomSerialisation();

    IServiceDao getServiceDao();

    IServiceSerialisation getServiceSerialisation();

    IResidence getResidence();
}

