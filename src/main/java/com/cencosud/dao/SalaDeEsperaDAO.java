package com.cencosud.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cencosud.entity.SalaDeEspera;

@Repository
public interface SalaDeEsperaDAO extends GenericDAO<SalaDeEspera, Long>{

	public List<SalaDeEspera> getPacienteMasEdad();
}
