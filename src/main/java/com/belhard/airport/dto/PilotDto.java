package com.belhard.airport.dto;

import java.util.List;

public class PilotDto {

    private long id;
    private String firstName;
    private String lastName;
    private String pilotRank;
    private String pilotCode;
    private List<FlightDto> flights;

    public PilotDto() {
    }

    public PilotDto(String firstName) {
        this.firstName = firstName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPilotRank() {
        return pilotRank;
    }

    public void setPilotRank(String pilotRank) {
        this.pilotRank = pilotRank;
    }

    public String getPilotCode() {
        return pilotCode;
    }

    public void setPilotCode(String pilotCode) {
        this.pilotCode = pilotCode;
    }

    public List<FlightDto> getFlights() {
        return flights;
    }

    public void setFlights(List<FlightDto> flights) {
        this.flights = flights;
    }

    @Override
    public String toString() {
        return "PilotDto{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", pilotRank='" + pilotRank + '\'' +
                ", pilotCode='" + pilotCode + '\'' +
                ", flights=" + flights +
                '}';
    }
}
