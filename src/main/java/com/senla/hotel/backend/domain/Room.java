package com.senla.hotel.backend.domain;

import com.senla.hotel.util.dependency.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "hotel.rooms", schema = "hotel")
@Component(type = "Instance")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int number;
    private int price;
    private boolean status;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    private List<Guest> guests = new ArrayList<>();

    public Room() {
    }

    public void addGuest(Guest guest) {
        guest.setRoom(this);
        guest.setRoomNumber(this.number);
        guests.add(guest);
    }

    public void removeGuest(Guest guest) {
        guest.setRoom(null);
        guest.setRoomNumber(null);
        guests.remove(guest);
    }

    public void addRecord(Guest guest) {
        history.add(guest);
    }

    public void removeRecord() {
        history.remove(0);
    }

    @ManyToMany
    @JoinTable (name="hotel.room_history",
            joinColumns=@JoinColumn (name="room_id"),
            inverseJoinColumns=@JoinColumn(name="guest_id"))
    private List<Guest> history = new ArrayList<>();

    public List<Guest> getHistory() {
        return history;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isStatus() {
        return status;
    }

    public List<Guest> getGuests() {
        return guests;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setHistory(List<Guest> history) {
        this.history = history;
    }

    public void setGuests(List<Guest> guests) {
        this.guests = guests;
    }

}

