package com.codeclan.example.CourseBookingSystem.components;

import com.codeclan.example.CourseBookingSystem.models.Booking;
import com.codeclan.example.CourseBookingSystem.models.Course;
import com.codeclan.example.CourseBookingSystem.models.CourseRating;
import com.codeclan.example.CourseBookingSystem.models.Customer;
import com.codeclan.example.CourseBookingSystem.repositories.BookingRepository;
import com.codeclan.example.CourseBookingSystem.repositories.CourseRepository;
import com.codeclan.example.CourseBookingSystem.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    CustomerRepository customerRepository;

    public DataLoader() {
    }

    public void run(ApplicationArguments args) {

        Course course1 = new Course("Soft Dev", "Edinburgh", CourseRating.FIVE);
        courseRepository.save(course1);

        Course course2 = new Course("Soft Dev", "Edinburgh", CourseRating.FIVE);
        courseRepository.save(course2);

        Course course3 = new Course("Soft Dev", "Edinburgh", CourseRating.FIVE);
        courseRepository.save(course3);

        Customer customer1 = new Customer("Craig","Livingston", 25);
        customerRepository.save(customer1);

        Customer customer2 = new Customer("Sandy","Edinburgh", 26);
        customerRepository.save(customer2);

        Customer customer3 = new Customer("Ross","Leith", 31);
        customerRepository.save(customer3);

        Booking booking1 = new Booking(LocalDate.of(2022, 6, 20), course1,customer1);
        bookingRepository.save(booking1);

        Booking booking2 = new Booking(LocalDate.of(2023, 12, 25), course2, customer2);
        bookingRepository.save(booking2);

        Booking booking3 = new Booking(LocalDate.now(), course3, customer3);
        bookingRepository.save(booking3);

        // adding bookings to courses
        course1.addBooking(booking1);
        course2.addBooking(booking2);
        course3.addBooking(booking3);

        // adding bookings to customer
        customer1.addBooking(booking1);
        customer2.addBooking(booking2);
        customer3.addBooking(booking3);

    }
}
