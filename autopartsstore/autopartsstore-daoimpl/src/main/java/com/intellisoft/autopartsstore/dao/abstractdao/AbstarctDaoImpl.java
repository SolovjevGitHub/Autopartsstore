package com.intellisoft.autopartsstore.dao.abstractdao;


import com.intellisoft.autopartsstore.dao.api.IGenericDao;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;


public class AbstarctDaoImpl<T> implements IGenericDao<T> {

    private Class<T> clazz;

    public AbstarctDaoImpl(Class<T> clazz) {
        this.clazz = clazz;
    }

    public void save(T entity, Session session) throws Exception {
        session.save(entity);
    }

    public void update(T entity, Session session) throws Exception {
        session.update(entity);
    }

    public void delete(T entity, Session session) throws Exception {
        session.delete(entity);
    }

    public T getById(Integer id, Session session) throws Exception {
        Criteria criteria = session.createCriteria(clazz);
        criteria.add(Restrictions.eq("id",id));

        return (T)criteria.list().get(0);
    }

    public List<T> getAll(Session session) throws Exception {
        Criteria criteria = session.createCriteria(clazz);
        return (List<T>)criteria.list();
    }
}