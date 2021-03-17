package com.belhard.airport.controllers;

import com.belhard.airport.repository.PilotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PilotController {

    @Autowired
    private PilotRepository pilotsRepository;

    public PilotController(PilotRepository pilotsRepository) {
        this.pilotsRepository = pilotsRepository;
    }
}
