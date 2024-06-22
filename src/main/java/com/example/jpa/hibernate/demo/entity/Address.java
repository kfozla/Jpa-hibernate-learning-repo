package com.example.jpa.hibernate.demo.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {
    String line1;
    String line2;
    String city;

    public Address(String line1, String line2, String city) {
        this.line1=line1;
        this.line2=line2;
        this.city=city;
    }
    public Address(){

    }

    public String toString(){
        return line1+line2+city;
    }
}
