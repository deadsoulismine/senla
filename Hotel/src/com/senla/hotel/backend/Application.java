package com.senla.hotel.backend;

import com.senla.hotel.backend.domain.*;

import java.util.ArrayList;

public class Application {
    private static Hotel hotel = new Hotel(new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
    private static int id = 0;

    public static void addRoom(int number, int price) {
        hotel.roomList().add(new Room(number, price, true, true));
        System.out.println("New list of Rooms: ");
        for (Room n: hotel.roomList()
        ) {
            System.out.println(n.getNumber());
        }
    }

    //Optional.ofNullable(guest).ifPresent(hotel.guestList()::add);
    public static void addGuest(String name, int age, Integer roomId) {
        hotel.guestList().add(new Guest(id, name, age, roomId));
        id++;
    }

    public static void addService(String title, int price) {
        hotel.serviceList().add(new Service(price, title));
        System.out.println("New list of Services: ");
        for (Service n: hotel.serviceList()
        ) {
            System.out.println(n.getName());
        }
    }

    public static void deleteGuest(int id) {
        hotel.guestList().remove(id);
    }

    public static void deleteRoom(Integer number) {
        hotel.roomList().remove(number);
    }

    public static void printGuestList() {
        System.out.println("List of Guests: ");
        for (Guest n: hotel.guestList()) {
            System.out.println("ID: " + n.getId() + " | Name: " + n.getName() + " | Age: "+ n.getAge());
        }
    }

    public static void printRoomList() {
        System.out.println("List of Rooms: ");
        for (Room n: hotel.roomList()) {
            System.out.println("# " + n.getNumber() + " | Price: " + n.getPrice() +  " | Status: " + n.getStatus() + " | Free: " + n.getFree());
        }
    }

}
