package com.senla.hotel.backend.repository.service;

import com.senla.hotel.backend.domain.Service;
import com.senla.hotel.ui.exception.ListIsEmptyException;
import com.senla.hotel.ui.exception.ObjectNotExistException;
import com.senla.hotel.ui.exception.SameObjectsException;

import java.util.List;

public interface IServiceDao {
    //Добавляем новую услугу в список
    void addService(int price, String title) throws SameObjectsException;

    //Удаление услуги из списка
    void deleteService(int idService) throws ObjectNotExistException;

    //Изменение цены услуги
    void changeServicePrice(int idService, int price) throws ObjectNotExistException;

    //Список услуг
    void printServiceList() throws ListIsEmptyException;

    //Проверка на существование услуги
    Service checkService(int idService) throws ObjectNotExistException;

    List<Service> findAllService();
}
