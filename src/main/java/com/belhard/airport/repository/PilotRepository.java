package com.belhard.airport.repository;

import com.belhard.airport.entity.Pilot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface PilotRepository extends JpaRepository<Pilot, Long> {

    @Query("SELECT p FROM Pilot p")
    public List<Pilot> getAllPilot();

}
