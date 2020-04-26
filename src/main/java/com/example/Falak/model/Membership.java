package com.example.Falak.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;

import java.util.List;

@Entity
@Table(name = "memberships")
public class Membership {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column
    @NotNull
    private String name;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "memberships_credits", joinColumns = @JoinColumn(name = "membership_id"), inverseJoinColumns = @JoinColumn(name = "credit_id"))
    private List<Credit> credits = new ArrayList<>();

    public Membership(){}

    public Membership(int id, String name, List<Credit> credits){
        this.id = id;
        this.name = name;
        this.credits = credits ;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Credit> getCredits() {
        return credits;
    }

    public void setCredits(List<Credit> credits) {
        this.credits = credits;
    }
}
