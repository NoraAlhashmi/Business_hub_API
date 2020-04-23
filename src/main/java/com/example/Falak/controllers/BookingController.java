package com.example.Falak.controllers;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.Falak.model.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController

public class BookingController {

    @RequestMapping("/users/bookings")
    public List<Booking> getAllBooking(){
        ArrayList<Booking> list = new ArrayList<Booking>();
       // list.add(new Booking(1,new Date(1),2, "new Tim",new Room("Big_Planet")));
        //list.add(new Booking(1,new Date(1),2, "new Tim",new Room("Small_Planet")));

        return list;
    }

}
