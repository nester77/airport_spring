package com.belhard.airport.entity;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Table(name = "pilots")
public class Pilot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column (name = "first_name")
    private String firstName;
    @Column (name = "last_name")
    private String lastName;
    @Column (name = "pilot_rank")
    private String pilotRank;
    @Column (name = "pilot_code")
    private String pilotCode;

    @OneToMany (mappedBy = "pilot")
    private List<Flight> flights;

    public Pilot() {}


    public Pilot(String firstName, String lastName, String pilotRank, String pilotCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pilotRank = pilotRank;
        this.pilotCode = pilotCode;
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

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        if (flights !=null) {
            flights.forEach(p->{
                p.setPilot(this);
            });
        }
        this.flights = flights;
    }

    @Override
    public String toString() {
        return "Pilot{" +
                "id=" + id +
                ", firstName=" + firstName +
                ", lastName=" + lastName +
                ", pilotRank=" + pilotRank +
                ", pilotCode=" + pilotCode +
//                ", flights=" + flights +
                '}';
    }
}
