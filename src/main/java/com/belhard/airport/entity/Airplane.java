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
@Table(name = "airplanes")
  public class Airplane {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;
private String brand;
private String model;
@Column(name = "passenger_capacity")
private int passengerCapacity;
@Column (name = "board_number")
private String boardNumber;

@OneToMany (mappedBy = "airplane")
private List<Flight> flights;

public Airplane() { }

        public Airplane(String brand, String model, int passengerCapacity, String boardNumber) {
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