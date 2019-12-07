package com.senla.hotel.backend.service;

import com.senla.hotel.Main;
import com.senla.hotel.backend.Application;
import com.senla.hotel.backend.domain.Guest;
import com.senla.hotel.backend.domain.Room;
import com.senla.hotel.backend.domain.Service;
import com.senla.hotel.ui.exception.ObjectNotExistException;
import com.senla.hotel.ui.exception.SameObjectsException;

import java.util.Optional;
import java.util.stream.Collectors;

public class HotelMethods implements IHotelMethods {

    //Добавляем новый номер в список
    @Override
    public void addRoom(int number, int price) throws SameObjectsException {
        Room room = new Room(number, price);
        for (Room n : Application.getHotel().roomList()) {
            if (room.getNumber() == n.getNumber()) {
                throw new SameObjectsException("Apartments with this number already exist! Try again!");
            }
        }
        Optional.ofNullable(room).ifPresent(Application.getHotel().roomList()::add);
        printRoomList();
    }

    //Добавляем нового постояльца в список
    @Override
    public void addGuest(String name, int age) {
        Guest guest = new Guest(name, age);
        Optional.ofNullable(guest).ifPresent(Application.getHotel().guestList()::add);
    }

    //Добавляем новую услугу в список
    @Override
    public void addService(int price, String title) {
        Service service = new Service(price, title);
        Optional.ofNullable(service).ifPresent(Application.getHotel().serviceList()::add);
    }

    //Удаление комнаты из списка
    @Override
    public void deleteRoom(int idRoom) throws ObjectNotExistException {
        if (Application.getHotel().roomList().stream().anyMatch(p -> p.getId() == idRoom)) {
            Application.getHotel().roomList().removeAll(Application.getHotel().roomList().
                    stream().filter(p -> p.getId() == idRoom).collect(Collectors.toList()));
        } else {
            throw new ObjectNotExistException("This room is not exist! Try again!");
        }

    }

    //Удаление постояльца из списка
    @Override
    public void deleteGuest(int idGuest) {
        Application.getHotel().guestList().removeAll(Application.getHotel().guestList().
                stream().filter(p -> p.getId() == idGuest).collect(Collectors.toList()));
    }

    //Удаление услуги из списка
    @Override
    public void deleteService(int idService) {
        Application.getHotel().serviceList().removeAll(Application.getHotel().serviceList().stream().
                filter(p -> p.getId() == idService).collect(Collectors.toList()));
    }

    //Заселение
    @Override
    public void settle(int idGuest, int idRoom) {
        Application.getHotel().guestList().get(idGuest).setRoomId(idRoom);
        Application.getHotel().roomList().get(idRoom).setIdGuest(idGuest);
        System.out.println("Постоялец " + Application.getHotel().guestList().get(idGuest).getName() +
                " заселен в номер: " + Application.getHotel().roomList().get(idRoom).getNumber());

        //Добавление постояльца в историю заселения номера
        //Проверка на переполнение количества записей в истории
        if (Application.getHotel().roomList().get(idRoom).getHistory().size() ==
                Integer.parseInt(Main.prop.getProperty("history_size", "1"))) {
            Application.getHotel().roomList().get(idRoom).getHistory().remove(0);
        }
        //Запись
        Application.getHotel().roomList().get(idRoom).getHistory().add(Application.getHotel().guestList().get(idGuest));
    }

    //Выселение
    @Override
    public void evict(int idGuest) {
        System.out.println("Постоялец " + Application.getHotel().guestList().get(idGuest).getName() +
                "выселен из номера: " + Application.getHotel().roomList().
                get(Application.getHotel().guestList().get(idGuest).getRoomId()).getNumber());
        Application.getHotel().guestList().get(idGuest).setRoomId(null);
    }

    //Изменение статуса номера
    @Override
    public void changeRoomStatus(int idRoom) {
        if (Application.getHotel().roomList().get(idRoom).getStatus()) {
            Application.getHotel().roomList().get(idRoom).setStatus(false);
        } else {
            Application.getHotel().roomList().get(idRoom).setStatus(true);
        }
    }

    @Override
    public void changeRoomPrice(int idRoom, int price) {
        Application.getHotel().roomList().get(idRoom).setPrice(price);
    }

    @Override
    public void changeServicePrice(int idService, int price) {
        Application.getHotel().serviceList().get(idService).setPrice(price);
    }

    public void printRoomList() {
        System.out.println("List of Rooms: ");
        Application.getHotel().roomList().stream().peek(n -> System.out.println("ID: " + n.getId() +
                " | # " + n.getNumber() + " | Price: " + n.getPrice() + " | " + status(n) + " | " + free(n)))
                .collect(Collectors.toList());
    }

    public void printGuestList() {
        System.out.println("List of Guests: ");
        Application.getHotel().guestList().stream().peek(n -> System.out.println("ID: " + n.getId() +
                " | Name: " + n.getName() + " | Age: " + n.getAge())).collect(Collectors.toList());
    }

    public void printServiceList() {
        System.out.println("List of Services: ");
        Application.getHotel().serviceList().stream().peek(n -> System.out.println("ID: " + n.getId() +
                " | Name: " + n.getName() + " | Price: " + n.getPrice())).collect(Collectors.toList());
    }

    public void printFreeRoomList() {
        System.out.println("List of free Rooms: ");
        Application.getHotel().roomList().stream().filter(p -> p.getIdGuest() == null).
                peek(n -> System.out.println("ID: " + n.getId() + " | # " + n.getNumber()
                        + " | Price: " + n.getPrice() + " | " + status(n) + " | " + free(n))).
                collect(Collectors.toList());
    }

    //Поиск свободного номера
    private Room getFreeRoom() {
        return Application.getHotel().roomList().stream().filter(o -> o.getIdGuest() == null).
                findFirst().orElse(null);
    }

    //Получение информации свободна ли номер
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

}
