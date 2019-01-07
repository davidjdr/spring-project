package com.cencosud.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cencosud.entity.PacienteMain;

@Repository
public interface PacienteMainDAO extends GenericDAO<PacienteMain, Long>{

	public List<PacienteMain> prueba();
	
	public List<PacienteMain> getPacientesMayorRiesgo(Integer nroHistoriaClinica);

	public List<PacienteMain> obtenerPacienteDeMasEdad();
	
	public PacienteMain obtenerPacientePorHistoria(Integer nroHistoriaClinica);

	public List<PacienteMain> obtenerPacientesEnSalaDeEspera();

	public List<PacienteMain> obtenerPacientesParaAtender();

	public List<PacienteMain> obtenerPacientesEnSalaDeEsperaPriorizados();

	public List<PacienteMain> obtenerPacientesParaAtenderPriorizados();
}
