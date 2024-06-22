package com.example.jpa.hibernate.demo.entity;

import jakarta.persistence.*;

@Entity
public class Review {
    @Id
    @GeneratedValue
    private long id;
    @Column(name = "rating",nullable = false)
    private String rating;
    @Column(name = "description")
    private String description;

    @ManyToOne
    private Course course;

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String toString(){
        return String.format("Review[%s]",description,rating);
    }

    public Review(){

    }

    public Review(String description){
        this.description=description;

    }
    public Review(String rating, String description){
        this.description=description;
        this.rating=rating;

    }
}
