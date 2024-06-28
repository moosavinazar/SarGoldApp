package com.sar.goldapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sar.goldapp.model.authentication.User;
import com.sar.goldapp.model.enumeration.GenderEnum;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_generator")
    @SequenceGenerator(name = "person_generator", sequenceName = "person_seq", allocationSize = 1, initialValue = 5)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private GenderEnum genderEnum;

    @Column(name = "email")
    private String email;

    @Column(name = "cell_phone", unique = true)
    private String cellPhone;

    @Column(name = "phone_number_one")
    private String phoneNumberOne;

    @Column(name = "phone_number_two")
    private String phoneNumberTwo;

    @Column(name = "phone_number_three")
    private String phoneNumberThree;

    @Column(name = "address")
    private String address;

    @Column(name = "description")
    private String description;

    @Column(name = "p_code")
    private String pCode;

    @Column(name = "vip")
    private boolean vip;

    @OneToOne(mappedBy = "person", cascade = CascadeType.PERSIST)
    @JsonIgnore
    private Audience audience;

    @OneToOne(mappedBy = "person")
    private User user;

    @ManyToOne(optional = false)
    private City city;

    public Person() {
    }

    public Person(long id, String name, LocalDate dateOfBirth, GenderEnum genderEnum, String email,
                  String cellPhone, String address, String description, String pCode, boolean vip) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.genderEnum = genderEnum;
        this.email = email;
        this.cellPhone = cellPhone;
        this.address = address;
        this.description = description;
        this.pCode = pCode;
        this.vip = vip;
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

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public GenderEnum getGender() {
        return genderEnum;
    }

    public void setGender(GenderEnum genderEnum) {
        this.genderEnum = genderEnum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
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

    public boolean isVip() {
        return vip;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }

    public Audience getAudience() {
        return audience;
    }

    public void setAudience(Audience audience) {
        this.audience = audience;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", genderEnum=" + genderEnum +
                ", email='" + email + '\'' +
                ", cellPhone='" + cellPhone + '\'' +
                ", phoneNumberOne='" + phoneNumberOne + '\'' +
                ", phoneNumberTwo='" + phoneNumberTwo + '\'' +
                ", phoneNumberThree='" + phoneNumberThree + '\'' +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                ", description='" + description + '\'' +
                ", pCode='" + pCode + '\'' +
                ", vip=" + vip +
                '}';
    }
}
