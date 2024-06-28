package com.sar.goldapp.service.dto;

public class LaboratoryDTO {

    private long id;

    private String name;

    private String phoneNumberOne;

    private String phoneNumberTwo;

    private String phoneNumberThree;

    private String city;

    private String address;

    private String description;

    private String pCode;

    public LaboratoryDTO() {
    }

    public LaboratoryDTO(String name, String pCode, String phoneNumberOne) {
        this.name = name;
        this.pCode = pCode;
        this.phoneNumberOne = phoneNumberOne;
    }

    public LaboratoryDTO(String name, String phoneNumberOne, String phoneNumberTwo, String phoneNumberThree,
                         String city, String address, String description, String pCode) {
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
        return "LaboratoryDTO{" +
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
