package com.belhard.airport.dto;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

public class FlightDto {
    private long id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date flightDate;
    @DateTimeFormat(pattern = "hh:mm")
    private Date flightTime;
    private String flightNumber;
    private AirplaneDto airplane;
    private PilotDto pilot;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(Date flightDate) {
        this.flightDate = flightDate;
    }

    public Date getFlightTime() {
        return flightTime;
    }

    public void setFlightTime(Date flightTime) {
        this.flightTime = flightTime;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public AirplaneDto getAirplane() {
        return airplane;
    }

    public void setAirplane(AirplaneDto airplane) {
        this.airplane = airplane;
    }

    public PilotDto getPilot() {
        return pilot;
    }

    public void setPilot(PilotDto pilot) {
        this.pilot = pilot;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    @Override
    public String toString() {
        return "FlightDto{" +
                "id=" + id +
                ", flightDate=" + flightDate +
                ", flightTime=" + flightTime +
                ", flightNumber='" + flightNumber + '\'' +
                ", airplane=" + airplane +
                ", pilot=" + pilot +
                '}';
    }
}
