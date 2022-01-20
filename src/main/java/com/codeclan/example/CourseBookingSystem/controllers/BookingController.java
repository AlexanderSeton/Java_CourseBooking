package com.codeclan.example.CourseBookingSystem.controllers;

import com.codeclan.example.CourseBookingSystem.models.Booking;
import com.codeclan.example.CourseBookingSystem.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
public class BookingController {

    @Autowired
    BookingRepository bookingRepository;

    @GetMapping(value = "/bookings")
    public ResponseEntity<List<Booking>> findBookingsFilterByDate(
            @RequestParam(name = "date", required = false) String date
    ){
        if (date != null) {
            return new ResponseEntity<>(bookingRepository.findBookingsByDate(LocalDate.parse(date)), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(bookingRepository.findAll(),HttpStatus.OK);
        }
    }

    @GetMapping(value = "/bookings/{id}")
    public ResponseEntity<Optional<Booking>> getSpecificDistillery(@PathVariable Long id){
        Optional<Booking> payload = bookingRepository.findById(id);
        if (payload.isPresent()){
            return new ResponseEntity<>(payload, HttpStatus.OK);
        }
        return new ResponseEntity<>(payload, HttpStatus.NOT_FOUND);
    }
}
