package com.belhard.airport;

import com.belhard.airport.entity.Pilot;
import com.belhard.airport.repository.PilotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class AirportApplication implements CommandLineRunner {

    @Autowired
    PilotRepository pilotRepository;

	public static void main(String[] args) {
		SpringApplication.run(AirportApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        List<Pilot> pilotList = pilotRepository.getAllPilot();
        for (Pilot pilot:pilotList) {
            System.out.println(pilot);
        }
    }
}
