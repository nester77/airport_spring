package com.belhard.airport.models;




import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;


@Entity
@Table(name = "flights")
public class Flight {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long id;

    @Column (name = "flight_date")
    @Temporal(TemporalType.DATE)
    private Calendar flightDate;

    @Column (name = "flight_time")
    @Temporal(TemporalType.TIME)
    private Date flightTime;

    @Column(name = "flight_number")
    private char flightNumber;

    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn (name = "airplane_id", referencedColumnName = "id")
    private Airplane airplane;

    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn (name = "pilot_id", referencedColumnName = "id")
    private Pilot pilot;


    public Flight() {    }

    public Flight(Calendar flightDate, Date flightTime, char flightNumber, Airplane airplane, Pilot pilot) {
        this.flightDate = flightDate;
        this.flightTime = flightTime;
        this.flightNumber = flightNumber;
        this.airplane = airplane;
        this.pilot = pilot;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Calendar getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(Calendar flightDate) {
        this.flightDate = flightDate;
    }

    public Date getFlightTime() {
        return flightTime;
    }

    public void setFlightTime(Date flightTime) {
        this.flightTime = flightTime;
    }

    public char getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(char flightNumber) {
        this.flightNumber = flightNumber;
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }

    public Pilot getPilot() {
        return pilot;
    }

    public void setPilot(Pilot pilot) {
        this.pilot = pilot;
    }
}
