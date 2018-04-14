package com.pkrull.planets.services;

import org.springframework.stereotype.Service;

import com.pkrull.planets.models.Moon;
import com.pkrull.planets.models.Planet;
import com.pkrull.planets.repositories.MoonRepository;

@Service
public class MoonService {
	private final MoonRepository mRepo;
	
	public MoonService(MoonRepository mRepo) {
		// TODO Auto-generated constructor stub
		this.mRepo = mRepo;
	}
	
	public void addMoon(Planet planet, Moon moon) {
		System.out.println(moon.getPlanet());
		
		moon.setPlanet(planet);
		System.out.println(moon.getPlanet());
		mRepo.save(moon);
	}

}
