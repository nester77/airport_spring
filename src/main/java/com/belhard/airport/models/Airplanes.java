package com.belhard.airport.models;

import javax.persistence.*;

@Entity
public class Airplanes {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long id;
    private char brand;
    private char model;
    @Column (name = "passenger_capacity")
    private char passengerCapacity;
    @Column (name = "board_number")
    private char boardNumber;

    public Airplanes() { }

    public Airplanes(char brand, char model, char passengerCapacity, char boardNumber) {
        this.brand = brand;
        this.model = model;
        this.passengerCapacity = passengerCapacity;
        this.boardNumber = boardNumber;
    }

    public long getId() {
        return id;
    }

    public char getBrand() {
        return brand;
    }

    public void setBrand(char brand) {
        this.brand = brand;
    }

    public char getModel() {
        return model;
    }

    public void setModel(char model) {
        this.model = model;
    }

    public char getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(char passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    public char getBoardNumber() {
        return boardNumber;
    }

    public void setBoardNumber(char boardNumber) {
        this.boardNumber = boardNumber;
    }
}
