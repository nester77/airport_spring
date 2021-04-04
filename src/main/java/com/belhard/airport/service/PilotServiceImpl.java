package com.belhard.airport.service;

import com.belhard.airport.dto.FlightDto;
import com.belhard.airport.dto.PilotDto;
import com.belhard.airport.entity.Flight;
import com.belhard.airport.entity.Pilot;
import com.belhard.airport.repository.PilotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class PilotServiceImpl implements PilotService{

    private PilotRepository pilotRepository;

    @Autowired
    public PilotServiceImpl(PilotRepository pilotRepository) {
        this.pilotRepository = pilotRepository;
    }

    @Override
    public List<PilotDto> getAllPilots() {
        return convertFromListEntityToListDto(pilotRepository.getAllPilot());
    }

    @Override
    public List<PilotDto> getAllPilotsWithFlights() {
        return convertFromListEntityWithFlightsToListDto(pilotRepository.getAllPilotWithJoin());
    }

    @Override
    public PilotDto getPilotById(Long id) {
        return convertFromEntityWithFlightsToDto(pilotRepository.getPilotById(id));
    }

    @Override
    public List<PilotDto> searchPilots(String string) {
        return convertFromListEntityToListDto(pilotRepository.searchPilots(string));
    }

    @Override
    public void deleteById(long id) {
        pilotRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void saveEntity(PilotDto pilotDto) {
        Pilot pilot= convertFromDtoToEntity(pilotDto);
        pilotRepository.save(pilot);

    }

    private List<PilotDto> convertFromListEntityToListDto (List<Pilot> pilots){
        List<PilotDto> pilotDtos = new ArrayList<>();
        for (Pilot pilot: pilots) {
            pilotDtos.add(convertFromEntityToDto(pilot));
        }
        return pilotDtos;

    }

    private PilotDto convertFromEntityToDto(Pilot pilot) {
        PilotDto pilotDto= new PilotDto();
        pilotDto.setId(pilot.getId());
        pilotDto.setFirstName(pilot.getFirstName());
        pilotDto.setLastName(pilot.getLastName());
        pilotDto.setPilotRank(pilot.getPilotRank());
        pilotDto.setPilotCode(pilot.getPilotCode());

        pilotDto.setFlights( new ArrayList<>());

        return pilotDto;
    }
    private List<PilotDto> convertFromListEntityWithFlightsToListDto (List<Pilot> pilots){
        List<PilotDto> pilotDtos = new ArrayList<>();
        for (Pilot pilot: pilots) {
            pilotDtos.add(convertFromEntityWithFlightsToDto(pilot));
        }
        return pilotDtos;

    }

    private PilotDto convertFromEntityWithFlightsToDto(Pilot pilot) {
        PilotDto pilotDto= new PilotDto();
        pilotDto.setId(pilot.getId());
        pilotDto.setFirstName(pilot.getFirstName());
        pilotDto.setLastName(pilot.getLastName());
        pilotDto.setPilotRank(pilot.getPilotRank());
        pilotDto.setPilotCode(pilot.getPilotCode());
        List <FlightDto> flightDtos= new ArrayList<>();
        for (Flight flight: pilot.getFlights()) {
            FlightDto flightDto= new FlightDto();
            flightDto.setId(flight.getId());
            flightDto.setFlightDate(flight.getFlightDate());
            flightDto.setFlightTime(flight.getFlightTime());
            flightDto.setFlightNumber(flight.getFlightNumber());
            flightDtos.add(flightDto);
        }
        pilotDto.setFlights(flightDtos);
        return pilotDto;
    }

    private Pilot convertFromDtoToEntity (PilotDto pilotDto){
        Pilot pilot = new Pilot();
        if (pilotDto.getId() !=0){
            pilot.setId(pilotDto.getId());
        }
        pilot.setFirstName(pilotDto.getFirstName());
        pilot.setLastName(pilotDto.getLastName());
        pilot.setPilotRank(pilotDto.getPilotRank());
        pilot.setPilotCode(pilotDto.getPilotCode());
        return pilot;
    }


}
