package com.cencosud.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cencosud.dao.GenericDAO;


@SuppressWarnings("unchecked")
@Repository
public abstract class GenericDAOImpl<E, K extends Serializable> 
        implements GenericDAO<E, K> {
    
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
     
    protected Class<? extends E> daoType;
     
	@SuppressWarnings("rawtypes")
	public GenericDAOImpl() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        daoType = (Class) pt.getActualTypeArguments()[0];
    }
     
    protected Session currentSession() {
        return sessionFactory.getCurrentSession();
    }
     
    @Override
    public void add(E entity) {
        currentSession().save(entity);
    }
     
    @Override
    public void saveOrUpdate(E entity) {
        currentSession().saveOrUpdate(entity);
    }
     
    @Override
    public void update(E entity) {
        currentSession().saveOrUpdate(entity);
    }
     
    @Override
    public void remove(E entity) {
        currentSession().delete(entity);
    }
     
    @Override
    public E find(K key) {
        return currentSession().get(daoType, key);
    }
	
    public void merge(E entity){
    	 currentSession().merge(entity);
    }
	
	@Override
    public List<E> getAll() {
		CriteriaBuilder builder = currentSession().getCriteriaBuilder();
		CriteriaQuery<E> criteria = (CriteriaQuery<E>) builder.createQuery(daoType);
		criteria.select( criteria.from(daoType) );
		return currentSession().createQuery(criteria).getResultList();
    }
}