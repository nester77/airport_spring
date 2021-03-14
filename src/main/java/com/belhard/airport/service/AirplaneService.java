package com.belhard.airport.service;

import com.belhard.airport.models.Airplane;
import com.belhard.airport.repo.AirplaneRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AirplaneService {

    @Autowired
    private AirplaneRepository airplaneRepository;

//    public Airplane airplanePilot(Long id) {
//        return airplaneRepository.getOne();
//    }

    public List<Airplane> findAllAirplanes(){
        return (List<Airplane>) airplaneRepository.findAll();
    }
    public Airplane saveAirplane (Airplane pilot){
        return airplaneRepository.save(pilot);
    }

    public void deleteAirplane (Long id){
        airplaneRepository.deleteById(id);
    }
}
