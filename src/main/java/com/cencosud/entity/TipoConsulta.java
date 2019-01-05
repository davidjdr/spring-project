package com.cencosud.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipo_consulta")
public class TipoConsulta {
	
	private Integer idTipoConsulta;
	private String tipoConsulta;
	
	@Id
	@Column(name = "id_tipo_consulta", unique = true, nullable = false)
	public Integer getIdTipoConsulta() {
		return idTipoConsulta;
	}
	public void setIdTipoConsulta(Integer idTipoConsulta) {
		this.idTipoConsulta = idTipoConsulta;
	}
	
	@Column(name = "tipo_consulta")
	public String getTipoConsulta() {
		return tipoConsulta;
	}
	public void setTipoConsulta(String tipoConsulta) {
		this.tipoConsulta = tipoConsulta;
	}
	
	
}
