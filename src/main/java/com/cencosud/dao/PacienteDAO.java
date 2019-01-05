package com.cencosud.dao;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.cencosud.entity.Paciente;

@Repository
public interface PacienteDAO extends GenericDAO<Paciente, Long>{

	public List<Paciente> getPacientesMayorRiesgo(BigDecimal riesgo);
}
