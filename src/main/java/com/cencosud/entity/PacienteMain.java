package com.cencosud.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

import org.hibernate.annotations.DiscriminatorFormula;

@Entity
@Table(name = "view_paciente_edad_prioridad_riesgo")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
    name="tipo",
    discriminatorType=DiscriminatorType.STRING
)
public class PacienteMain {

	private Integer idPaciente;
	private String nombre;
	private Date fechaNacimiento;
	private Integer nroHistoriaClinica;
	private Integer edad;
	private BigDecimal prioridad;
	private BigDecimal riesgo;
	private String tipo;
	private Hospital hospital;
	private Date fechaIngreso;

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
	
	@Column(name = "edad", insertable = false, updatable = false)
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	
	@Column(name = "prioridad", insertable = false, updatable = false)
	public BigDecimal getPrioridad() {
		return prioridad;
	}
	public void setPrioridad(BigDecimal prioridad) {
		this.prioridad = prioridad;
	}
	
	@Column(name = "riesgo", insertable = false, updatable = false)
	public BigDecimal getRiesgo() {
		return riesgo;
	}
	public void setRiesgo(BigDecimal riesgo) {
		this.riesgo = riesgo;
	}

	@Column(name = "tipo", insertable = false, updatable = false)
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_hospital")
	public Hospital getHospital() {
		return hospital;
	}
	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}
	
	@Column(name = "fecha_ingreso", insertable = false, updatable = false)
	public Date getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	
	
}
