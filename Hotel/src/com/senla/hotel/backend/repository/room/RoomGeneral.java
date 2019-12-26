package com.senla.hotel.backend.repository.room;

import com.senla.hotel.backend.domain.Room;
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
public class RoomGeneral implements IRoomGeneral {
    @Autowired(className = "BeanFactory")
    private IBeanFactory beanFactory;

    private ArrayList<Room> rooms;


    public RoomGeneral() {
        this.rooms = new ArrayList<>();
    }

    @Override
    public ArrayList<Room> getRooms() {
        return rooms;
    }

    //Добавляем новый номер в список
    @Override
    public void addRoom(int number, int price) throws SameObjectsException {
        Room room = (Room) beanFactory.instantiateInstance("Room");
        room.setNumber(number);
        room.setPrice(price);
        for (Room n : rooms) {
            if (room.getNumber() == n.getNumber()) {
                throw new SameObjectsException("Apartments with this number already exist! Try again!");
            }
        }
        Optional.of(room).ifPresent(rooms::add);
    }

    //Удаление комнаты из списка
    @Override
    public void deleteRoom(int roomNumber) throws ObjectNotExistException {
        Optional.of(checkRoom(roomNumber)).ifPresent(rooms::remove);
    }

    //Изменение статуса номера
    @Override
    public void changeRoomStatus(int roomNumber) throws ObjectNotExistException {
        com.senla.hotel.backend.domain.Room tempRoom = checkRoom(roomNumber);
        if (tempRoom.getStatus()) {
            tempRoom.setStatus(false);
        } else {
            tempRoom.setStatus(true);
        }
    }

    //Изменение цены номера
    @Override
    public void changeRoomPrice(int idRoom, int price) throws ObjectNotExistException {
        checkRoom(idRoom).setPrice(price);
    }

    //Список всех номеров
    @Override
    public void printRoomList() throws ListIsEmptyException {
        if (rooms.size() == 0) {
            throw new ListIsEmptyException("List of rooms is empty!");
        }
        System.out.println("List of Rooms: ");
        rooms.stream().peek(n -> System.out.println("# " + n.getNumber() + " | Price: " + n.getPrice() + " | "
                + status(n) + " | " + free(n))).collect(Collectors.toList());
    }

    //Список пустых номеров
    @Override
    public void printFreeRoomList() throws ListIsEmptyException {
        if (rooms.stream().noneMatch(p -> p.getIdGuest() == null)) {
            throw new ListIsEmptyException("Hotel haven't free rooms or list of rooms is empty!");
        } else {
            System.out.println("List of free Rooms: ");
            rooms.stream().filter(p -> p.getIdGuest() == null).peek(n -> System.out.println("# " + n.getNumber() +
                    " | Price: " + n.getPrice() + " | " + status(n) + " | " + free(n))).collect(Collectors.toList());
        }
    }

    //Получение информации свободен ли номер
    private String free(Room room) {
        if (room.getIdGuest() == null && room.getStatus()) {
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
    public Room checkRoom(int roomNumber) throws ObjectNotExistException {
        Room checkRoom = rooms.stream().filter(p -> p.getNumber() == roomNumber).findFirst().
                orElse(null);
        if (checkRoom != null) {
            return checkRoom;
        } else {
            throw new ObjectNotExistException("This room is not exist! Try again!");
        }
    }

}
