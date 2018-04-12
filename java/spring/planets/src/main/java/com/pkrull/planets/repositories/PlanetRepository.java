package com.pkrull.planets.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.pkrull.planets.models.Planet;

public interface PlanetRepository extends CrudRepository<Planet, Long> {
	public List<Planet>findAll();
	// add if using getById
	public Planet getById(Long id);
}
