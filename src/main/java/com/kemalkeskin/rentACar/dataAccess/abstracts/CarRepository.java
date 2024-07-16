package com.kemalkeskin.rentACar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kemalkeskin.rentACar.entities.concretes.Car;
@Repository
public interface CarRepository extends JpaRepository<Car, Integer>{
	
	boolean existsByPlate(String plate);
	
	Car findByModelYear(int modelYear);
	
	Car findByStatus(int status);
	
	Car existsByDailyPrice(double dailyPrice);

}
