package com.example.Falak.controllers;

import com.example.Falak.model.User;
import com.example.Falak.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserServices userServices;

    @GetMapping("/users")
    public List<User> getUsersByTeam(@RequestParam("teamId") Optional<Integer> teamId){
        if (teamId.isEmpty())
            return userServices.getAllUsers();
        else return userServices.getUsers(teamId.get());
    }

   // @GetMapping("/users")
    //public List<User> getUsers(){
   //     return userServices.getAllUsers();
    //}

    @GetMapping("/users/{id}")
    public User getUser (@PathVariable int id){
        return userServices.getUser(id);
    }

    @PostMapping("/users")
    public void addUser(@RequestBody User user){
        userServices.addUser(user);
    }

    @PutMapping("/users/{id}")
    public void updateUser(@RequestBody User user, @PathVariable int id){
        userServices.updateUser(user);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser (@PathVariable int id){
        userServices.deleteUser(id);
    }

}
