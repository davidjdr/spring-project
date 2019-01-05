package com.cencosud.dao.impl;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cencosud.dao.PacienteDAO;
import com.cencosud.entity.Paciente;

@Repository
public class PacienteDAOImpl extends GenericDAOImpl <Paciente, Long> implements PacienteDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Paciente> getPacientesMayorRiesgo(BigDecimal riesgo) {
		List<Paciente> pacientes = null;
		
		String hql = "select pac "
			      +" from  Paciente pac "
			      +" where pac.riesgo >  :riesgo";
		
		Query q  = this.sessionFactory.getCurrentSession().createQuery(hql);
		
		q.setParameter("riesgo", riesgo);
		
		pacientes = q.getResultList();
		
		return pacientes;
	}

}
