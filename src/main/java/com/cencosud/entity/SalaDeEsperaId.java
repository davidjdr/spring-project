package com.cencosud.entity;

import java.io.Serializable;

import javax.persistence.Column;

public class SalaDeEsperaId implements Serializable {

    private Integer idPaciente;
    private Integer idConsulta;
	
    @Column(name = "id_paciente")
    public Integer getIdPaciente() {
		return idPaciente;
	}
	public void setIdPaciente(Integer idPaciente) {
		this.idPaciente = idPaciente;
	}
	
	@Column(name = "id_consulta")
	public Integer getIdConsulta() {
		return idConsulta;
	}
	public void setIdConsulta(Integer idConsulta) {
		this.idConsulta = idConsulta;
	}

    
}
