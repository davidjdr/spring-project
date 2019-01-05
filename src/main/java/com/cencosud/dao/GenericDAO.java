package com.cencosud.dao;

import java.util.List;

public interface GenericDAO<E,K> {
    public void add(E entity) ;
    public void saveOrUpdate(E entity) ;
    public void update(E entity) ;
    public void remove(E entity);
    public E find(K key);
    public List<E> getAll() ;
    public void merge(E entity);
}