package com.cencosud.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cencosud.entity.Consulta;

@Repository
public interface ConsultaDAO extends GenericDAO<Consulta, Long>{

	public Consulta getConsultaPacientesAtendidos();
}
