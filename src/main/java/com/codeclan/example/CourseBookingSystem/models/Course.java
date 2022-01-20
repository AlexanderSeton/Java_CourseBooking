package com.codeclan.example.CourseBookingSystem.models;

import javax.persistence.*;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "town")
    private String town;

    @Column(name = "course_rating")
    private CourseRating courseRating;

    public Course() {
    }

    public Course(String name, String town, CourseRating courseRating) {
        this.name = name;
        this.town = town;
        this.courseRating = courseRating;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public CourseRating getCourseRating() {
        return courseRating;
    }

    public void setCourseRating(CourseRating courseRating) {
        this.courseRating = courseRating;
    }
}
