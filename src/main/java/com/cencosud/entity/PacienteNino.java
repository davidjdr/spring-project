package com.cencosud.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.hibernate.annotations.DiscriminatorFormula;

@Entity
@DiscriminatorValue("N")
public class PacienteNino extends PacienteMain {

	private Integer relacionPesoEstatura;

	@Column(name = "relacion_peso_estatura")
	public Integer getRelacionPesoEstatura() {
		return relacionPesoEstatura;
	}
	public void setRelacionPesoEstatura(Integer relacionPesoEstatura) {
		this.relacionPesoEstatura = relacionPesoEstatura;
	}
	
}
