package com.pkrull.planets.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pkrull.planets.models.Planet;
import com.pkrull.planets.services.PlanetService;

@Controller
public class PlanetController {
	private final PlanetService pService;
	
	public PlanetController(PlanetService pService) {
		// TODO Auto-generated constructor stub
		this.pService = pService;
	}
	
	@RequestMapping("/")
	public String index(Model model) {
		// retrieve all planets
		List<Planet> allPlanets = pService.getAllPlanets();
		System.out.println(allPlanets);
		model.addAttribute("planets", allPlanets);
		return "index.jsp";
	}
	
	@RequestMapping("/planets/new")
	public String newPlanet(@ModelAttribute("planet") Planet planet) {
		return "new.jsp";
	}
	
	@PostMapping("/planets/new")
	public String addPlanet(@Valid @ModelAttribute("planet")Planet planet, BindingResult result) {
		// check for errors
		if(result.hasErrors()) {
			// if errors display messages
			return "new.jsp";
		} else {
 		// if no errors save and redirect
			pService.addPlanet(planet);
			return "redirect:/";
		}
	}
	
	@GetMapping("/planets/{id}")
	public String showPlanet(@PathVariable("id")Long id, Model model) {
		// get a planet based on id
		Planet planet = pService.getPlanet(id);
		model.addAttribute("planet", planet);
		System.out.println(planet);
		return "show.jsp";
	}
	
	@RequestMapping("/planets/{id}/edit")
	public String editPlanet(@PathVariable("id")Long id, Model model) {
		Planet planet = pService.getPlanet(id);
		model.addAttribute("planet", planet);
		return "edit.jsp";
	}
	
	@PostMapping("/planets/{id}")
	public String updatePlanet(@Valid @ModelAttribute("planet")Planet planet, BindingResult result, @PathVariable("id")Long id, Model model) {
		// get a planet based on id
		if(result.hasErrors()) {
			model.addAttribute("planet", planet);
			return "edit.jsp";
		} else {
			// update planet
			System.out.println(planet.getId());
			pService.addPlanet(planet);
			return "redirect:/planets/" + id;
		}
	}
	
	@GetMapping("/planets/{id}/destroy")
	public String deletePlanet(@PathVariable("id")Long id) {
		pService.destroyPlanet(id);
		return "redirect:/";
	}

}