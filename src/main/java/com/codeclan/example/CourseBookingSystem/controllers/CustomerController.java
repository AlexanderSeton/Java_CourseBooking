package com.codeclan.example.CourseBookingSystem.controllers;

import com.codeclan.example.CourseBookingSystem.models.Booking;
import com.codeclan.example.CourseBookingSystem.models.Customer;
import com.codeclan.example.CourseBookingSystem.repositories.BookingRepository;
import com.codeclan.example.CourseBookingSystem.repositories.CustomerRepository;
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
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping(value = "/customers")
    public ResponseEntity<List<Customer>> findCustomersFilterByCourse(
            @RequestParam(name = "date", required = false) String date
    ){
        if (date != null) {
            return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(customerRepository.findAll(),HttpStatus.OK);
        }
    }

    @GetMapping(value = "/customers/{id}")
    public ResponseEntity<Optional<Customer>> getSpecificCustomer(@PathVariable Long id){
        Optional<Customer> payload = customerRepository.findById(id);
        if (payload.isPresent()){
            return new ResponseEntity<>(payload, HttpStatus.OK);
        }
        return new ResponseEntity<>(payload, HttpStatus.NOT_FOUND);
    }
    
    @GetMapping(value = "/customers/bookings/courses")
    public ResponseEntity<List<Customer>> findCustomersThatHaveCourseIdQueryString(
            @RequestParam(name = "id") Long id,
            @RequestParam(name = "town") String town
    ){
        if (id != null && town != null){
            return new ResponseEntity<>(customerRepository.findCustomersByTownAndBookingsCourseId(town, id.longValue()), HttpStatus.OK);
        } else if (id != null && town == null){
            return new ResponseEntity<>(customerRepository.findCustomersByBookingsCourseId(id.longValue()), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.NOT_FOUND);
        }
    }
}
