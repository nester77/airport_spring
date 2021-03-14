package com.belhard.airport.repo;

import com.belhard.airport.models.Pilot;
import org.springframework.data.repository.CrudRepository;

public interface PilotRepository extends CrudRepository<Pilot, Long> {
}
