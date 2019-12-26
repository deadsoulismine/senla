package com.senla.hotel.backend.repository.service;

import com.senla.hotel.backend.domain.Service;
import com.senla.hotel.ui.exception.ListIsEmptyException;
import com.senla.hotel.ui.exception.ObjectNotExistException;
import com.senla.hotel.ui.exception.SameObjectsException;
import com.senla.hotel.util.DI.IBeanFactory;
import com.senla.hotel.util.DI.annotation.Autowired;
import com.senla.hotel.util.DI.stereotype.Component;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ServiceGeneral implements IServiceGeneral {
    @Autowired(className = "BeanFactory")
    private IBeanFactory beanFactory;

    private ArrayList<Service> services;

    public ServiceGeneral() {
        this.services = new ArrayList<>();
    }

    @Override
    public ArrayList<Service> getServices() {
        return services;
    }

    //Добавляем новую услугу в список
    @Override
    public void addService(int price, String title) throws SameObjectsException {
        Service service = (Service) beanFactory.instantiateInstance("Service");
        service.setPrice(price);
        service.setTitle(title);
        for (Service temp : services) {
            if (service.getTitle().equals(temp.getTitle()) && service.getPrice() == temp.getPrice()) {
                throw new SameObjectsException("This service already exist! Try again!");
            }
        }
        Optional.of(service).ifPresent(services::add);
    }

    //Удаление услуги из списка
    @Override
    public void deleteService(int idService) throws ObjectNotExistException {
        Optional.of(checkService(idService)).ifPresent(services::remove);
    }

    //Изменение цены услуги
    @Override
    public void changeServicePrice(int idService, int price) throws ObjectNotExistException {
        checkService(idService).setPrice(price);
    }

    //Список услуг
    @Override
    public void printServiceList() throws ListIsEmptyException {
        if (services.size() == 0) {
            throw new ListIsEmptyException("List of services is empty!");
        }
        System.out.println("List of Services: ");
        services.stream().peek(n -> System.out.println("ID: " + n.getId() + " | Name: " + n.getTitle() +
                " | Price: " + n.getPrice())).collect(Collectors.toList());
    }

    //Проверка на существование услуги
    @Override
    public Service checkService(int idService) throws ObjectNotExistException {
        Service checkService = services.stream().filter(p -> p.getId() == idService).findFirst().orElse(null);
        if (checkService != null) {
            return checkService;
        } else {
            throw new ObjectNotExistException("This service is not exist! Try again!");
        }
    }

}
