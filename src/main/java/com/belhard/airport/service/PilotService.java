package com.belhard.airport.service;

import com.belhard.airport.models.Pilot;
import com.belhard.airport.repo.PilotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PilotService {

    @Autowired
    private  PilotRepository pilotRepository;

//    public Pilot findPilot(Long id) {
//        return pilotRepository.getOne();
//    }

    public List <Pilot> findAllPilots(){
        return (List<Pilot>) pilotRepository.findAll();
    }
    public Pilot savePilot (Pilot pilot){
        return pilotRepository.save(pilot);
    }

    public void deletePilot (Long id){
        pilotRepository.deleteById(id);
    }
}
