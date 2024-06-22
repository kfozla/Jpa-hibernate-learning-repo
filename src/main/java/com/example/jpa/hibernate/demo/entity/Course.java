package com.example.jpa.hibernate.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@SQLDelete(sql="update course set is_deleted=true where id=?")
@Where(clause = "is_deleted = false")
public class Course {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "name",nullable = false)
    private String name;
    @OneToMany(mappedBy = "course")
    private List<Review> reviews= new ArrayList<>();
    @ManyToMany(mappedBy = "courses")
    @JsonIgnore
    private List<Student> students=new ArrayList<>();
    @Column(name = "last_updated_date")
    @UpdateTimestamp
    private LocalDateTime lastUpdateTime;
    @Column(name = "created_date")
    @CreationTimestamp
    private LocalDateTime createdDateTime;

    private boolean isDeleted;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void addReview(Review review) {
        this.reviews.add(review);
    }

    public void removeReview(Review review) {
        this.reviews.remove(review);
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    @PreRemove
    public void preRemove(){
        this.isDeleted=true;
    }

    public String toString(){
        return String.format("course[%s]",name);
    }

    public Course(){

    }

    public Course(String name){
        this.name=name;

    }
    public Course(String name, Long id){
        this.name=name;
        this.id=id;

    }
}
