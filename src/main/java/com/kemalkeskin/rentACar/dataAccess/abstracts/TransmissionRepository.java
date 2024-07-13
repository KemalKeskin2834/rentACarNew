package com.kemalkeskin.rentACar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kemalkeskin.rentACar.entities.concretes.Transmission;

public interface TransmissionRepository extends JpaRepository<Transmission, Integer> {

}
