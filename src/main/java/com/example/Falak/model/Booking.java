package com.example.Falak.model;
import javax.persistence.*;
import javax.validation.constraints.Past;
import java.util.Date;


public class Booking {


    private Integer id;


    @Past
    private Date date;

    private Integer hours;

    private Room room;

    private User user;

    public Booking (User user, Date date, Integer hours,  Room room){
        this.id = id;
        this.date = date;
        this.room = room;
        this.user = user;
    }


    public Date getDate() {
        return date;
    }

    public Integer getHours() {
        return hours;
    }

    public Integer getId() {
        return id;
    }


    public void setDate(Date date) {
        this.date = date;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    public void setId(Integer id) {
        this.id = id;
    }


}
