package com.kemalkeskin.rentACar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kemalkeskin.rentACar.entities.concretes.Model;
@Repository
public interface ModelRepository extends JpaRepository<Model, Integer> {

}
