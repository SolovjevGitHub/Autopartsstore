package com.intellisoft.autopartsstore.dao.api;


import org.hibernate.Session;


import java.util.List;


public interface IGenericDao<T> {

    public void save(T entity, Session session) throws Exception;

    public void update(T entity, Session session) throws Exception;

    public void delete(T entity, Session session) throws Exception;

    public T getById(Integer id, Session session) throws Exception;

    public List<T> getAll(Session session) throws Exception;
}
