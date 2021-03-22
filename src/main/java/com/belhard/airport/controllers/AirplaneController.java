package com.belhard.airport.controllers;

import com.belhard.airport.dto.AirplaneDto;
import com.belhard.airport.dto.PilotDto;
import com.belhard.airport.entity.Airplane;
import com.belhard.airport.service.AirplaneService;
import com.belhard.airport.service.PilotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class AirplaneController {

    private AirplaneService airplaneService;

    @Autowired
    public AirplaneController(AirplaneService airplaneService) {
        this.airplaneService = airplaneService;
    }

    @RequestMapping("/airplanes")
    public String getAllAirplanes(ModelMap modelMap){
        List<AirplaneDto> airplanes = airplaneService.getAllAirplanes();
        modelMap.addAttribute("airplanes", airplanes);
        return "airplanes";
    }

    @GetMapping("/airplane/{id}")
    public String pilotDetails (@PathVariable(value = "id") long id, ModelMap modelMap) {
//        if (!airplaneRepository.existsById(id)){
//            return "redirect:/blog";
//        }

       AirplaneDto airplane = airplaneService.getAirplaneByID(id);
       modelMap.addAttribute("airplane",airplane);
       return "airplane-details";
    }


}
