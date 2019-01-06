package com.cencosud.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "view_paciente_edad_prioridad_riesgo")
public class Paciente {
	
	private Integer idPaciente;
	private String nombre;
	private Date fechaNacimiento;
	private Integer nroHistoriaClinica;
	private Integer relacionPesoEstatura;
	private Integer aniosFumando;
	private Boolean dieta;
	private Hospital hospital;
	private Integer edad;
	private BigDecimal prioridad;
	private BigDecimal riesgo;
	
	@Id
	@Column(name = "id_paciente", unique = true, nullable = false)
	public Integer getIdPaciente() {
		return idPaciente;
	}
	public void setIdPaciente(Integer idPaciente) {
		this.idPaciente = idPaciente;
	}
	
	@Column(name = "nombre")
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Column(name = "fecha_nacimiento")
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	@Column(name = "nro_historia_clinica")
	public Integer getNroHistoriaClinica() {
		return nroHistoriaClinica;
	}
	public void setNroHistoriaClinica(Integer nroHistoriaClinica) {
		this.nroHistoriaClinica = nroHistoriaClinica;
	}
	
	@Column(name = "relacion_peso_estatura")
	public Integer getRelacionPesoEstatura() {
		return relacionPesoEstatura;
	}
	public void setRelacionPesoEstatura(Integer relacionPesoEstatura) {
		this.relacionPesoEstatura = relacionPesoEstatura;
	}
	
	@Column(name = "anios_fumando")
	public Integer getAniosFumando() {
		return aniosFumando;
	}
	public void setAniosFumando(Integer aniosFumando) {
		this.aniosFumando = aniosFumando;
	}
	
	@Column(name = "dieta")
	public Boolean isDieta() {
		return dieta;
	}
	public void setDieta(Boolean dieta) {
		this.dieta = dieta;
	}
	
	@Column(name = "edad")
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	
	@Column(name = "prioridad")
	public BigDecimal getPrioridad() {
		return prioridad;
	}
	public void setPrioridad(BigDecimal prioridad) {
		this.prioridad = prioridad;
	}
	
	@Column(name = "riesgo")
	public BigDecimal getRiesgo() {
		return riesgo;
	}
	public void setRiesgo(BigDecimal riesgo) {
		this.riesgo = riesgo;
	}
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_hospital")
	public Hospital getHospital() {
		return hospital;
	}
	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}
}
