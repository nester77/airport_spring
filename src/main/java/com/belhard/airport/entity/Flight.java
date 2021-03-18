package com.belhard.airport.entity;




import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


@Entity
@Table(name = "flights")
public class Flight {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;

//    @ManyToOne (fetch = FetchType.LAZY)
//    @JoinColumn (name = "airplane_id", nullable = false)
//    private Airplane airplane;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "pilot_id", nullable = false)
    private Pilot pilot;



    @Column (name = "flight_date")
    @Temporal(TemporalType.DATE)
    private Date flightDate;

    @Column (name = "flight_time")
    @Temporal(TemporalType.TIME)
    private Date flightTime;

    @Column(name = "flight_number")
    private String flightNumber;



//    public Flight() {    }
//
//    public Flight(Calendar flightDate, Date flightTime, String flightNumber, Airplane airplane, Pilot pilot) {
//        this.flightDate = flightDate;
//        this.flightTime = flightTime;
//        this.flightNumber = flightNumber;
//        this.airplane = airplane;
//        this.pilot = pilot;
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

    public Date getFlightTime() {
        return flightTime;
    }

    public void setFlightTime(Date flightTime) {
        this.flightTime = flightTime;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

//    public Airplane getAirplane() {
//        return airplane;
//    }
//
//    public void setAirplane(Airplane airplane) {
//        this.airplane = airplane;
//    }

    public Pilot getPilot() {
        return pilot;
    }

    public void setPilot(Pilot pilot) {
        this.pilot = pilot;
    }


    public String converterDate (Date flightDate){
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    return formatter.format(flightDate);
}
    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", flightDate=" + converterDate(flightDate)  +
                ", flightTime=" + flightTime +
                ", flightNumber='" + flightNumber + '\'' +
//                ", airplane=" + airplane +
//                ", pilot=" + pilot +
                '}';
    }
}
