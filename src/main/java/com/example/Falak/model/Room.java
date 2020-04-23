package com.example.Falak.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Room {

    private String name;

    private int id;

    public Room (String name){
        this.name=name;
    }

    public String getTitle(){
        return name;
    }

}
