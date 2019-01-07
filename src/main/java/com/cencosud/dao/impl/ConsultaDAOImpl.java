package com.cencosud.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cencosud.dao.ConsultaDAO;
import com.cencosud.entity.Consulta;

@Repository
public class ConsultaDAOImpl extends GenericDAOImpl <Consulta, Long> implements ConsultaDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Consulta> getConsultaPacientesAtendidos() {
		List<Consulta> consultas = null;
		
		String hql = "select c from Consulta c "
			      +" where c.cantPacientes =  (select max(cc.cantPacientes) from Consulta cc) ";
		
		Query<Consulta> q  = this.sessionFactory.getCurrentSession().createQuery(hql);
		
		consultas = q.getResultList();
		
		return consultas;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Boolean liberarConsultas() {
		
		String hql = "update Consulta c set c.idPaciente=null, c.cantPacientes = c.cantPacientes + 1"
				+ " where c.idPaciente is not null";
		
		Query<Consulta> q  = this.sessionFactory.getCurrentSession().createQuery(hql);
		
		int res = q.executeUpdate();
		
		return (res > 0)? true : false;
	}

	@Override
	public List<Consulta> obtenerConsultasDesocupadas() {
		List<Consulta> consultas = null;
		
		String hql = "select c from Consulta c "
			      +" where c.idPaciente is null";
		
		Query<Consulta> q  = this.sessionFactory.getCurrentSession().createQuery(hql);
		
		consultas = q.getResultList();
		
		return consultas;
	}
	
}
