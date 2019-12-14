package com.senla.hotel.backend.domain;

import com.senla.hotel.backend.repository.guest.FileLoadGuest;

public class Guest {
    public static int idGuest = FileLoadGuest.loadGuestId();
    private int id;
    private Integer roomNumber;
    private String name;
    private int age;

    public Guest(String name, int age) {
        this.id = idGuest++;
        this.roomNumber = null;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId() {
        this.id = idGuest++;
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

    public Integer getRoomId() {
        return roomNumber;
    }

    public void setRoomId(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

}


