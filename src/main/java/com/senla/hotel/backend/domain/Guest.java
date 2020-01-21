package com.senla.hotel.backend.domain;

import com.senla.hotel.util.DI.stereotype.Component;
import com.senla.hotel.util.data.Fill;
import com.senla.hotel.util.data.LoadID;

@Component(type = "Instance")
public class Guest {
    private static int idGuest = LoadID.loadGuestId();
    @Fill(propertyName = "nameOne")
    private String name;
    @Fill(propertyName = "ageOne")
    private int age;
    private int id;
    private Integer roomNumber;

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


