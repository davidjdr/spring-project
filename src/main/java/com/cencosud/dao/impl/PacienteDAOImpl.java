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
	public List<Paciente> getPacientesMayorRiesgo(Integer nroHistoriaClinica) {
		List<Paciente> pacientes = null;
		
		String hql = "select pac "
			      +" from  Paciente pac "
			      +" where pac.riesgo >  (select pp.riesgo from Paciente pp where pp.nroHistoriaClinica = :nroHistoriaClinica)";
		
		Query q  = this.sessionFactory.getCurrentSession().createQuery(hql);
		
		q.setParameter("nroHistoriaClinica", nroHistoriaClinica);
		
		pacientes = q.getResultList();
		
		return pacientes;
	}

	@Override
	public List<Paciente> obtenerPacienteDeMasEdad() {
		List<Paciente> pacientes = null;
		
		String hql = "select pac from Paciente pac "
				  +" JOIN SalaDeEspera se ON se.idSalaDeEspera.idPaciente = pac.idPaciente "
			      +" where pac.edad = (select max(pp.edad) from Paciente pp JOIN SalaDeEspera ss ON ss.idSalaDeEspera.idPaciente = pp.idPaciente where ss.pendiente = 0) ";
		
		Query q  = this.sessionFactory.getCurrentSession().createQuery(hql);
		
		pacientes = q.getResultList();
		
		return pacientes;
	}

}
