package com.belhard.airport;

import com.belhard.airport.dto.PilotDto;
import com.belhard.airport.entity.Pilot;
import com.belhard.airport.repository.PilotRepository;
import com.belhard.airport.service.PilotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class AirportApplication {

//    @Autowired
//    private PilotService pilotService;
//
	public static void main(String[] args) {
		SpringApplication.run(AirportApplication.class, args);
	}

//    @Override
//    public void run(String... args) throws Exception {
//        List<PilotDto> pilotList = pilotService.getAllPilotsWithFlights();
//        for (PilotDto pilot:pilotList) {
//            System.out.println(pilot);
//        }
//    System.out.println("_____________________________");
//
//        pilotList = pilotService.getAllPilots();
//        for (PilotDto pilot:pilotList) {
//            System.out.println(pilot);
//        }
//        System.out.println("_____________________________");
//        pilotList = pilotService.getAllPilots();
//        for (PilotDto pilot:pilotList) {
//            System.out.println(pilotService.getPilotsByRank("training captain"));
//        }

//        pilotService.saveEntity(new PilotDto("Kate"));
//        System.out.println("_____________________________");
//        pilotList = pilotService.getAllPilotsWithFlights();
//        for (PilotDto pilot:pilotList) {
//            System.out.println(pilot);
//        }
//    }
   }
