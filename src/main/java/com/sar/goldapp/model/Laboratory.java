package com.sar.goldapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "laboratory")
public class Laboratory {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "laboratory_generator")
    @SequenceGenerator(name = "laboratory_generator", sequenceName = "laboratory_seq", allocationSize = 1, initialValue = 5)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "phone_number_one")
    private String phoneNumberOne;

    @Column(name = "phone_number_two")
    private String phoneNumberTwo;

    @Column(name = "phone_number_three")
    private String phoneNumberThree;

    @Column(name = "city")
    private String city;

    @Column(name = "address")
    private String address;

    @Column(name = "description")
    private String description;

    @Column(name = "p_code")
    private String pCode;

    @OneToOne(mappedBy = "laboratory", cascade = CascadeType.ALL)
    @JsonIgnore
    private Audience audience;

    public Laboratory() {
    }

    public Laboratory(String name, String phoneNumberOne, String phoneNumberTwo, String phoneNumberThree, String city,
                      String address, String description, String pCode) {
        this.name = name;
        this.phoneNumberOne = phoneNumberOne;
        this.phoneNumberTwo = phoneNumberTwo;
        this.phoneNumberThree = phoneNumberThree;
        this.city = city;
        this.address = address;
        this.description = description;
        this.pCode = pCode;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumberOne() {
        return phoneNumberOne;
    }

    public void setPhoneNumberOne(String phoneNumberOne) {
        this.phoneNumberOne = phoneNumberOne;
    }

    public String getPhoneNumberTwo() {
        return phoneNumberTwo;
    }

    public void setPhoneNumberTwo(String phoneNumberTwo) {
        this.phoneNumberTwo = phoneNumberTwo;
    }

    public String getPhoneNumberThree() {
        return phoneNumberThree;
    }

    public void setPhoneNumberThree(String phoneNumberThree) {
        this.phoneNumberThree = phoneNumberThree;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getpCode() {
        return pCode;
    }

    public void setpCode(String pCode) {
        this.pCode = pCode;
    }

    @Override
    public String toString() {
        return "Laboratory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNumberOne='" + phoneNumberOne + '\'' +
                ", phoneNumberTwo='" + phoneNumberTwo + '\'' +
                ", phoneNumberThree='" + phoneNumberThree + '\'' +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                ", description='" + description + '\'' +
                ", pCode='" + pCode + '\'' +
                '}';
    }
}
