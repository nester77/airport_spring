package com.belhard.airport.repository;

import com.belhard.airport.entity.Airplane;
import com.belhard.airport.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.List;

public interface FlightRepository extends JpaRepository <Flight, Long> {


    @Query("SELECT f FROM Flight f")
    public List<Flight> getAllFlight();

    @Query("SELECT f FROM Flight f LEFT JOIN FETCH f.airplane LEFT JOIN FETCH f.pilot ORDER BY f.id")
    public List<Flight> getAllFlightWithJoin();

    @Query("SELECT f FROM Flight f LEFT JOIN FETCH f.airplane LEFT JOIN FETCH f.pilot WHERE f.id = :id")
    public Flight getFlightById(Long id);

    @Query("SELECT DISTINCT f FROM Flight f WHERE f.flightDate LIKE CONCAT('%', :string, '%') OR " +
            "f.flightTime LIKE CONCAT('%', :string, '%') OR " +
            "f.flightNumber LIKE CONCAT('%', :string, '%')")
    public List<Flight> searchFlights(String string);


}
