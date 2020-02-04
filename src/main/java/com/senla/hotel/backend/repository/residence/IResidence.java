package com.senla.hotel.backend.repository.residence;

import com.senla.hotel.ui.exception.ObjectNotExistException;

public interface IResidence {
    //Заселение
    void settle(int idGuest, int roomNumber) throws ObjectNotExistException;

    //Выселение
    void evict(int idGuest) throws ObjectNotExistException;

    void addServices(int idGuest, int idService) throws ObjectNotExistException;

    void deleteServices(int idGuest, int idService) throws ObjectNotExistException;

    void printListUnusedServices(int idGuest) throws ObjectNotExistException;

    void printListUsedServices(int idGuest) throws ObjectNotExistException;
}
