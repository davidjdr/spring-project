package com.cencosud.entity;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "sala_de_espera")
public class SalaDeEspera {
	
	private SalaDeEsperaId idSalaDeEspera;
//	private Paciente paciente;
//	private Consulta consulta;
	private Timestamp llegada;
	private boolean pendiente;
	
	@EmbeddedId
	public SalaDeEsperaId getIdSalaDeEspera() {
		return idSalaDeEspera;
	}
	public void setIdSalaDeEspera(SalaDeEsperaId idSalaDeEspera) {
		this.idSalaDeEspera = idSalaDeEspera;
	}
	
	/*@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_paciente")
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_consulta")
	public Consulta getConsulta() {
		return consulta;
	}
	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}*/
	
	@Column(name = "llegada")
	public Timestamp getLlegada() {
		return llegada;
	}
	public void setLlegada(Timestamp llegada) {
		this.llegada = llegada;
	}
	
	@Column(name = "pendiente")
	public boolean isPendiente() {
		return pendiente;
	}
	public void setPendiente(boolean pendiente) {
		this.pendiente = pendiente;
	}
	
	
}
