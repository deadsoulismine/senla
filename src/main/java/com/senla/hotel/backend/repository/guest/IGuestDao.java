package com.senla.hotel.backend.repository.guest;

import com.senla.hotel.backend.domain.Guest;
import com.senla.hotel.ui.exception.ListIsEmptyException;
import com.senla.hotel.ui.exception.ObjectNotExistException;

import java.sql.SQLException;
import java.util.List;

public interface IGuestDao {
    //Добавляем нового постояльца в список
    void addGuest(String name, int age) throws ReflectiveOperationException, SQLException;

    //Удаление постояльца из списка
    void deleteGuest(int idGuest) throws ObjectNotExistException;

    //Список постояльцев (всех)
    void printGuestList() throws ListIsEmptyException;

    //Список незаселённых постояльцев
    void printWaitingGuests() throws ListIsEmptyException;

    //Список заселённых постояльцев
    void printSettleGuests() throws ListIsEmptyException;

    Guest checkGuest(int idGuest) throws ObjectNotExistException;

    List<Guest> findAllGuest();

    void changeGuestName(int idGuest, String name) throws ObjectNotExistException;

    void changeGuestAge(int idGuest, int age) throws ObjectNotExistException;
}
