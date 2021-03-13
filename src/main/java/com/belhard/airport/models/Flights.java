package com.belhard.airport.models;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
public class Flights {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn (name = "airplane_id", referencedColumnName = "id")
    private long airplaneId;

    @ManyToOne
    @JoinColumn (name = "pilot_id", referencedColumnName = "id")
    private long pilotId;

    @Column (name = "flight_date")
    @Temporal(TemporalType.DATE)
    private Date flightDate;

    @Column (name = "flight_date")
    @Temporal(TemporalType.TIME)
    private Time flightTime;

    @Column(name = "flight_number")
    private char flightNumber;

    public Flights() {    }

    public Flights(long airplaneId, long pilotId, Date flightDate, Time flightTime, char flightNumber) {
        this.airplaneId = airplaneId;
        this.pilotId = pilotId;
        this.flightDate = flightDate;
        this.flightTime = flightTime;
        this.flightNumber = flightNumber;
    }

    public long getId() {
        return id;
    }

    public long getAirplaneId() {
        return airplaneId;
    }

    public void setAirplaneId(long airplaneId) {
        this.airplaneId = airplaneId;
    }

    public long getPilotId() {
        return pilotId;
    }

    public void setPilotId(long pilotId) {
        this.pilotId = pilotId;
    }

    public Date getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(Date flightDate) {
        this.flightDate = flightDate;
    }

    public Time getFlightTime() {
        return flightTime;
    }

    public void setFlightTime(Time flightTime) {
        this.flightTime = flightTime;
    }

    public char getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(char flightNumber) {
        this.flightNumber = flightNumber;
    }
}
