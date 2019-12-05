package com.senla.hotel.backend.domain;

public class Guest {
    private static int idGuest = 0;

    private int id;
    private Integer idRoom;
    private String name;
    private int age;

    public Guest(String name, int age) {
        this.id = idGuest;
        idGuest++;
        this.idRoom = null;
        this.name = name;
        this.age = age;
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

    public Integer getRoomId() {
        return idRoom;
    }

    public void setRoomId(Integer idRoom) {
        this.idRoom = idRoom;
    }

}
