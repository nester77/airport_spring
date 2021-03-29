package com.belhard.airport;

import com.belhard.airport.dto.AirplaneDto;
import com.belhard.airport.dto.FlightDto;
import com.belhard.airport.dto.PilotDto;
import com.belhard.airport.entity.Flight;
import com.belhard.airport.entity.Pilot;
import com.belhard.airport.repository.PilotRepository;
import com.belhard.airport.service.AirplaneService;
import com.belhard.airport.service.FlightService;
import com.belhard.airport.service.PilotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class AirportApplication
        implements CommandLineRunner
{

    @Autowired
    private PilotService pilotService;
    @Autowired
    private AirplaneService airplaneService;
	@Autowired
	private FlightService flightService;

	public static void main(String[] args) {
		SpringApplication.run(AirportApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {



//		List<FlightDto> flightList = flightService.getAllFlights();
//		for (FlightDto flight:flightList) {
//			System.out.println(flight);
//		}
//
//        System.out.println("_____________________________");
//
//		flightList = flightService.getAllFlightsWithAirplaneAndPilot();
//		for (FlightDto flight:flightList) {
//			System.out.println(flight);
//		}
//
//        System.out.println("_____________________________");
//
//		System.out.println(flightService.getFlightByIDWithAirplaneAndPilot((long) 13));

//
//

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
//
//
//
//
//
//
//        List<AirplaneDto> airplaneList = airplaneService.getAllAirplanesWithFlights();
//        for (AirplaneDto airplane:airplaneList) {
//            System.out.println(airplane);
//        }
//        System.out.println("_____________________________");
//
        List<AirplaneDto> airplaneList = airplaneService.searchAirplanes("z");
        for (AirplaneDto airplane:airplaneList) {
            System.out.println(airplane);
        }
//
//        System.out.println(airplaneService.getAirplaneByID((long) 3));

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
    }
   }
