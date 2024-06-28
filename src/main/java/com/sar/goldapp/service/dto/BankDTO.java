package com.sar.goldapp.service.dto;

public class BankDTO {

    private long id;

    private String name;

    private String phoneNumber;

    private String address;

    private String description;

    private String pCode;

    public BankDTO() {
    }

    public BankDTO(String name, String pCode) {
        this.name = name;
        this.pCode = pCode;
    }

    public BankDTO(String name, String phoneNumber, String address, String description, String pCode) {
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

    @Override
    public String toString() {
        return "BankDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", description='" + description + '\'' +
                ", pCode='" + pCode + '\'' +
                '}';
    }
}
