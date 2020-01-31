package com.senla.hotel.backend.repository.guest;

import com.senla.hotel.backend.domain.Guest;
import com.senla.hotel.ui.exception.ListIsEmptyException;
import com.senla.hotel.ui.exception.ObjectNotExistException;
import com.senla.hotel.util.database.hibernate.ISession;
import com.senla.hotel.util.database.jdbc.IConnect;
import com.senla.hotel.util.dependency.annotation.Autowired;
import com.senla.hotel.util.dependency.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class GuestDao implements IGuestDao {
    @Autowired(className = "Connect")
    private IConnect connect;
    @Autowired(className = "Session")
    private ISession session;

    //Добавляем нового постояльца в список
    @Override
    public void addGuest(String name, int age) {
        try {
            PreparedStatement preparedStatement = connect.getConnection().prepareStatement(
                    "INSERT INTO hotel.guests(name, room_number, age) values(?,?,?)");

            preparedStatement.setString(1, name);
            preparedStatement.setNull(2, java.sql.Types.INTEGER);
            preparedStatement.setInt(3, age);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Удаление постояльца из списка
    @Override
    public void deleteGuest(int idGuest) throws ObjectNotExistException {
        checkGuest(idGuest);
        try {
            PreparedStatement preparedStatement = connect.getConnection().prepareStatement(
                    "DELETE FROM hotel.guests WHERE id = ? AND room_number is null");
            preparedStatement.setInt(1, idGuest);

            if (preparedStatement.executeUpdate() == 0) {
                System.out.println("This guest has number! Evict him and try again.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    //Список постояльцев (всех)
    @Override
    public void printGuestList() throws ListIsEmptyException {
        List<Guest> guests = findAllGuest();
        if (guests.size() == 0) {
            throw new ListIsEmptyException("List of guests is empty!");
        }
        guests.stream().peek(n -> System.out.println("ID: " + n.getId() + " | Name: " + n.getName() +
                " | Age: " + n.getAge() + " | Number: " + number(n))).collect(Collectors.toList());
    }

    //Список незаселённых постояльцев
    @Override
    public void printWaitingGuests() throws ListIsEmptyException {
        List<Guest> guests = findAllGuest();
        if (guests.stream().noneMatch(p -> p.getRoomNumber() == null)) {
            throw new ListIsEmptyException("All residents is settled or list of guests is empty!");
        } else {
            System.out.println("List of waiting residents: ");
            guests.stream().filter(p -> p.getRoomNumber() == null).peek(n -> System.out.println("ID: " + n.getId() +
                    " | Name: " + n.getName() + " | Age: " + n.getAge())).collect(Collectors.toList());
        }
    }

    //Список заселённых постояльцев
    @Override
    public void printSettleGuests() throws ListIsEmptyException {
        List<Guest> guests = findAllGuest();
        if (guests.stream().noneMatch(p -> p.getRoomNumber() != null)) {
            throw new ListIsEmptyException("Residents hasn't been settled yet or list of guests is empty!");
        } else {
            System.out.println("List of settled residents: ");
            guests.stream().filter(p -> p.getRoomNumber() != null).peek(n -> System.out.println("ID: " + n.getId() +
                    " | Name: " + n.getName() + " | Age: " + n.getAge() + " | Number: " + number(n))).
                    collect(Collectors.toList());
        }
    }

    //Получение информации о комнате постояльца
    private String number(Guest guest) {
        if (guest.getRoomNumber() != null) {
            return guest.getRoomNumber().toString();
        } else {
            return "[without room]";
        }
    }

    //Проверка на существование постояльца
    public Guest checkGuest(int idGuest) throws ObjectNotExistException {
        Guest guest = findAllGuest().stream().filter(g -> g.getId() == idGuest).findFirst().orElse(null);
        if (guest != null) {
            return guest;
        } else {
            throw new ObjectNotExistException("This guest is not exist! Try again!");
        }
    }

    public List<Guest> findAllGuest() {
        return session.getSessionFactory().openSession().createQuery("From Guest").list();
    }

}
