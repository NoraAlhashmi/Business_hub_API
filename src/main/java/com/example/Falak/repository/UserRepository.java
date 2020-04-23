package com.example.Falak.repository;

import com.example.Falak.model.User;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface UserRepository extends CrudRepository <User,Integer> {

    public List<User> findByTeamId(Integer teamId);
    public User findByEmail(String email);


}
