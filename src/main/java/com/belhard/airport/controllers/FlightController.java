package com.belhard.airport.controllers;

import com.belhard.airport.dto.FlightDto;
import com.belhard.airport.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class FlightController {

    private FlightService flightService;

    @Autowired
    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @RequestMapping("/flights")
    public String getAllFlights(ModelMap modelMap){
        List <FlightDto> flights = flightService.getAllFlights();
        modelMap.addAttribute("flights", flights);
        return "flights";
    }

}
