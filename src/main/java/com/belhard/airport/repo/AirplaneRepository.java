package com.belhard.airport.repo;

import com.belhard.airport.models.Airplane;
import org.springframework.data.repository.CrudRepository;

public interface AirplaneRepository extends CrudRepository <Airplane, Long> {
}
