package com.example.Falak.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "rooms")
public class Room {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column
    @NotNull
    private String name;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Booking> bookings = new ArrayList<>();

   /* @OneToMany(mappedBy = "room", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Booking> credits = new ArrayList<>();*/

    public Room(){}

    public Room (int id,String name, List<Booking> bookings, List<Booking> credits){

        this.id = id;
        this.name=name;
        this.bookings = bookings;
        //this.credits = credits;
    }

    public String getName(){
        return name;
    }

    public int getId() {
        return id;
    }
}
