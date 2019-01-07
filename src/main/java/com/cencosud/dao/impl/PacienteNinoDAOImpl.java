package com.cencosud.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cencosud.dao.PacienteNinoDAO;
import com.cencosud.entity.PacienteNino;

@Repository
public class PacienteNinoDAOImpl extends GenericDAOImpl <PacienteNino, Long> implements PacienteNinoDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<PacienteNino> obtenerPacientesEnEspera() {
		List<PacienteNino> pacientes = null;
		
		String hql = "select pac from  PacienteNino pac ";

		Query<PacienteNino> q  = this.sessionFactory.getCurrentSession().createQuery(hql);
		
		pacientes = q.getResultList();
		
		return pacientes;
	}




}
