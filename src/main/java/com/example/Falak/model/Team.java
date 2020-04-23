package com.example.Falak.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name = "teams")
public class Team {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column
    @NotNull
    private String name;

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<User> users = new ArrayList<>();
    //private Membership membership;

    public Team(){}

    public Team (String name){
        this.name = name;
    }

    public Team (int id, String name){
        this.id = id;
        this.name = name;
    }

    public Team (int id, String name, List<User> users){
        this.id = id;
        this.name = name;
        this.users = users;
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

    public void addUser (User user){
        users.add(user);
        user.setTeam(this);
    }

    public void removeUser (User user){
        users.remove(user);
        user.setTeam(null);
    }

  //  public void setMembership(Membership membership) {
  //      this.membership = membership;}

    public String toString(){
        String result = "Team: "+ name +"\n";
        for (User user : users)
            result += user.toString() +"\n";
        return result;
    }

}
