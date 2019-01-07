package com.cencosud.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.DiscriminatorFormula;

@Entity
@DiscriminatorValue("J")
public class PacienteJoven extends PacienteMain {

	private Integer aniosFumando;
	private Boolean fumador;

	@Column(name = "anios_fumando")
	public Integer getAniosFumando() {
		return aniosFumando;
	}
	public void setAniosFumando(Integer aniosFumando) {
		this.aniosFumando = aniosFumando;
		if (aniosFumando != null && aniosFumando > 0) {
			this.setFumador(true);
		} else {
			this.setFumador(false);
		}
	}
	
	@Transient
	public Boolean getFumador() {
		return fumador;
	}
	public void setFumador(Boolean fumador) {
		this.fumador = fumador;
	}
	
	
}
