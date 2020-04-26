package com.example.Falak.controllers;


import com.example.Falak.services.BookingServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.Falak.model.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    BookingServices bookingServices;


    @GetMapping
    public List<Booking> getBookingsByRoom(@RequestParam("roomId") Optional<Integer> roomId, @RequestParam("userId") Optional<Integer> userId){
        if (!userId.isEmpty())
                return bookingServices.getBookingsByUser(userId.get());
        else if (!roomId.isEmpty())
            return bookingServices.getBookingsByRoom(roomId.get());
        else return null;
    }


    @GetMapping("/{id}")
    public Booking getBooking (@PathVariable int id){
        return bookingServices.getBooking(id);
    }

    @PostMapping
    public void addBooking(@RequestBody Booking booking){
        bookingServices.addBooking(booking);
    }

    @PutMapping("/{id}")
    public void updateBooking(@RequestBody Booking booking, @PathVariable int id){
        bookingServices.updateBooking(booking);
    }

    @DeleteMapping("/{id}")
    public void deleteBooking (@PathVariable int id){
        bookingServices.deleteBooking(id);
    }

}
