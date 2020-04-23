package com.example.Falak.services;

import com.example.Falak.model.Room;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class RoomServices {

    private List<Room> roomList = Arrays.asList(new Room ("Big_Planet"),new Room ("Small_Planet"));

    public List<Room> getAllRooms (){
        return roomList;
    }

    public Room getRoom(String title){

        for (Room room: roomList)
            if (room.getTitle().equals(title))
                return room;

        return null;
    }
}
