package com.belhard.airport.models;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "airplanes")
  public class Airplane {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private long id;
private char brand;
private char model;
@Column(name = "passenger_capacity")
private char passengerCapacity;
@Column (name = "board_number")
private char boardNumber;

@OneToMany (mappedBy = "airplane", cascade = CascadeType.ALL)
private List<Flight> flights;

public Airplane() { }

public Airplane( char brand,  char model, char passengerCapacity,  char boardNumber) {
        this.brand = brand;
        this.model = model;
        this.passengerCapacity = passengerCapacity;
        this.boardNumber = boardNumber;
        }

        public long getId() {
                return id;
        }

        public void setId(long id) {
                this.id = id;
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

        public List<Flight> getFlights() {
                return flights;
        }

        public void setFlights(List<Flight> flights) {
                if (flights !=null) {
                        flights.forEach(p->{
                                p.setAirplane(this);
                        });
                }
                this.flights = flights;
        }
}