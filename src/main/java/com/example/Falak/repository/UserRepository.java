package com.example.Falak.repository;

import com.example.Falak.model.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface UserRepository extends CrudRepository <User,Integer> {

    List<User> findByTeamId(Integer teamId);
    User findByEmail(String email);



}
