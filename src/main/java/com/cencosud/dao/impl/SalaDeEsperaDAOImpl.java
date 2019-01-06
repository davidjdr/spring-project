package com.cencosud.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cencosud.dao.SalaDeEsperaDAO;
import com.cencosud.entity.SalaDeEspera;

@Repository
public class SalaDeEsperaDAOImpl extends GenericDAOImpl <SalaDeEspera, Long> implements SalaDeEsperaDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<SalaDeEspera> getPacienteMasEdad() {
		List<SalaDeEspera> salaDeEspera = null;

		String hql = "";
		
		Query q  = this.sessionFactory.getCurrentSession().createQuery(hql);
		
		//q.setParameter("nroHistoriaClinica", nroHistoriaClinica);
		
		salaDeEspera = q.getResultList();
		
		return salaDeEspera;
	}

}
