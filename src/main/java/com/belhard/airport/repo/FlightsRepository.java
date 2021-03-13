package com.belhard.airport.repo;

import com.belhard.airport.models.Flights;
import org.springframework.data.repository.CrudRepository;

public interface FlightsRepository extends CrudRepository<Flights, Long> {
}
