package com.kemalkeskin.rentACar.entities.concretes;

import java.util.List;

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
@Table(name = "fuels")
public class Fuel extends BaseEntity {
	
	@Column(name = "name")
	private String name;
	
	@OneToMany(mappedBy = "fuel")
    private List<Model> models;

}
