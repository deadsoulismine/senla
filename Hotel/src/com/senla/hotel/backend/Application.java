package com.senla.hotel.backend;

import com.senla.hotel.backend.domain.Hotel;
import com.senla.hotel.backend.repository.guest.FileLoadGuest;
import com.senla.hotel.backend.repository.guest.FileSaveGuest;
import com.senla.hotel.backend.repository.room.FileLoadRoom;
import com.senla.hotel.backend.repository.room.FileSaveRoom;
import com.senla.hotel.backend.repository.service.FileLoadService;
import com.senla.hotel.backend.repository.service.FileSaveService;
import com.senla.hotel.ui.exception.ListIsEmptyException;
import com.senla.hotel.ui.exception.ObjectNotExistException;
import com.senla.hotel.ui.exception.SameObjectsException;

import java.io.IOException;
import java.util.ArrayList;

public class Application {
    private static Hotel hotel = new Hotel(new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

    public static Hotel getHotel() {
        return hotel;
    }

    public static void addRoom(int number, int price) throws SameObjectsException {
        hotel.getHotelMethods().addRoom(number, price);
    }

    public static void addGuest(String name, int age) {
        hotel.getHotelMethods().addGuest(name, age);
    }

    public static void addService(String title, int price) throws SameObjectsException {
        hotel.getHotelMethods().addService(price, title);
    }

    public static void deleteRoom(int idRoom) throws ObjectNotExistException, ListIsEmptyException {
        hotel.getHotelMethods().deleteRoom(idRoom);
    }

    public static void deleteGuest(int idGuest) throws ObjectNotExistException {
        hotel.getHotelMethods().deleteGuest(idGuest);
    }

    public static void deleteService(int idService) throws ObjectNotExistException {
        hotel.getHotelMethods().deleteService(idService);
    }

    public static void printRoomList() throws ListIsEmptyException {
        hotel.getHotelMethods().printRoomList();
    }

    public static void printGuestList() throws ListIsEmptyException {
        hotel.getHotelMethods().printGuestList();
    }

    public static void printServiceList() throws ListIsEmptyException {
        hotel.getHotelMethods().printServiceList();
    }

    public static void printFreeRoomList() throws ListIsEmptyException {
        hotel.getHotelMethods().printFreeRoomList();
    }

    public static void printWaitingGuests() throws ListIsEmptyException {
        hotel.getHotelMethods().printWaitingGuests();
    }

    public static void printSettleGuests() throws ListIsEmptyException {
        hotel.getHotelMethods().printSettleGuests();
    }

    public static void fileLoadRoom(String name) throws IOException {
        FileLoadRoom.fileLoadRoom(name);
    }

    public static void fileLoadGuest(String name) throws IOException {
        FileLoadGuest.fileLoadGuest(name);
    }

    public static void fileLoadService(String name) throws IOException {
        FileLoadService.fileLoadService(name);
    }

    public static void fileSaveRoom(String name) {
        FileSaveRoom.fileSaveRoom(name);
    }

    public static void fileSaveGuest(String name) {
        FileSaveGuest.fileSaveGuest(name);
    }

    public static void fileSaveService(String name) {
        FileSaveService.fileSaveService(name);
    }

    public static void settle(int idGuest, int roomNumber) throws ObjectNotExistException {
        hotel.getHotelMethods().settle(idGuest, roomNumber);
    }

    public static void evict(int idGuest) throws ObjectNotExistException {
        hotel.getHotelMethods().evict(idGuest);
    }

    public static void changeRoomStatus(int idRoom) throws ObjectNotExistException {
        hotel.getHotelMethods().changeRoomStatus(idRoom);
    }

    public static void changeRoomPrice(int idRoom, int price) throws ObjectNotExistException {
        hotel.getHotelMethods().changeRoomPrice(idRoom, price);
    }

    public static void changeServicePrice(int idService, int price) throws ObjectNotExistException {
        hotel.getHotelMethods().changeServicePrice(idService, price);
    }

}


