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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pkrull.planets.models.Moon;
import com.pkrull.planets.models.Planet;
import com.pkrull.planets.services.MoonService;
import com.pkrull.planets.services.PlanetService;

@Controller
public class PlanetController {
	private final PlanetService pService;
	private final MoonService mService;
	
	public PlanetController(PlanetService pService, MoonService mService) {
		// TODO Auto-generated constructor stub
		this.pService = pService;
		this.mService = mService;
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
	
	// show planet, add moon
	@GetMapping("/planets/{id}")
	public String showPlanet(@PathVariable("id")Long id, Model model) {
		
		model.addAttribute("newMoon", new Moon());
		// get a planet based on id
		Planet planet = pService.getPlanet(id);
		model.addAttribute("planet", planet);
		return "show.jsp";
	}
	
	// add a moon to a planet
	@PostMapping("/planets/{id}/addMoon")
	public String addMoon(@Valid @ModelAttribute("moon")Moon newMoon, BindingResult result, RedirectAttributes rAttr, @PathVariable("id")Long id, Model model) {
		Planet planet = pService.getPlanet(id);
		if(result.hasErrors()) {
			model.addAttribute("planet", planet);
			return "show.jsp";
		} else {
			// add the moon
			mService.addMoon(planet, newMoon);
			System.out.println(newMoon.getId());
			rAttr.addFlashAttribute("success", "That's a space station");
			return "redirect:/planets/" + id;
		}
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
