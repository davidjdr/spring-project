package com.cencosud.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cencosud.entity.Consulta;

@Repository
public interface ConsultaDAO extends GenericDAO<Consulta, Long>{
	
	public List<Consulta> getConsultaPacientesAtendidos();
	
	public void liberarConsultas();

	public List<Consulta> obtenerConsultasDesocupadas();
}
