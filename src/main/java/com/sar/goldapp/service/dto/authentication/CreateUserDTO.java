package com.sar.goldapp.service.dto.authentication;

import com.sar.goldapp.model.enumeration.GenderEnum;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class CreateUserDTO {

    private Set<Long> groupIds = new HashSet<>();
    private String name;
    private LocalDate dateOfBirth;

    private GenderEnum gender;

    private String email;

    private String cellPhone;

    private String phoneNumberOne;
    private String phoneNumberTwo;
    private String phoneNumberThree;

    private String address;

    private long cityId;

    private String description;

    private String username;

    private String password;

    private boolean vip;

    public Set<Long> getGroupIds() {
        return groupIds;
    }

    public void setGroupIds(Set<Long> groupIds) {
        this.groupIds = groupIds;
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
        return gender;
    }

    public void setGender(GenderEnum gender) {
        this.gender = gender;
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

    public long getCityId() {
        return cityId;
    }

    public void setCityId(long cityId) {
        this.cityId = cityId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isVip() {
        return vip;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }

    @Override
    public String toString() {
        return "CreateUserDTO{" +
                ", groupIds=" + groupIds +
                ", name=" + name +
                ", dateOfBirth=" + dateOfBirth +
                ", gender=" + gender +
                ", email='" + email + '\'' +
                ", cellPhone='" + cellPhone + '\'' +
                ", phoneNumberOne='" + phoneNumberOne + '\'' +
                ", phoneNumberTwo='" + phoneNumberTwo + '\'' +
                ", phoneNumberThree='" + phoneNumberThree + '\'' +
                ", address='" + address + '\'' +
                ", cityId=" + cityId +
                ", description='" + description + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", vip=" + vip +
                '}';
    }
}
