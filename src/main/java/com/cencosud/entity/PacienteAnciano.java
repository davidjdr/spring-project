package com.cencosud.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.hibernate.annotations.DiscriminatorFormula;

@Entity
@DiscriminatorValue("A")
public class PacienteAnciano extends PacienteMain {

	private Boolean dieta;

	@Column(name = "dieta")
	public Boolean getDieta() {
		return dieta;
	}

	public void setDieta(Boolean dieta) {
		this.dieta = dieta;
	}
	
	
}
