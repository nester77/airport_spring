package com.belhard.airport.repository;

import com.belhard.airport.entity.Airplane;
import org.springframework.data.repository.CrudRepository;

public interface AirplaneRepository extends CrudRepository <Airplane, Long> {
}
