package com.example.Falak.services;

import com.example.Falak.model.Booking;
import com.example.Falak.model.User;
import com.example.Falak.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookingServices {

    @Autowired
    BookingRepository bookingRepository;

    public List<Booking> getAllBookings (){
        List<Booking> bookingList = new ArrayList<>();
        bookingRepository.findAll().forEach(bookingList::add);
        return bookingList;
    }

    public List<Booking> getBookingsByRoom (int roomId){
        List<Booking> bookingList = new ArrayList<>();
        bookingRepository.findByRoomId(roomId).forEach(bookingList::add);
        return bookingList;
    }

    public List<Booking> getBookingsByUser (int userId){
        List<Booking> bookingList = new ArrayList<>();
        bookingRepository.findByUserId(userId).forEach(bookingList::add);
        return bookingList;
    }

    public void addBooking(Booking booking){
        bookingRepository.save(booking);
    }

    public void updateBooking(Booking booking){
        bookingRepository.save(booking);
    }

    public void deleteBooking(int id) {
        bookingRepository.deleteById(id);
    }

    public Booking getBooking(int id){
        return bookingRepository.findById(id).orElse(null);
    }


}
