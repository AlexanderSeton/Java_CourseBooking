package com.codeclan.example.CourseBookingSystem.repositories;

import com.codeclan.example.CourseBookingSystem.models.Course;
import com.codeclan.example.CourseBookingSystem.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findCustomersByBookingsCourseId(Long id);

    List<Customer> findCustomersByTownAndBookingsCourseId(String town, Long id);

    List<Customer> findCustomersByTownAndBookingsCourseIdAndAgeGreaterThan(String town, Long id, Integer age);

}
