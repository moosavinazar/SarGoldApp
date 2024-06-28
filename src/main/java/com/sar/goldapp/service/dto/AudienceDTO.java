package com.sar.goldapp.service.dto;

import com.sar.goldapp.model.Audience;

public class AudienceDTO {

    private long id;

    private String name;

    private double balanceR;

    private PersonDTO person;

    private BankDTO bank;

    private LaboratoryDTO laboratory;

    private String label;

    public AudienceDTO() {
    }

    public AudienceDTO(Audience audience) {
        this.id = audience.getId();
    }

    public AudienceDTO(AudienceDTO audience, double balanceR) {
        this.id = audience.getId();
        this.name = audience.getName();
        this.balanceR = balanceR;
        this.person = audience.getPerson();
        this.bank = audience.getBank();
        this.laboratory = audience.getLaboratory();
        setLabel(audience.getName(), balanceR);
    }

    public AudienceDTO(PersonDTO person) {
        this.person = person;
    }

    public AudienceDTO(BankDTO bank) {
        this.bank = bank;
    }

    public AudienceDTO(LaboratoryDTO laboratory) {
        this.laboratory = laboratory;
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

    public double getBalanceR() {
        return balanceR;
    }

    public void setBalanceR(double balanceR) {
        this.balanceR = balanceR;
    }

    public PersonDTO getPerson() {
        return person;
    }

    public void setPerson(PersonDTO person) {
        this.person = person;
    }

    public BankDTO getBank() {
        return bank;
    }

    public void setBank(BankDTO bank) {
        this.bank = bank;
    }

    public LaboratoryDTO getLaboratory() {
        return laboratory;
    }

    public void setLaboratory(LaboratoryDTO laboratory) {
        this.laboratory = laboratory;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String name, double balanceR) {

        this.label = name + " : " + String.format("%,.0f",balanceR);
    }

    @Override
    public String toString() {
        return "AudienceDTO{" +
                "id=" + id +
                ", name='" + name + "'" +
                ", balanceR=" + balanceR +
                ", label=" + label +
                ", personId=" + (person != null ? person.getId() : null) +
                ", bankId=" + (bank != null ? bank.getId() : null) +
                ", laboratoryId=" + (laboratory != null ? laboratory.getId() : null) +
                '}';
    }
}
