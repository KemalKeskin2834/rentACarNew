package com.kemalkeskin.rentACar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kemalkeskin.rentACar.entities.concretes.Fuel;

public interface FuelRepository extends JpaRepository<Fuel, Integer> {

	boolean existsByName(String name);
}
