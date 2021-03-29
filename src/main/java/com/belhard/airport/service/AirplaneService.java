package com.belhard.airport.service;

import com.belhard.airport.dto.AirplaneDto;

import java.util.List;

public interface AirplaneService {


    public List<AirplaneDto> getAllAirplanes ();
    public List<AirplaneDto> getAllAirplanesWithFlights ();
    public List<AirplaneDto> getAirplanesByBrand (String brand);
    public AirplaneDto getAirplaneByID (Long id);
    public List<AirplaneDto> searchAirplanes (String string);


    public void saveEntity (AirplaneDto airplaneDto);
}
