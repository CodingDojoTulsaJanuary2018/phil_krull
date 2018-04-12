package com.pkrull.planets.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.pkrull.planets.models.Planet;
import com.pkrull.planets.repositories.PlanetRepository;

@Service
public class PlanetService {
	private final PlanetRepository pRepo;
	
	public PlanetService(PlanetRepository pRepo) {
		// TODO Auto-generated constructor stub
		this.pRepo = pRepo;
	}
	
	public List<Planet> getAllPlanets() {
		// returns the result of the planet repo
		return pRepo.findAll();
	}

	public void addPlanet(@Valid Planet planet) {
		// TODO Auto-generated method stub
		pRepo.save(planet);
	}

	public Planet getPlanet(Long id) {
		// TODO Auto-generated method stub
		return pRepo.getById(id);
		// in order to return an Planet, you have to odd .orElse(null) after findById(id)
//		return pRepo.findById(id).orElse(null);
	}

	public void destroyPlanet(Long id) {
		// TODO Auto-generated method stub
		pRepo.deleteById(id);
	}

}
