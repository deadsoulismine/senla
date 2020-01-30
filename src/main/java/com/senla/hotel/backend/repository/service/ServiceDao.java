package com.senla.hotel.backend.repository.service;

import com.senla.hotel.backend.domain.Service;
import com.senla.hotel.ui.exception.ListIsEmptyException;
import com.senla.hotel.ui.exception.ObjectNotExistException;
import com.senla.hotel.ui.exception.SameObjectsException;
import com.senla.hotel.util.database.hibernate.ISession;
import com.senla.hotel.util.database.jdbc.IConnect;
import com.senla.hotel.util.dependency.IBeanFactory;
import com.senla.hotel.util.dependency.annotation.Autowired;
import com.senla.hotel.util.dependency.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ServiceDao implements IServiceDao {
    @Autowired(className = "BeanFactory")
    private IBeanFactory beanFactory;
    @Autowired(className = "Connect")
    private IConnect connect;
    @Autowired(className = "Session")
    private ISession session;


    //Добавляем новую услугу в список
    @Override
    public void addService(int price, String title) throws SameObjectsException {
        for (Service service : findAllService()) {
            if (service.getTitle().equals(title) && service.getPrice() == price) {
                throw new SameObjectsException("This service already exist! Try again!");
            }
        }

        try {
            PreparedStatement preparedStatement = connect.getConnection().prepareStatement(
                    "INSERT INTO hotel.services(title, price) values(?,?)");
            preparedStatement.setString(1, title);
            preparedStatement.setInt(2, price);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Удаление услуги из списка
    @Override
    public void deleteService(int idService) throws ObjectNotExistException {
        checkService(idService);
        try {
            PreparedStatement preparedStatement = connect.getConnection().prepareStatement(
                    "DELETE FROM hotel.services WHERE id = ?");
            preparedStatement.setInt(1, idService);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Изменение цены услуги
    @Override
    public void changeServicePrice(int idService, int price) throws ObjectNotExistException {
        checkService(idService).setPrice(price);
    }

    //Список услуг
    @Override
    public void printServiceList() throws ListIsEmptyException {
        List<Service> list = findAllService();
        if (list.size() == 0) {
            throw new ListIsEmptyException("List of services is empty!");
        }
        list.stream().peek(n -> System.out.println("ID: " + n.getId() + " | Title: " + n.getTitle() + " | Price: " +
                n.getPrice())).collect(Collectors.toList());

    }

    //Проверка на существование услуги
    @Override
    public Service checkService(int idService) throws ObjectNotExistException {
        Service checkService = findAllService().stream().filter(p -> p.getId() == idService).findFirst().orElse(null);
        if (checkService != null) {
            return checkService;
        } else {
            throw new ObjectNotExistException("This service is not exist! Try again!");
        }
    }

    @Override
    public List<Service> findAllService() {
        return session.getSessionFactory().openSession().createQuery("From Service").list();
    }

}
