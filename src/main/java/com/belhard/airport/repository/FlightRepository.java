package com.belhard.airport.repository;

import com.belhard.airport.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FlightRepository extends JpaRepository <Flight, Long> {


    @Query("SELECT f FROM Flight f")
    public List<Flight> getAllFlight();

//    @Query ("SELECT DISTINCT f FROM Flight f LEFT JOIN FETCH f.airplanes LEFT JOIN FETCH f.pilots")
//    public List<Flight> getAllFlightWithJoin();

//    @Query("SELECT f FROM Flight f LEFT JOIN FETCH f.airplanes LEFT JOIN FETCH f.pilots WHERE f.id = :id")
//    public Flight getFlightById(Long id);


}
