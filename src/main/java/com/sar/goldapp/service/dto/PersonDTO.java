package com.sar.goldapp.service.dto;

import com.sar.goldapp.model.enumeration.GenderEnum;

import java.time.LocalDate;

public class PersonDTO {

    private long id;

    private String name;

    private LocalDate dateOfBirth;

    private GenderEnum genderEnum;

    private String email;

    private String cellPhone;

    private String phoneNumberOne;

    private String phoneNumberTwo;

    private String phoneNumberThree;

    private String address;

    private String description;

    private String pCode;

    private boolean vip;

    private long cityId;

    public PersonDTO() {
    }

    public PersonDTO(String name, String pCode, long cityId, boolean vip) {
        this.name = name;
        this.pCode = pCode;
        this.vip = vip;
        this.cityId = cityId;
    }

    public PersonDTO(long id, String name, LocalDate dateOfBirth, GenderEnum genderEnum, String email, String cellPhone,
                     String address, long cityId, String description, String pCode, boolean vip) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.genderEnum = genderEnum;
        this.email = email;
        this.cellPhone = cellPhone;
        this.address = address;
        this.cityId = cityId;
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

    public long getCityId() {
        return cityId;
    }

    public void setCityId(long cityId) {
        this.cityId = cityId;
    }

    @Override
    public String toString() {
        return "PersonDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", genderEnum=" + genderEnum +
                ", email='" + email + '\'' +
                ", cellPhone='" + cellPhone + '\'' +
                ", phoneNumberOne='" + phoneNumberOne + '\'' +
                ", phoneNumberTwo='" + phoneNumberTwo + '\'' +
                ", phoneNumberThree='" + phoneNumberThree + '\'' +
                ", address='" + address + '\'' +
                ", cityId=" + cityId +
                ", description='" + description + '\'' +
                ", pCode='" + pCode + '\'' +
                ", vip=" + vip +
                '}';
    }

}
