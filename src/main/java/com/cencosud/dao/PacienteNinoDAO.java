package com.cencosud.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cencosud.entity.PacienteNino;

@Repository
public interface PacienteNinoDAO extends GenericDAO<PacienteNino, Long>{

	public List<PacienteNino> obtenerPacientesEnEspera();
}
