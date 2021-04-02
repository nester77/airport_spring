package com.belhard.airport.controllers;

import com.belhard.airport.dto.AirplaneDto;
import com.belhard.airport.dto.FlightDto;
import com.belhard.airport.dto.PilotDto;
import com.belhard.airport.service.AirplaneService;
import com.belhard.airport.service.FlightService;
import com.belhard.airport.service.PilotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class FlightController {

    private FlightService flightService;
    private AirplaneService airplaneService;
    private PilotService pilotService;

    @Autowired
    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @Autowired
    public void AirplaneController(AirplaneService airplaneService) {
        this.airplaneService = airplaneService;
    }

    @Autowired
    public void PilotController(PilotService pilotService) {
        this.pilotService = pilotService;
    }

    @RequestMapping("/flights")
    public String getAllFlights(ModelMap modelMap){
        List <FlightDto> flights = flightService.getAllFlights();
        modelMap.addAttribute("flights", flights);
        return "flights";
    }

    @GetMapping("/flight/{id}")
    public String flightDetails (@PathVariable(value = "id") long id, ModelMap modelMap) {
        FlightDto flight = flightService.getFlightByIDWithAirplaneAndPilot(id);
        modelMap.addAttribute("flight", flight);
        return "flight-detail";
    }

    @RequestMapping("/flight-edit/{id}")
    public String editFlight(@PathVariable(value = "id") long id, ModelMap modelMap){
        FlightDto flight = flightService.getFlightByIDWithAirplaneAndPilot(id);
        modelMap.addAttribute("flight", flight);
        List<AirplaneDto> airplanes = airplaneService.getAllAirplanes();
        modelMap.addAttribute("airplanes", airplanes);
        List<PilotDto> pilots = pilotService.getAllPilots();
        modelMap.addAttribute("pilots", pilots);
        return "flight-edit";
    }

    @RequestMapping("/flight-new")
    public String addAirplane(ModelMap modelMap){
        FlightDto flight = new FlightDto();
        modelMap.addAttribute("flight", flight);
        List<AirplaneDto> airplanes = airplaneService.getAllAirplanes();
        modelMap.addAttribute("airplanes", airplanes);
        List<PilotDto> pilots = pilotService.getAllPilots();
        modelMap.addAttribute("pilots", pilots);
        return "flight-new";

    }

    @RequestMapping("/flight-save")
    public String saveFlight(@ModelAttribute("flight")FlightDto flightDto){
        flightService.saveEntity(flightDto);
        return "redirect:/flights";
    }


    @GetMapping("/flight-delete/{id}")
    public  String flightDelete (@PathVariable(value = "id") long id, ModelMap modelMap) {
     flightService.deleteById(id);
        return "redirect:/flights";
    }

    @PostMapping("/flights-search-results")
    public String getSearchFlights ( @RequestParam String string, ModelMap modelMap){
        List<FlightDto> flights = flightService.searchFlights(string);
        modelMap.addAttribute("flights", flights);
        return "/flights-search-results";
    }

//    @InitBinder
//    public void initBinder(WebDataBinder binder)
//    {
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//        dateFormat.setLenient(false);
//        binder.registerCustomEditor(Date.class, new CustomDateEditor(
//                dateFormat, true));
//    }

//    @InitBinder
//    public void initBinderTime(WebDataBinder binder)
//    {
//        SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm:ss");
//        timeFormat.setLenient(false);
//        binder.registerCustomEditor(Date.class, new CustomDateEditor(
//                timeFormat, true));
//    }
}
