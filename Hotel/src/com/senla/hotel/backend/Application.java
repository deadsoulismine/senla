package com.senla.hotel.backend;

import com.senla.hotel.backend.domain.Guest;
import com.senla.hotel.backend.domain.Hotel;
import com.senla.hotel.backend.domain.Room;
import com.senla.hotel.backend.domain.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;

public class Application {
    private static Hotel hotel = new Hotel(new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

    public static void addRoom(int number, int price) {
        hotel.roomList().add(new Room(number, price, true, true));
    }

    //Optional.ofNullable(guest).ifPresent(hotel.guestList()::add);
    public static void addGuest(String name, int age, Integer roomId) {
        hotel.guestList().add(new Guest(name, age, roomId));
    }

    public static void addService(String title, int price) {
        hotel.serviceList().add(new Service(price, title));
    }

    public static void deleteGuest(int id) {
        hotel.guestList().removeAll(hotel.guestList().
                stream().filter(p -> p.getId() == id).collect(Collectors.toList()));
    }

    public static void deleteRoom(int id) {
        hotel.roomList().removeAll(hotel.roomList().
                stream().filter(p -> p.getId() == id).collect(Collectors.toList()));
    }

    public static void deleteService(int id) {
        hotel.serviceList().removeAll(hotel.serviceList().stream().
                filter(p -> p.getId() == id).collect(Collectors.toList()));
    }

    public static void printGuestList() {
        System.out.println("List of Guests: ");
        for (Guest n : hotel.guestList()) {
            System.out.println("ID: " + n.getId() + " | Name: " + n.getName() + " | Age: " + n.getAge());
        }
    }

    public static void printRoomList() {
        System.out.println("List of Rooms: ");
        for (Room n : hotel.roomList()) {
            System.out.println("ID: " + n.getId() + " | # " + n.getNumber()
                    + " | Price: " + n.getPrice() + " | " + status(n) + " | " + free(n));
        }
    }

    public static void printServiceList() {
        System.out.println("List of Services: ");
        for (Service n : hotel.serviceList()) {
            System.out.println("ID: " + n.getId() + " | Name: " + n.getName() + " | Price: " + n.getPrice());
        }
        System.out.println(new Guest().String());
    }

    public static String free(Room room) {
        if (room.getFree() && room.getStatus()) {
            return "свободно";
        } else {
            return "занято";
        }
    }

    public static String status(Room room) {
        if (room.getStatus()) {
            return "обслуживаемый";
        } else {
            return "ремонтируемый";
        }
    }

    public static void fileLoad(String name) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(name));
            String currentLine;

            while ((currentLine = bufferedReader.readLine()) != null) {
                String[] room = currentLine.split(" ");

                int number = Integer.parseInt(room[0]);
                int price = Integer.parseInt(room[1]);
                boolean free = Boolean.parseBoolean(room[2]);
                boolean status = Boolean.parseBoolean(room[3]);

                Room roomObject = new Room(number, price, free, status);
                hotel.roomList().add(roomObject);
            }
            bufferedReader.close();
    }

    public static void fileSave(String name) {
        try (FileWriter fileWriter = new FileWriter(name)) {
            for (Room room : hotel.roomList()) {
                fileWriter.write((room.getNumber()) + " ");
                fileWriter.write((room.getPrice()) + " ");
                fileWriter.write(room.getFree() + " ");
                fileWriter.write(room.getStatus() + " ");
                fileWriter.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String checkPrint(Object object) {
        if (!Optional.ofNullable(object).isPresent()) {
            return "[Не указано]";
        } else {
            return object.toString();
        }
    }

}
