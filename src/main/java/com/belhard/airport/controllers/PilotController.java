package com.belhard.airport.controllers;

import com.belhard.airport.dto.AirplaneDto;
import com.belhard.airport.dto.PilotDto;
import com.belhard.airport.service.PilotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
public class PilotController {


    private PilotService pilotService;

    @Autowired
    public PilotController(PilotService pilotService) {
        this.pilotService = pilotService;
    }

    @RequestMapping("/pilots")
    public String getAllPilots(ModelMap modelMap){
      List <PilotDto> pilots = pilotService.getAllPilots();
      modelMap.addAttribute("pilots", pilots);
      return "pilots";
    }

    @GetMapping("/pilot/{id}")
    public String pilotDetails (@PathVariable(value = "id") long id, ModelMap modelMap) {
        PilotDto pilot = pilotService.getPilotById(id);
        modelMap.addAttribute("pilot", pilot);
        return "pilot-details";
    }


}
