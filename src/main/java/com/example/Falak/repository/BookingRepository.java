package com.example.Falak.repository;

import com.example.Falak.model.Room;
import com.example.Falak.model.Booking;
import com.example.Falak.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookingRepository extends CrudRepository<Booking,Integer> {

    List<Booking> findByRoomId(Integer roomId);
    List<Booking> findByUserId(Integer userId);


}
