package com.belhard.airport.models;

import javax.persistence.*;

@Entity
public class Pilots {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column (name = "first_name")
    private char firstName;
    @Column (name = "last_name")
    private char lastName;
    @Column (name = "pilot_rank")
    private char pilotRank;
    @Column (name = "pilot_code")
    private char pilotCode;

    public Pilots() {}

    public Pilots(char firstName, char lastName, char pilotRank, char pilotCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pilotRank = pilotRank;
        this.pilotCode = pilotCode;
    }

    public long getId() {
        return id;
    }

    public char getFirstName() {
        return firstName;
    }

    public void setFirstName(char firstName) {
        this.firstName = firstName;
    }

    public char getLastName() {
        return lastName;
    }

    public void setLastName(char lastName) {
        this.lastName = lastName;
    }

    public char getPilotRank() {
        return pilotRank;
    }

    public void setPilotRank(char pilotRank) {
        this.pilotRank = pilotRank;
    }

    public char getPilotCode() {
        return pilotCode;
    }

    public void setPilotCode(char pilotCode) {
        this.pilotCode = pilotCode;
    }
}
