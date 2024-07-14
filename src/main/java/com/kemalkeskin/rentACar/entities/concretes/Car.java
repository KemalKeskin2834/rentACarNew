package com.kemalkeskin.rentACar.entities.concretes;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.kemalkeskin.rentACar.core.entities.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "cars")
public class Car  extends BaseEntity{
	
	@Column(name = "model_year")
	private int modelYear;
	
	@Column(name = "plate")
	private String plate;	
	
	@Column(name = "daily_price")
	private double dailyPrice;
	
	@Column(name = "status")
	private int status; // 1- rent  2-Available 
	
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name = "model_id")
	private Model model;

}
