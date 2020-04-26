package com.example.Falak.model;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;

@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column
    @NotNull
    private Date date;

    @Column
    @NotNull
    private int hours;

    @ManyToOne
    @JoinColumn(name="room_id")
    private Room room;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;



    public Booking(){}

    public Booking (int id, Date date, Integer hours, Room room, User user){
        this.id = id;
        this.date = date;
        this.room = room;
        this.user = user;
        this.hours = hours;
    }

    public Integer getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public Integer getHours() {
        return hours;
    }

    public Room getRoom() {
        return room;
    }

    public User getUser() {
        return user;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
