package com.cencosud.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cencosud.entity.PacienteJoven;

@Repository
public interface PacienteJovenDAO extends GenericDAO<PacienteJoven, Long>{

	public List<PacienteJoven> obtenerPacientesFumadoresUrgentes();
}
