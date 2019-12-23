package com.senla.hotel.backend.domain;

import com.senla.hotel.backend.repository.guest.FileLoadGuest;
import com.senla.hotel.util.DI.stereotype.Instance;
import com.senla.hotel.util.FillGuest;

@Instance
public class Guest {
    private static int idGuest = FileLoadGuest.loadGuestId();
    private int id;
    private Integer roomNumber;
    @FillGuest(propertyName = "nameOne")
    private String name;
    @FillGuest(propertyName = "ageOne")
    private int age;

    public Guest() {
        this.id = idGuest++;
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


