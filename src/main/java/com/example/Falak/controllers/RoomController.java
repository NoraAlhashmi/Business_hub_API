package com.example.Falak.controllers;

import com.example.Falak.model.Room;
import com.example.Falak.services.RoomServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomController {

    @Autowired
    private RoomServices roomServices;

    @GetMapping
    public List<Room> getAllRooms(){
        return roomServices.getAllRooms();
    }

    @GetMapping("/{title}")
    public Room getRoom (@PathVariable String title){
        return roomServices.getRoom(title);
    }
}
