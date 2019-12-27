package com.senla.hotel.backend.repository.guest;

import com.senla.hotel.backend.domain.Guest;
import com.senla.hotel.ui.exception.ListIsEmptyException;
import com.senla.hotel.ui.exception.ObjectNotExistException;

import java.util.ArrayList;

public interface IGuestGeneral {
    //Добавляем нового постояльца в список
    void addGuest(String name, int age) throws ReflectiveOperationException;

    //Удаление постояльца из списка
    void deleteGuest(int idGuest) throws ObjectNotExistException;

    //Список постояльцев (всех)
    void printGuestList() throws ListIsEmptyException;

    //Список незаселённых постояльцев
    void printWaitingGuests() throws ListIsEmptyException;

    //Список заселённых постояльцев
    void printSettleGuests() throws ListIsEmptyException;

    ArrayList<Guest> getGuests();

    Guest checkGuest(int idGuest) throws ObjectNotExistException;
}
