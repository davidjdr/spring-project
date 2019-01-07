package com.cencosud.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cencosud.dao.PacienteMainDAO;
import com.cencosud.entity.PacienteMain;

@Repository
public class PacienteMainDAOImpl extends GenericDAOImpl <PacienteMain, Long> implements PacienteMainDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<PacienteMain> prueba() {
		List<PacienteMain> pacientes = null;
		
		String hql = "select pac "
			      +" from  PacienteMain pac ";
			      //+" where pac.riesgo >  (select pp.riesgo from Paciente pp where pp.nroHistoriaClinica = :nroHistoriaClinica)";
		
		Query q  = this.sessionFactory.getCurrentSession().createQuery(hql);
		
		//q.setParameter("nroHistoriaClinica", nroHistoriaClinica);
		
		pacientes = q.getResultList();
		
		return pacientes;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<PacienteMain> getPacientesMayorRiesgo(Integer nroHistoriaClinica) {
		List<PacienteMain> pacientes = null;
		
		String hql = "select pac "
			      +" from  PacienteMain pac "
			      +" where pac.riesgo >  (select pp.riesgo from PacienteMain pp where pp.nroHistoriaClinica = :nroHistoriaClinica)";
		
		Query q  = this.sessionFactory.getCurrentSession().createQuery(hql);
		
		q.setParameter("nroHistoriaClinica", nroHistoriaClinica);
		
		pacientes = q.getResultList();
		
		return pacientes;
	}
	
	@Override
	public List<PacienteMain> obtenerPacienteDeMasEdad() {
		List<PacienteMain> pacientes = null;
		
		String hql = "select pac from PacienteMain pac "
				  +" JOIN SalaDeEspera se ON se.idPaciente = pac.idPaciente "
			      +" where pac.edad = (select max(pp.edad) from PacienteMain pp JOIN SalaDeEspera ss ON ss.idPaciente = pp.idPaciente where ss.pendiente = 0) ";
		
		Query q  = this.sessionFactory.getCurrentSession().createQuery(hql);
		
		pacientes = q.getResultList();
		
		return pacientes;
	}

	@SuppressWarnings("unchecked")
	@Override
	public PacienteMain obtenerPacientePorHistoria(Integer nroHistoriaClinica) {
		PacienteMain paciente = null;
		
		String hql = "select pac from PacienteMain pac "
			      +" where pac.nroHistoriaClinica = :nroHistoriaClinica ";
		
		Query<PacienteMain> q  = this.sessionFactory.getCurrentSession().createQuery(hql);
		
		q.setParameter("nroHistoriaClinica", nroHistoriaClinica);
		
		paciente = q.getSingleResult();
		
		return paciente;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PacienteMain> obtenerPacientesEnSalaDeEspera() {
		List<PacienteMain> pacientes = null;
		
		String hql = "select pac from PacienteMain pac "
				  +" JOIN SalaDeEspera se ON se.idPaciente = pac.idPaciente "
			      +" order by se.llegada";
		
		Query<PacienteMain> q  = this.sessionFactory.getCurrentSession().createQuery(hql);
		
		pacientes = q.getResultList();
		
		return pacientes;
	}

	@Override
	public List<PacienteMain> obtenerPacientesParaAtender() {
		List<PacienteMain> pacientes = null;
		
		String hql = "select pac from PacienteMain pac "
			      +" order by pac.prioridad desc, pac.fechaIngreso";
		
		Query<PacienteMain> q  = this.sessionFactory.getCurrentSession().createQuery(hql);
		
		pacientes = q.getResultList();
		
		return pacientes;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<PacienteMain> obtenerPacientesEnSalaDeEsperaPriorizados() {
		List<PacienteMain> pacientes = null;
		
		String hql = "select pac from PacienteMain pac "
				  +" JOIN SalaDeEspera se ON se.idPaciente = pac.idPaciente "
			      +" order by pac.prioridad desc, pac.riesgo desc, se.llegada";
		
		Query<PacienteMain> q  = this.sessionFactory.getCurrentSession().createQuery(hql);
		
		pacientes = q.getResultList();
		
		return pacientes;
	}

	@Override
	public List<PacienteMain> obtenerPacientesParaAtenderPriorizados() {
		List<PacienteMain> pacientes = null;

		String hql = "select pac from PacienteMain pac "
			      +" order by pac.prioridad desc, pac.riesgo desc, pac.fechaIngreso, FIELD(tipo, 'N', 'A', 'J')";

		Query<PacienteMain> q  = this.sessionFactory.getCurrentSession().createQuery(hql);
		
		pacientes = q.getResultList();
		
		return pacientes;
	}

}
