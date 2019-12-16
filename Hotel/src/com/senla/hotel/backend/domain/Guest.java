package com.senla.hotel.backend.domain;

import com.senla.hotel.backend.repository.guest.FileLoadGuest;
import com.senla.hotel.resources.FillGuest;

public class Guest {
    private static int idGuest = FileLoadGuest.loadGuestId();
    private int id;
    private Integer roomNumber;
    @FillGuest(propertyName = "nameOne")
    private String name;
    @FillGuest(propertyName = "ageOne")
    private int age;
    public Guest(String name, int age) {
        this.id = idGuest++;
        this.roomNumber = null;
        this.name = name;
        this.age = age;
    }

    public static int getIdGuest() {
        return idGuest;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomId(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

}


