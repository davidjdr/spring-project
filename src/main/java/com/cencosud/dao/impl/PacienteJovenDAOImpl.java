package com.cencosud.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cencosud.dao.PacienteJovenDAO;
import com.cencosud.entity.PacienteJoven;

@Repository
public class PacienteJovenDAOImpl extends GenericDAOImpl <PacienteJoven, Long> implements PacienteJovenDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<PacienteJoven> obtenerPacientesFumadoresUrgentes() {
		List<PacienteJoven> pacientes = null;
		
		String hql = "select pac from  PacienteJoven pac "
				+ "where pac.aniosFumando > 0 order by pac.riesgo desc";

		Query<PacienteJoven> q  = this.sessionFactory.getCurrentSession().createQuery(hql);
		
		pacientes = q.getResultList();
		
		return pacientes;
	}


}
