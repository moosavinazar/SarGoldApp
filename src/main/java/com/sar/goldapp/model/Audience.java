package com.sar.goldapp.model;

import jakarta.persistence.*;

import java.util.HashSet;

@Entity
@Table(name = "audience")
public class Audience {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "audience_generator")
    @SequenceGenerator(name = "audience_generator", sequenceName = "audience_seq", allocationSize = 1, initialValue = 5)
    private long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(unique = true)
    private Person person;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(unique = true)
    private Bank bank;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(unique = true)
    private Laboratory laboratory;

    public Audience() {
    }

    public Audience(long id) {
        this.id = id;
    }

    public Audience(Person person) {
        this.person = person;
    }

    public Audience(Bank bank) {
        this.bank = bank;
    }

    public Audience(Laboratory laboratory) {
        this.laboratory = laboratory;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public Laboratory getLaboratory() {
        return laboratory;
    }

    public void setLaboratory(Laboratory laboratory) {
        this.laboratory = laboratory;
    }

    @Override
    public String toString() {
        return "Audience{" +
                "id=" + id +
                ", person=" + person +
                ", bank=" + bank +
                ", laboratory=" + laboratory +
                '}';
    }
}
