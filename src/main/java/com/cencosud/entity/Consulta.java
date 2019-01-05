package com.cencosud.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "consulta")
public class Consulta {
	
	private Integer idConsulta;
	private Integer cantPacientes;
	private String nombreEspecialista;
	private Hospital hospital;
	private TipoConsulta tipoConsulta;
	private Integer idPaciente;

	@Id
	@Column(name = "id_consulta", unique = true, nullable = false)
	public Integer getIdConsulta() {
		return idConsulta;
	}
	public void setIdConsulta(Integer idConsulta) {
		this.idConsulta = idConsulta;
	}
	
	@Column(name = "cant_pacientes")
	public Integer getCantPacientes() {
		return cantPacientes;
	}
	public void setCantPacientes(Integer cantPacientes) {
		this.cantPacientes = cantPacientes;
	}
	
	@Column(name = "nombre_especialista")
	public String getNombreEspecialista() {
		return nombreEspecialista;
	}
	public void setNombreEspecialista(String nombreEspecialista) {
		this.nombreEspecialista = nombreEspecialista;
	}
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_hospital")
	public Hospital getHospital() {
		return hospital;
	}
	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_tipo_consulta")
	public TipoConsulta getTipoConsulta() {
		return tipoConsulta;
	}
	public void setTipoConsulta(TipoConsulta tipoConsulta) {
		this.tipoConsulta = tipoConsulta;
	}

	@Column(name = "id_paciente")
	public Integer getIdPaciente() {
		return idPaciente;
	}
	public void setIdPaciente(Integer idPaciente) {
		this.idPaciente = idPaciente;
	}
}
