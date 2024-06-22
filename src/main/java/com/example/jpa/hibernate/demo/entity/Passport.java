package com.example.jpa.hibernate.demo.entity;

import jakarta.persistence.*;

@Entity
public class Passport {
    @Id
    @GeneratedValue
    private long id;
    @Column(name = "number",nullable = false)
    private String number;
    @OneToOne(fetch = FetchType.LAZY,mappedBy = "passport")
    private Student student;
    public Long getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String toString(){
        return String.format("Passport[%s]",number);
    }

    public Passport(){

    }

    public Passport(String number){
        this.number=number;

    }
    public Passport(String number, Long id){
        this.number=number;
        this.id=id;

    }
}
