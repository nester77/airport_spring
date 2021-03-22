package com.belhard.airport.dto;

import java.util.List;

public class AirplaneDto {

    private long id;
    private String brand;
    private String model;
    private int passengerCapacity;
    private String boardNumber;
    private List<FlightDto> flights;

    public AirplaneDto() {
    }

    public AirplaneDto(String brand) {
        this.brand = brand;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    public String getBoardNumber() {
        return boardNumber;
    }

    public void setBoardNumber(String boardNumber) {
        this.boardNumber = boardNumber;
    }

    public List<FlightDto> getFlights() {
        return flights;
    }

    public void setFlights(List<FlightDto> flights) {
        this.flights = flights;
    }

    @Override
    public String toString() {
        return "AirplaneDto{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", passengerCapacity=" + passengerCapacity +
                ", boardNumber='" + boardNumber + '\'' +
                        ", flights=" + flights +
                '}';

    }
}
