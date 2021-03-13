package com.belhard.airport.repo;

import com.belhard.airport.models.Pilots;
import org.springframework.data.repository.CrudRepository;

public interface PilotsRepository extends CrudRepository<Pilots, Long> {
}
