package com.pkrull.planets.repositories;

import org.springframework.data.repository.CrudRepository;

import com.pkrull.planets.models.Moon;

public interface MoonRepository extends CrudRepository<Moon, Long> {

}
