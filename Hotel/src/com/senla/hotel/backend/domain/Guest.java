package com.senla.hotel.backend.domain;

public class Guest {
    String name;
    int age;
    int roomId;

    public Guest(String name, int age, int roomId) {
        this.name = name;
        this.age = age;
        this.roomId = roomId;
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

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

}
