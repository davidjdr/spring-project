package com.cencosud.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cencosud.entity.PacienteAnciano;

@Repository
public interface PacienteAncianoDAO extends GenericDAO<PacienteAnciano, Long>{

	public List<PacienteAnciano> prueba();
}
