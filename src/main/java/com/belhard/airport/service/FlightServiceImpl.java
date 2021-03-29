package com.belhard.airport.service;

import com.belhard.airport.dto.FlightDto;
import com.belhard.airport.dto.AirplaneDto;
import com.belhard.airport.dto.PilotDto;
import com.belhard.airport.entity.Airplane;
import com.belhard.airport.entity.Flight;
import com.belhard.airport.entity.Pilot;
import com.belhard.airport.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class FlightServiceImpl implements FlightService{

    private FlightRepository flightRepository;

    @Autowired
    public FlightServiceImpl(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @Override
    public List<FlightDto> getAllFlights() {
        return convertFromListEntityToListDto(flightRepository.getAllFlight());
    }

    @Override
    public List<FlightDto> getAllFlightsWithAirplaneAndPilot() {
        return convertFromListEntityWithAirplaneAndPilotToListDto(flightRepository.getAllFlightWithJoin());
    }

    @Override
    public FlightDto getFlightByIDWithAirplaneAndPilot (Long id) {
        return convertFromEntityWithAirplaneAndPilotToDto(flightRepository.getFlightById(id));
    }

    @Override
    public void deleteById(Long id) {
        flightRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void saveEntity(FlightDto flightDto) {
        Flight flight= convertFromDtoToEntity(flightDto);
        flightRepository.save(flight);

    }

    private List<FlightDto> convertFromListEntityToListDto (List<Flight> flights){
        List<FlightDto> flightDtos = new ArrayList<>();
        for (Flight flight: flights) {
            flightDtos.add(convertFromEntityToDto(flight));
        }
        return flightDtos;

    }

    private FlightDto convertFromEntityToDto(Flight flight) {
        FlightDto flightDto= new FlightDto();
        flightDto.setId(flight.getId());
        flightDto.setFlightDate(flight.getFlightDate());
        flightDto.setFlightTime(flight.getFlightTime());
        flightDto.setFlightNumber(flight.getFlightNumber());


        return flightDto;
    }

    private List<FlightDto> convertFromListEntityWithAirplaneAndPilotToListDto (List<Flight> flights){
        List<FlightDto> flightDtos = new ArrayList<>();
        for (Flight flight: flights) {
            flightDtos.add(convertFromEntityWithAirplaneAndPilotToDto(flight));
        }
        return flightDtos;
    }

    private FlightDto convertFromEntityWithAirplaneAndPilotToDto(Flight flight) {
        FlightDto flightDto= new FlightDto();
        flightDto.setId(flight.getId());
        flightDto.setFlightDate(flight.getFlightDate());
        flightDto.setFlightTime(flight.getFlightTime());
        flightDto.setFlightNumber(flight.getFlightNumber());


        AirplaneDto airplaneDto= new AirplaneDto();
        airplaneDto.setId(flight.getAirplane().getId());
        airplaneDto.setBrand(flight.getAirplane().getBrand());
        airplaneDto.setModel(flight.getAirplane().getModel());
        airplaneDto.setPassengerCapacity(flight.getAirplane().getPassengerCapacity());
        airplaneDto.setBoardNumber(flight.getAirplane().getBoardNumber());

        PilotDto pilotDto= new PilotDto();
        pilotDto.setId(flight.getPilot().getId());
        pilotDto.setFirstName(flight.getPilot().getFirstName());
        pilotDto.setLastName(flight.getPilot().getLastName());
        pilotDto.setPilotRank(flight.getPilot().getPilotRank());
        pilotDto.setPilotCode(flight.getPilot().getPilotCode());

        flightDto.setAirplane(airplaneDto);
        flightDto.setPilot(pilotDto);

        return flightDto;
    }

    private Flight convertFromDtoToEntity (FlightDto flightDto){
        Flight flight = new Flight();
        if (flightDto.getId() !=0){
            flight.setId(flightDto.getId());
        }
        flight.setFlightDate(flightDto.getFlightDate());
        flight.setFlightTime(flightDto.getFlightTime());
        flight.setFlightNumber(flightDto.getFlightNumber());

        Airplane airplane= new Airplane();
        if (flightDto.getAirplane().getId() !=0){
            airplane.setId(flightDto.getAirplane().getId());
        }
        airplane.setBrand(flightDto.getAirplane().getBrand());
        airplane.setModel(flightDto.getAirplane().getModel());
        airplane.setPassengerCapacity(flightDto.getAirplane().getPassengerCapacity());
        airplane.setBoardNumber(flightDto.getAirplane().getBoardNumber());

        Pilot pilot= new Pilot();
        if (flightDto.getPilot().getId() !=0){
            pilot.setId(flightDto.getPilot().getId());
        }
        pilot.setFirstName(flightDto.getPilot().getFirstName());
        pilot.setLastName(flightDto.getPilot().getLastName());
        pilot.setPilotRank(flightDto.getPilot().getPilotRank());
        pilot.setPilotCode(flightDto.getPilot().getPilotCode());

        flight.setAirplane(airplane);
        flight.setPilot(pilot);

        return flight;
    }


}
