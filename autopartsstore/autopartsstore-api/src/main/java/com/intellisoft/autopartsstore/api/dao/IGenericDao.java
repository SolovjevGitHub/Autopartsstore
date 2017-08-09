package com.intellisoft.autopartsstore.api.dao;


import org.hibernate.Session;


import java.util.List;


public interface IGenericDao<T,K> {

    public void save(T entity, Session session) throws Exception;

    public void update(T entity, Session session) throws Exception;

    public void delete(T entity, Session session) throws Exception;

    public T getById(K key, Session session) throws Exception;

    public List<T> getAll(Session session) throws Exception;
}
