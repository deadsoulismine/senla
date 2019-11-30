package com.senla.hotel.backend.domain;

public class Guest {
    int id;
    Integer roomId;
    String name;
    int age;

    public Guest(int id, String name, int age, Integer roomId) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.roomId = roomId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
