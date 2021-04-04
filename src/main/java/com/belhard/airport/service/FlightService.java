package com.belhard.airport.service;

import com.belhard.airport.dto.AirplaneDto;
import com.belhard.airport.dto.FlightDto;

import java.util.List;

public interface FlightService {


    public List<FlightDto> getAllFlights ();
    public List<FlightDto> getAllFlightsWithAirplaneAndPilot();
    public FlightDto getFlightByIDWithAirplaneAndPilot (Long id);
    public void deleteById (Long id);
    public List<FlightDto> searchFlights (String string);
    public void saveEntity (FlightDto flightDto);
}