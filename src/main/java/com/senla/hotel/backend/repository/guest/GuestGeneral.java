package com.senla.hotel.backend.repository.guest;

import com.senla.hotel.backend.domain.Guest;
import com.senla.hotel.ui.exception.ListIsEmptyException;
import com.senla.hotel.ui.exception.ObjectNotExistException;
import com.senla.hotel.util.DI.IBeanFactory;
import com.senla.hotel.util.DI.annotation.Autowired;
import com.senla.hotel.util.DI.stereotype.Component;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class GuestGeneral implements IGuestGeneral {
    private ArrayList<Guest> guests;
    @Autowired(className = "BeanFactory")
    private IBeanFactory beanFactory;

    public GuestGeneral() {
        this.guests = new ArrayList<>();
    }

    public ArrayList<Guest> getGuests() {
        return guests;
    }

    //Добавляем нового постояльца в список
    @Override
    public void addGuest(String name, int age) {
        Guest guest = (Guest) beanFactory.instantiateInstance("Guest");
        guest.setName(name);
        guest.setAge(age);
        Optional.of(guest).ifPresent(guests::add);
    }

    //Удаление постояльца из списка
    @Override
    public void deleteGuest(int idGuest) throws ObjectNotExistException {
        Guest tempGuest = checkGuest(idGuest);
        if (tempGuest.getRoomNumber() == null) {
            Optional.of(checkGuest(idGuest)).ifPresent(guests::remove);
        } else {
            System.out.println("This guest has number! Evict him and try again.");
        }

    }

    //Список постояльцев (всех)
    @Override
    public void printGuestList() throws ListIsEmptyException {
        if (guests.size() == 0) {
            throw new ListIsEmptyException("List of guests is empty!");
        }
        System.out.println("List of Guests: ");
        guests.stream().peek(n -> System.out.println("ID: " + n.getId() + " | Name: " + n.getName() +
                " | Age: " + n.getAge() + " | Number: " + number(n))).collect(Collectors.toList());
    }

    //Список незаселённых постояльцев
    @Override
    public void printWaitingGuests() throws ListIsEmptyException {
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
        Guest checkGuest = guests.stream().filter(p -> p.getId() == idGuest).findFirst().orElse(null);
        if (checkGuest != null) {
            return checkGuest;
        } else {
            throw new ObjectNotExistException("This guest is not exist! Try again!");
        }
    }

}
