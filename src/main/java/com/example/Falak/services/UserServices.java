package com.example.Falak.services;

import com.example.Falak.model.User;
import com.example.Falak.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServices  {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers (){
        List<User> userList = new ArrayList<>();
        userRepository.findAll().forEach(userList::add);
        return userList;
    }

    public List<User> getUsers (int teamId){
        List<User> userList = new ArrayList<>();
        userRepository.findByTeamId(teamId).forEach(userList::add);
        return userList;
    }

    public User getUser(int id){
        return userRepository.findById(id).orElse(null);
    }

    public void addUser(User user){
        userRepository.save(user);
    }

    public void updateUser(User user){
        userRepository.save(user);
    }

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

}
