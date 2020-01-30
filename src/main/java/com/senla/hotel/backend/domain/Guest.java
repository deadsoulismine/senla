package com.senla.hotel.backend.domain;

import com.senla.hotel.util.data.Fill;
import com.senla.hotel.util.dependency.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "hotel.guests", schema = "hotel")
@Component(type = "Instance")
public class Guest implements Serializable {

    @Fill(propertyName = "nameOne")
    private String name;

    @Fill(propertyName = "ageOne")
    private int age;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "room_number")
    private Integer roomNumber;

    @OneToMany(mappedBy = "guest")
    private List<Service> services;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    private Room room;

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
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

    public void setId(int id) {
        this.id = id;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }
}


