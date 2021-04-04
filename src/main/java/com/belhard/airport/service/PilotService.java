package com.belhard.airport.service;

import com.belhard.airport.dto.PilotDto;

import java.util.List;

public interface PilotService {


    public List<PilotDto> getAllPilots ();
    public List<PilotDto> getAllPilotsWithFlights ();
    public PilotDto getPilotById (Long id);
    public List<PilotDto> searchPilots (String string);
    public void deleteById(long id);
    public void saveEntity (PilotDto pilotDto);



}
