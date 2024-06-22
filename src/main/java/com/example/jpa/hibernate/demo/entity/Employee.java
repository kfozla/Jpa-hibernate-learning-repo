package com.example.jpa.hibernate.demo.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Employee Type")
public abstract class Employee {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "name",nullable = false)
    private String name;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString(){
        return String.format("Employee[%s]",name);
    }

    public Employee(){

    }

    public Employee(String name){
        this.name=name;

    }
    public Employee(String name, Long id){
        this.name=name;
        this.id=id;

    }
}
