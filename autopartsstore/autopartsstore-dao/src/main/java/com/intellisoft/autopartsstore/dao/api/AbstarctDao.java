package com.intellisoft.autopartsstore.dao.api;

import com.intellisoft.autopartsstore.entitys.CarMake;
import com.intellisoft.autopartsstore.hibernateutil.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.internal.SessionFactoryImpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class AbstarctDao<T> {
    private Transaction transaction;
    private static HibernateUtil hibernateUtil = HibernateUtil.getHibernateSessionFactory();
    public Class<T> clazz;


    protected void setClazz(Class<T> clazz) {
        this.clazz = clazz;
    }

    public void save(T entity, Session session) throws Exception {

        session.save(entity);

    }

    public void update(T entity, Session session) throws Exception {

        session.update(entity);

    }

    public void delete(T entity, Session session) throws Exception{

        session.delete(entity);
    }

    public T getById(Integer id, Session session) throws Exception {

        Criteria criteria = session.createCriteria(clazz);
        T entity = (T) criteria.list().get(id-1);

        return entity;
    }

    public List<T> getAll(Session session) throws Exception {

        Criteria criteria = session.createCriteria(clazz);
        List<T> listAll = criteria.list();

        return listAll;
    }

}
