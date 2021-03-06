package com.belhard.airport.controllers;

import com.belhard.airport.dto.PilotDto;
import com.belhard.airport.service.PilotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.*;

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

    @RequestMapping("/pilot-edit/{id}")
    public String editPilot(@PathVariable(value = "id") long id, ModelMap modelMap){
        PilotDto pilot = pilotService.getPilotById(id);
        modelMap.addAttribute("pilot", pilot);
        return "pilot-edit";
    }

    @RequestMapping("/pilot-save")
    public String savePilot(@ModelAttribute("pilot")PilotDto pilotDto){
        pilotService.saveEntity(pilotDto);
        return "redirect:/pilots";
    }

    @GetMapping("/pilot-delete/{id}")
    public  String airplaneDelete (@PathVariable(value = "id") long id, ModelMap modelMap) {
        pilotService.deleteById(id);
        return "redirect:/pilots";
    }

    @RequestMapping("/pilot-new")
    public String addPilot(ModelMap modelMap){
        PilotDto pilot = new PilotDto();
        modelMap.addAttribute("pilot", pilot);
        return "pilot-new";
    }

    @PostMapping("/pilots-search-results")
    public String getSearchPilots ( @RequestParam String string, ModelMap modelMap){
        List<PilotDto> pilots = pilotService.searchPilots(string);
        modelMap.addAttribute("pilots", pilots);
        modelMap.addAttribute("string", string);
        return "/pilots-search-results";
    }
}
