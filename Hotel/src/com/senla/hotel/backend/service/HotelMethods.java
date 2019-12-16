package com.senla.hotel.backend.service;

import com.senla.hotel.backend.domain.Guest;
import com.senla.hotel.backend.domain.Room;
import com.senla.hotel.backend.domain.Service;
import com.senla.hotel.ui.exception.ListIsEmptyException;
import com.senla.hotel.ui.exception.ObjectNotExistException;
import com.senla.hotel.ui.exception.SameObjectsException;

import java.util.Optional;
import java.util.stream.Collectors;

import static com.senla.hotel.backend.Application.getHotel;
import static com.senla.hotel.util.Data.getProp;
import static java.lang.Integer.parseInt;

public class HotelMethods implements IHotelMethods {

    //Добавляем новый номер в список
    @Override
    public void addRoom(int number, int price) throws SameObjectsException {
        Room room = new Room(number, price);
        for (Room n : getHotel().roomList()) {
            if (room.getNumber() == n.getNumber()) {
                throw new SameObjectsException("Apartments with this number already exist! Try again!");
            }
        }
        Optional.of(room).ifPresent(getHotel().roomList()::add);
    }

    //Добавляем нового постояльца в список
    @Override
    public void addGuest(String name, int age) {
        Optional.of(new Guest(name, age)).ifPresent(getHotel().guestList()::add);
    }

    //Добавляем новую услугу в список
    @Override
    public void addService(int price, String title) throws SameObjectsException {
        Service service = new Service(price, title);
        for (Service temp : getHotel().serviceList()) {
            if (service.getTitle().equals(temp.getTitle()) && service.getPrice() == temp.getPrice()) {
                throw new SameObjectsException("This service already exist! Try again!");
            }
        }
        Optional.of(service).ifPresent(getHotel().serviceList()::add);
    }

    //Удаление комнаты из списка
    @Override
    public void deleteRoom(int roomNumber) throws ObjectNotExistException {
        Optional.of(checkRoom(roomNumber)).ifPresent(getHotel().roomList()::remove);
    }

    //Удаление постояльца из списка
    @Override
    public void deleteGuest(int idGuest) throws ObjectNotExistException {
        Optional.of(checkGuest(idGuest)).ifPresent(getHotel().guestList()::remove);
    }

    //Удаление услуги из списка
    @Override
    public void deleteService(int idService) throws ObjectNotExistException {
        Optional.of(checkService(idService)).ifPresent(getHotel().serviceList()::remove);
    }

    //Заселение
    @Override
    public void settle(int idGuest, int roomNumber) throws ObjectNotExistException {
        Guest settleGuest = checkGuest(idGuest);
        Room settleRoom = checkRoom(roomNumber);

        if (settleGuest.getRoomNumber() == null) {
            if (settleRoom.getIdGuest() == null) {
                settleGuest.setRoomId(settleRoom.getNumber());
                settleRoom.setIdGuest(settleGuest.getId());
                System.out.println("Guest " + settleGuest.getName() + " settled in room: " + settleRoom.getNumber());
                //Проверка на переполнение количества записей в истории
                if (settleRoom.getHistory().size() == parseInt(getProp().getProperty("history_size", "1"))) {
                    settleRoom.getHistory().remove(0);
                }
                //Добавление постояльца в историю заселения номера
                settleRoom.getHistory().add(
                        getHotel().guestList().stream().filter
                                (g -> g.getId() == idGuest).findFirst().orElse(null));
            } else {
                System.out.println("This room is busy!");
            }
        } else {
            System.out.println("This guest had settled!");
        }
    }

    //Выселение
    public void evict(int idGuest) throws ObjectNotExistException {
        Guest evictGuest = checkGuest(idGuest);
        if (evictGuest.getRoomNumber() != null) {
            System.out.println("Guest " + evictGuest.getName() + " evicted from room: " + evictGuest.getRoomNumber());
            //Выселение
            Guest guest = getHotel().guestList().stream().
                    filter(g -> g.getId() == idGuest).findFirst().orElse(null);
            getHotel().roomList().stream().
                    filter(g -> g.getNumber() == guest.getRoomNumber()).findFirst().orElse(null).setIdGuest(null);
            guest.setRoomId(null);


        } else {
            System.out.println("This guest don't settle!");
        }
    }

