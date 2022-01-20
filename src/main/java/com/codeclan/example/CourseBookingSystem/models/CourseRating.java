package com.codeclan.example.CourseBookingSystem.models;

public enum CourseRating {

    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5);

    private final int rating;

    CourseRating(int rating) {
        this.rating = rating;
    }

    public int getRating() {
        return this.rating;
    }
}
