package com.cencosud.dao.impl;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cencosud.dao.PacienteAncianoDAO;
import com.cencosud.entity.PacienteAnciano;

@Repository
public class PacienteAncianoDAOImpl extends GenericDAOImpl <PacienteAnciano, Long> implements PacienteAncianoDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<PacienteAnciano> prueba() {
		List<PacienteAnciano> pacientes = null;
		
		String hql = "select pac "
			      +" from  PacienteAnciano pac ";
			      //+" where pac.riesgo >  (select pp.riesgo from Paciente pp where pp.nroHistoriaClinica = :nroHistoriaClinica)";
		
		Query<PacienteAnciano> q  = this.sessionFactory.getCurrentSession().createQuery(hql);
		
		pacientes = q.getResultList();
		
		return pacientes;
	}


}
