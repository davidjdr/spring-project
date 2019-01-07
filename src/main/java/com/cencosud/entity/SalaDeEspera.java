package com.cencosud.entity;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "sala_de_espera")
public class SalaDeEspera {
	
	private Integer idPaciente;
	private Timestamp llegada;
	private boolean pendiente;

	
	public SalaDeEspera(Integer idPaciente) {
		this.setIdPaciente(idPaciente);
		Date date= new Date();
		this.setLlegada(new Timestamp(date.getTime()));
	}

	@Id
	@Column(name = "id_paciente")
	public Integer getIdPaciente() {
		return idPaciente;
	}
	public void setIdPaciente(Integer idPaciente) {
		this.idPaciente = idPaciente;
	}
	
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
