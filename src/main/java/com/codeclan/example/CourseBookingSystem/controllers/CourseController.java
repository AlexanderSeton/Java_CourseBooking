package com.codeclan.example.CourseBookingSystem.controllers;

import com.codeclan.example.CourseBookingSystem.models.Course;
import com.codeclan.example.CourseBookingSystem.models.Customer;
import com.codeclan.example.CourseBookingSystem.repositories.CourseRepository;
import com.codeclan.example.CourseBookingSystem.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @GetMapping(value = "/courses")
    public ResponseEntity<List<Course>> findCourseFilterByCustomer(
            @RequestParam(name = "date", required = false) String date
    ){
        if (date != null) {
            return new ResponseEntity<>(courseRepository.findAll(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(courseRepository.findAll(),HttpStatus.OK);
        }
    }

    @GetMapping(value = "/courses/{id}")
    public ResponseEntity<Optional<Course>> getSpecificCourse(@PathVariable Long id){
        Optional<Course> payload = courseRepository.findById(id);
        if (payload.isPresent()){
            return new ResponseEntity<>(payload, HttpStatus.OK);
        }
        return new ResponseEntity<>(payload, HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/courses/bookings/customers")
    public ResponseEntity<List<Course>> findCoursesThatHaveCustomerIdQueryString(
            @RequestParam(name = "id") Long id
    ){
        return new ResponseEntity<>(courseRepository.findCoursesByBookingsCustomerId(id.longValue()), HttpStatus.OK);
    }
}
