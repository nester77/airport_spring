package com.belhard.airport.models;




import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "flights")
public class Flight {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long id;

    @Column (name = "flight_date")
    @Temporal(TemporalType.DATE)
    private Date flightDate;

//    @Column (name = "flight_date")
//    @Temporal(TemporalType.TIME)
//    private Time flightTime;

    @Column(name = "flight_number")
    private char flightNumber;

    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn (name = "airplane_id", referencedColumnName = "id")
    private Airplane airplane;

    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn (name = "pilot_id", referencedColumnName = "id")
    private Pilot pilot;


    public Flight() {    }

//    public Flight(Date flightDate, Time flightTime, char flightNumber) {
//        this.flightDate = flightDate;
//        this.flightTime = flightTime;
//        this.flightNumber = flightNumber;
//    }

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

//    public Time getFlightTime() {
//        return flightTime;
//    }
//
//    public void setFlightTime(Time flightTime) {
//        this.flightTime = flightTime;
//    }

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
