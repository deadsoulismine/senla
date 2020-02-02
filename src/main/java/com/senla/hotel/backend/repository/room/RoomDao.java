package com.senla.hotel.backend.repository.room;

import com.senla.hotel.backend.domain.Room;
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
public class RoomDao implements IRoomDao {
    @Autowired(className = "BeanFactory")
    private IBeanFactory beanFactory;
    @Autowired(className = "Connect")
    private IConnect connect;
    @Autowired(className = "Session")
    private ISession session;

    //Добавляем новый номер в список
    @Override
    public void addRoom(int number, int price) throws SameObjectsException {
        for (Room room : findAllRoom()) {
            if (room.getNumber() == number) {
                throw new SameObjectsException("Apartments with this number already exist! Try again!");
            }
        }

        try {
            PreparedStatement preparedStatement = connect.getConnection().prepareStatement(
                    "INSERT INTO hotel.rooms(number, price) values(?,?)");
            preparedStatement.setInt(1, number);
            preparedStatement.setInt(2, price);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Удаление комнаты из списка
    @Override
    public void deleteRoom(int id) throws ObjectNotExistException {
        Room checkRoom = checkRoom(id);
        if (checkRoom.getGuests().size() != 0) {
            System.out.println("In this number exist the guest! Evict him and try again.");
        } else {
            try {
                PreparedStatement preparedStatement = connect.getConnection().prepareStatement(
                        "DELETE FROM hotel.rooms WHERE id = ?");
                preparedStatement.setInt(1, id);

                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //Изменение статуса номера
    @Override
    public void changeRoomStatus(int roomNumber) throws ObjectNotExistException {
        Room tempRoom = checkRoom(roomNumber);
        if ((tempRoom.getStatus()) && (tempRoom.getGuests().size() == 0)) {
            tempRoom.setStatus(false);
        } else if ((!tempRoom.getStatus()) && tempRoom.getGuests().size() == 0) {
            tempRoom.setStatus(true);
        } else {
            System.out.println("In this number exist the guest! Evict him and try again.");
        }
        session.updateObject(tempRoom);
    }

    //Изменение цены номера
    @Override
    public void changeRoomPrice(int idRoom, int price) throws ObjectNotExistException {
        Room tempRoom = checkRoom(idRoom);
        tempRoom.setPrice(price);
        session.updateObject(tempRoom);
    }

    //Изменение номера комнаты
    @Override
    public void changeRoomNumber(int idRoom, int number) throws ObjectNotExistException {
        Room tempRoom = checkRoom(idRoom);
        if (tempRoom.getGuests().size() != 0) {
            System.out.println("In this number exist the guest! Evict him and try again.");
        } else {
            tempRoom.setNumber(number);
            session.updateObject(tempRoom);
        }
    }

    //Список всех номеров
    @Override
    public void printRoomList() throws ListIsEmptyException {
        List<Room> list = findAllRoom();
        if (list.size() == 0) {
            throw new ListIsEmptyException("List of rooms is empty!");
        }
        System.out.println("List of Rooms: ");
        list.stream().peek(n -> System.out.println("ID: " + n.getId() + " | # " + n.getNumber() + " | Price: " +
                n.getPrice() + " | " + status(n) + " | " + free(n))).collect(Collectors.toList());
    }

    //Список пустых номеров
    @Override
    public void printFreeRoomList() throws ListIsEmptyException {
        List<Room> list = findAllRoom();
        if (list.stream().noneMatch(p -> p.getGuests().size() == 0)) {
            throw new ListIsEmptyException("Hotel haven't free rooms or list of rooms is empty!");
        } else {
            System.out.println("List of free Rooms: ");
            list.stream().filter(p -> p.getGuests().size() == 0).peek(n -> System.out.println("ID: " + n.getId() +
                    " | # " + n.getNumber() + " | Price: " + n.getPrice() + " | " + status(n) + " | " + free(n))).
                    collect(Collectors.toList());
        }
    }

    //Получение информации свободен ли номер
    private String free(Room room) {
        if (room.getGuests().size() == 0 && room.getStatus()) {
            return "free";
        } else {
            return "busy";
        }
    }

    //Получение информации обслуживается ли номер
    private String status(Room room) {
        if (room.getStatus()) {
            return "serviced";
        } else {
            return "on repair";
        }
    }

    //Проверка на существование комнаты
    public Room checkRoom(int id) throws ObjectNotExistException {
        Room checkRoom = findAllRoom().stream().filter(p -> p.getId() == id).findFirst().orElse(null);
        if (checkRoom != null) {
            return checkRoom;
        } else {
            throw new ObjectNotExistException("This room is not exist! Try again!");
        }
    }

    @Override
    public List<Room> findAllRoom() {
        return session.getSessionFactory().openSession().createQuery("From Room").list();
    }

}
