package com.belhard.airport.service;

import com.belhard.airport.dto.AirplaneDto;
import com.belhard.airport.dto.PilotDto;
import com.belhard.airport.entity.Pilot;

import java.util.List;

public interface PilotService {


    public List<PilotDto> getAllPilots ();
    public List<PilotDto> getAllPilotsWithFlights ();
    public PilotDto getPilotById (Long id);

    public void saveEntity (PilotDto pilotDto);
}
