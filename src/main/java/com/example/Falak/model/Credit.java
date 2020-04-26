package com.example.Falak.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "credits")
public class Credit {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name="room_id")
    private Room room;

    @Column
    @NotNull
    private int hours;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "memberships_credits", joinColumns = @JoinColumn(name = "credit_id"), inverseJoinColumns = @JoinColumn(name = "membership_id"))
    private List<Membership> memberships = new ArrayList<>();

    public Credit(){}

    public Credit(int id, Room room,int hours, List<Membership> memberships){
        this.id=id;
        this.room=room;
        this.hours=hours;
        this.memberships=memberships;
    }

    public int getId() {
        return id;
    }

    public Room getRoom() {
        return room;
    }

    public int getHours() {
        return hours;
    }

    public List<Membership> getMemberships() {
        return memberships;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public void setMemberships(List<Membership> memberships) {
        this.memberships = memberships;
    }
}
