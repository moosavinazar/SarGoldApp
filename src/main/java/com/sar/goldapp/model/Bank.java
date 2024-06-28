package com.sar.goldapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "bank")
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bank_generator")
    @SequenceGenerator(name = "bank_generator", sequenceName = "bank_seq", allocationSize = 1, initialValue = 5)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "address")
    private String address;

    @Column(name = "description")
    private String description;

    @Column(name = "p_code")
    private String pCode;

    @OneToOne(mappedBy = "bank", cascade = CascadeType.ALL)
    @JsonIgnore
    private Audience audience;

    public Bank() {
    }

    public Bank(String name, String phoneNumber, String address, String description, String pCode) {
        this.name = name;
        this.phoneNumber = phoneNumber;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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

    public Audience getAudience() {
        return audience;
    }

    public void setAudience(Audience audience) {
        this.audience = audience;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", description='" + description + '\'' +
                ", pCode='" + pCode + '\'' +
                '}';
    }
}
