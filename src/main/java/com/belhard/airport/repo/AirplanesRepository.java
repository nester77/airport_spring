package com.belhard.airport.repo;

import com.belhard.airport.models.Airplanes;
import org.springframework.data.repository.CrudRepository;

public interface AirplanesRepository extends CrudRepository <Airplanes, Long> {
}
