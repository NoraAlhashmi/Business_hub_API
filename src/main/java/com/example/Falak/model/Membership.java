package com.example.Falak.model;

import java.util.List;

public class Membership {


    private Long id;

    private String name;

    private List<Credit> credits;

    public Membership(String name, List<Credit> credits){
        this.name = name;
        this.credits = credits;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
