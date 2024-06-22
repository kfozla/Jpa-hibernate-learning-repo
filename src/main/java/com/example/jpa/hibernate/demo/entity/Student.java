package com.example.jpa.hibernate.demo.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "name",nullable = false)
    private String name;
    @OneToOne(fetch = FetchType.LAZY)
    private Passport passport;
    @Embedded
    private Address address;
    @ManyToMany
    @JoinTable(name = "STUDENT_COURSE",joinColumns = @JoinColumn(name="STUDENT_ID"),inverseJoinColumns = @JoinColumn(name="COURSE_ID"))
    private List<Course> courses=new ArrayList<>();
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void addCourses(Course course) {
        this.courses.add(course);
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String toString(){
        return String.format("Student[%s]",name);
    }

    public Student(){

    }

    public Student(String name){
        this.name=name;

    }
    public Student(String name, Long id){
        this.name=name;
        this.id=id;

    }
}
