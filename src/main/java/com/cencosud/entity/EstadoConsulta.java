package com.cencosud.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "estado_consulta")
public class EstadoConsulta {

	private Integer idEstadoConsulta;
	private String estado;
	
	@Id
	@Column(name = "id_estado_consulta", unique = true, nullable = false)
	public Integer getIdEstadoConsulta() {
		return idEstadoConsulta;
	}
	public void setIdEstadoConsulta(Integer idEstadoConsulta) {
		this.idEstadoConsulta = idEstadoConsulta;
	}
	
	@Column(name = "estado")
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
}
