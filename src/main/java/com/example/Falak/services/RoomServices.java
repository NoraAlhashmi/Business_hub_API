package com.example.Falak.services;

import com.example.Falak.model.Room;
import com.example.Falak.model.Team;
import com.example.Falak.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class RoomServices {

    @Autowired
    RoomRepository roomRepository;

    public List<Room> getAllRooms (){
        List<Room> roomList = new ArrayList<>();
        roomRepository.findAll().forEach(roomList::add);
        return roomList;
    }

    public Room getRoom(int id){
        return roomRepository.findById(id).orElse(null);
    }


}
