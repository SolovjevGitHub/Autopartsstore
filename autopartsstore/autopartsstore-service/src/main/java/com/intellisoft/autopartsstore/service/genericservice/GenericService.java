package com.intellisoft.autopartsstore.service.genericservice;

import org.hibernate.Session;

import java.util.List;

/**
 * Autoparts store project.
 * Author: Solovjev Sergey
 */
public interface GenericService<T,K>{

    public void save(T entity) throws Exception;

    public void update(T entity, Session session) throws Exception;

    public void delete(T entity, Session session) throws Exception;

    public T getById(K key, Session session) throws Exception;

    public List<T> getAll(Session session) throws Exception;

}
