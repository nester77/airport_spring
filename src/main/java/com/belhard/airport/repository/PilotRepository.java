package com.belhard.airport.repository;

import com.belhard.airport.entity.Airplane;
import com.belhard.airport.entity.Pilot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface PilotRepository extends JpaRepository<Pilot, Long> {

    @Query("SELECT p FROM Pilot p")
    public List<Pilot> getAllPilot();

    @Query("SELECT p FROM Pilot p LEFT JOIN FETCH p.flights WHERE p.id = :id")
    public Pilot getPilotById(Long id);


    @Query ("SELECT DISTINCT p FROM Pilot p LEFT JOIN FETCH p.flights")
    public List<Pilot> getAllPilotWithJoin();
}
