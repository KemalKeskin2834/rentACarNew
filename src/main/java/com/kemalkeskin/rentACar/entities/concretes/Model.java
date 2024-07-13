package com.kemalkeskin.rentACar.entities.concretes;

import java.util.List;

import com.kemalkeskin.rentACar.core.entities.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "models")
public class Model extends BaseEntity {
	
	@Column(name = "name")
	private String name;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "brand_id")
	private Brand brand;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="fuel_id" )
	private Fuel fuel;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "transmission_id")
	private Transmission transmission;
	
	@OneToMany(mappedBy = "model")
	private List<Car>cars;
	

}
