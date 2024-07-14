package com.kemalkeskin.rentACar.entities.concretes;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.kemalkeskin.rentACar.core.entities.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "brands")
public class Brand extends BaseEntity{
	
	@Column(name = "name")
	private String name;
	
	 @OneToMany(mappedBy = "brand")
	@JsonManagedReference
	 private List<Model> models;
	

}
