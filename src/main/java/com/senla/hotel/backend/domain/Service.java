package com.senla.hotel.backend.domain;

import com.senla.hotel.util.dependency.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "hotel.services", schema = "services")
@Component(type = "Instance")
public class Service implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "price")
    private int price;

    @Column(name = "title")
    private String title;

    @ManyToMany
    @JoinTable (name="hotel.service_order",
            joinColumns=@JoinColumn (name="service_id"),
            inverseJoinColumns=@JoinColumn(name="guest_id"))
    private List<Guest> guests;

    public Service() {
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public List<Guest> getGuests() {
        return guests;
    }

    public void setGuests(List<Guest> guests) {
        this.guests = guests;
    }

}
