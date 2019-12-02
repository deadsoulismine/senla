package com.senla.hotel.backend.domain;

public class Guest {
    private int idGuest = 0;
    Integer roomId;
    String name;
    int age;

    public Guest(String name, int age, Integer roomId) {
        this.idGuest = idGuest;
        idGuest++;
        this.name = name;
        this.age = age;
        this.roomId = roomId;
    }

    public int getId() {
        return idGuest;
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
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

}