    //Изменение статуса номера
    @Override
    public void changeRoomStatus(int roomNumber) throws ObjectNotExistException {
        Room tempRoom = checkRoom(roomNumber);
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

    //Изменение цены услуги
    @Override
    public void changeServicePrice(int idService, int price) throws ObjectNotExistException {
        checkService(idService).setPrice(price);
    }

    //Список всех номеров
    public void printRoomList() throws ListIsEmptyException {
        if (getHotel().roomList().size() == 0) {
            throw new ListIsEmptyException("List of rooms is empty!");
        }
        System.out.println("List of Rooms: ");
        getHotel().roomList().stream().peek(n -> System.out.println("# " + n.getNumber() + " | Price: " +
                n.getPrice() + " | " + status(n) + " | " + free(n))).collect(Collectors.toList());
    }

    //Список постояльцев (всех)
    public void printGuestList() throws ListIsEmptyException {
        if (getHotel().guestList().size() == 0) {
            throw new ListIsEmptyException("List of guests is empty!");
        }
        System.out.println("List of Guests: ");
        getHotel().guestList().stream().peek(n -> System.out.println("ID: " + n.getId() +
                " | Name: " + n.getName() + " | Age: " + n.getAge() + " | Room: " + number(n))).
                collect(Collectors.toList());
    }

    //Список услуг
    public void printServiceList() throws ListIsEmptyException {
        if (getHotel().serviceList().size() == 0) {
            throw new ListIsEmptyException("List of services is empty!");
        }
        System.out.println("List of Services: ");
        getHotel().serviceList().stream().peek(n -> System.out.println("ID: " + n.getId() +
                " | Name: " + n.getTitle() + " | Price: " + n.getPrice())).collect(Collectors.toList());
    }

    //Список пустых номеров
    public void printFreeRoomList() throws ListIsEmptyException {
        if (getHotel().roomList().stream().noneMatch(p -> p.getIdGuest() == null)) {
            throw new ListIsEmptyException("Hotel haven't free rooms or list of rooms is empty!");
        } else {
            System.out.println("List of free Rooms: ");
            getHotel().roomList().stream().filter(p -> p.getIdGuest() == null).peek(n -> System.out.println(
                    "# " + n.getNumber() + " | Price: " + n.getPrice() + " | " + status(n) + " | " + free(n))).
                    collect(Collectors.toList());
        }
    }

    //Список незаселённых постояльцев
    public void printWaitingGuests() throws ListIsEmptyException {
        if (getHotel().guestList().stream().noneMatch(p -> p.getRoomNumber() == null)) {
            throw new ListIsEmptyException("All residents is settled or list of guests is empty!");
        } else {
            System.out.println("List of waiting residents: ");
            getHotel().guestList().stream().filter(p -> p.getRoomNumber() == null).peek(n -> System.out.println(
                    "ID: " + n.getId() + " | Name: " + n.getName() + " | Age: " + n.getAge() +
                            " | Room: " + number(n))).collect(Collectors.toList());
        }
    }

    //Список заселённых постояльцев
    public void printSettleGuests() throws ListIsEmptyException {
        if (getHotel().guestList().stream().noneMatch(p -> p.getRoomNumber() != null)) {
            throw new ListIsEmptyException("Residents hasn't been settled yet or list of guests is empty!");
        } else {
            System.out.println("List of settled residents: ");
            getHotel().guestList().stream().filter(p -> p.getRoomNumber() != null).peek(n -> System.out.println(
                    "ID: " + n.getId() + " | Name: " + n.getName() + " | Age: " + n.getAge() +
                            " | Room: " + number(n))).collect(Collectors.toList());
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

    //Получение информации о комнате постояльца
    private String number(Guest guest) {
        if (guest.getRoomNumber() != null) {
            return guest.getRoomNumber().toString();
        } else {
            return "[without room]";
        }
    }

    //Проверка на существование комнаты
    private Room checkRoom(int roomNumber) throws ObjectNotExistException {
        Room checkRoom = getHotel().roomList().stream().filter(p -> p.getNumber() == roomNumber).findFirst().
                orElse(null);
        if (checkRoom != null) {
            return checkRoom;
        } else {
            throw new ObjectNotExistException("This room is not exist! Try again!");
        }
    }

    //Проверка на существование постояльца
    private Guest checkGuest(int idGuest) throws ObjectNotExistException {
        Guest checkGuest = getHotel().guestList().stream().filter(p -> p.getId() == idGuest).findFirst().
                orElse(null);
        if (checkGuest != null) {
            return checkGuest;
        } else {
            throw new ObjectNotExistException("This guest is not exist! Try again!");
        }
    }

    //Проверка на существование услуги
    private Service checkService(int idService) throws ObjectNotExistException {
        Service checkService = getHotel().serviceList().stream().filter(p -> p.getId() == idService).findFirst().
                orElse(null);
        if (checkService != null) {
            return checkService;
        } else {
            throw new ObjectNotExistException("This service is not exist! Try again!");
        }
    }

}
