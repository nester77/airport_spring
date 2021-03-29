package com.belhard.airport.repository;

import com.belhard.airport.entity.Airplane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AirplaneRepository extends JpaRepository <Airplane, Long> {

    @Query("SELECT a FROM Airplane a")
    public List<Airplane> getAllAirplane();

    @Query("SELECT DISTINCT a FROM Airplane a WHERE a.brand = :brand")
    public List<Airplane> getAirplaneByBrand(String brand);

    @Query ("SELECT DISTINCT a FROM Airplane a LEFT JOIN FETCH a.flights")
    public List<Airplane> getAllAirplaneWithJoin();

    @Query("SELECT a FROM Airplane a LEFT JOIN FETCH a.flights WHERE a.id = :id")
    public Airplane getAirplaneById(Long id);

    @Query("SELECT DISTINCT a FROM Airplane a WHERE a.brand LIKE CONCAT('%', :string, '%')")
    public List<Airplane> searchAirplanes(String string);




}
