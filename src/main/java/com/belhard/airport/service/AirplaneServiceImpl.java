package com.belhard.airport.service;

import com.belhard.airport.dto.FlightDto;
import com.belhard.airport.dto.AirplaneDto;
import com.belhard.airport.entity.Flight;
import com.belhard.airport.entity.Airplane;
import com.belhard.airport.repository.AirplaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class AirplaneServiceImpl implements AirplaneService{

    private AirplaneRepository airplaneRepository;

    @Autowired
    public AirplaneServiceImpl(AirplaneRepository airplaneRepository) {
        this.airplaneRepository = airplaneRepository;
    }

    @Override
    public List<AirplaneDto> getAllAirplanes() {
        return convertFromListEntityToListDto(airplaneRepository.getAllAirplane());
    }

    @Override
    public List<AirplaneDto> getAllAirplanesWithFlights() {
        return convertFromListEntityWithFlightsToListDto(airplaneRepository.getAllAirplaneWithJoin());
    }

    @Override
    public AirplaneDto getAirplaneByID (Long id) {
        return convertFromEntityWithFlightsToDto(airplaneRepository.getAirplaneById(id));
    }

    @Override
    public void deleteById(Long id) {
        airplaneRepository.deleteById(id);
    }

    @Override
    public List<AirplaneDto> searchAirplanes(String string) {
        return convertFromListEntityToListDto(airplaneRepository.searchAirplanes(string));
    }

    @Override
    @Transactional
    public void saveEntity(AirplaneDto airplaneDto) {
        Airplane airplane= convertFromDtoToEntity(airplaneDto);
        airplaneRepository.save(airplane);

    }

    private List<AirplaneDto> convertFromListEntityToListDto (List<Airplane> airplanes){
        List<AirplaneDto> airplaneDtos = new ArrayList<>();
        for (Airplane airplane: airplanes) {
            airplaneDtos.add(convertFromEntityToDto(airplane));
        }
        return airplaneDtos;

    }

    private AirplaneDto convertFromEntityToDto(Airplane airplane) {
        AirplaneDto airplaneDto= new AirplaneDto();
        airplaneDto.setId(airplane.getId());
        airplaneDto.setBrand(airplane.getBrand());
        airplaneDto.setModel(airplane.getModel());
        airplaneDto.setPassengerCapacity(airplane.getPassengerCapacity());
        airplaneDto.setBoardNumber(airplane.getBoardNumber());

        airplaneDto.setFlights( new ArrayList<>());

        return airplaneDto;
    }
    private List<AirplaneDto> convertFromListEntityWithFlightsToListDto (List<Airplane> airplanes){
        List<AirplaneDto> airplaneDtos = new ArrayList<>();
        for (Airplane airplane: airplanes) {
            airplaneDtos.add(convertFromEntityWithFlightsToDto(airplane));
        }
        return airplaneDtos;

    }

    private AirplaneDto convertFromEntityWithFlightsToDto(Airplane airplane) {
        AirplaneDto airplaneDto= new AirplaneDto();
        airplaneDto.setId(airplane.getId());
        airplaneDto.setBrand(airplane.getBrand());
        airplaneDto.setModel(airplane.getModel());
        airplaneDto.setPassengerCapacity(airplane.getPassengerCapacity());
        airplaneDto.setBoardNumber(airplane.getBoardNumber());
        List <FlightDto> flightDtos= new ArrayList<>();
        for (Flight flight: airplane.getFlights()) {
            FlightDto flightDto= new FlightDto();
            flightDto.setId(flight.getId());
            flightDto.setFlightDate(flight.getFlightDate());
            flightDto.setFlightTime(flight.getFlightTime());
            flightDto.setFlightNumber(flight.getFlightNumber());
            flightDtos.add(flightDto);
        }
        airplaneDto.setFlights(flightDtos);
        return airplaneDto;
    }

    private Airplane convertFromDtoToEntity (AirplaneDto airplaneDto){
        Airplane airplane = new Airplane();
        if (airplaneDto.getId() !=0){
            airplane.setId(airplaneDto.getId());
        }
        airplane.setBrand(airplaneDto.getBrand());
        airplane.setModel(airplaneDto.getModel());
        airplane.setPassengerCapacity(airplaneDto.getPassengerCapacity());
        airplane.setBoardNumber(airplaneDto.getBoardNumber());
        return airplane;
    }


}