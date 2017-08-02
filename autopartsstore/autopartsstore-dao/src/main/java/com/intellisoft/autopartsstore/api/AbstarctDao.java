package com.intellisoft.autopartsstore.api;

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


public  class AbstarctDao <T>{
    private Transaction transaction;
    private static HibernateUtil hibernateUtil=HibernateUtil.getHibernateSessionFactory();
    public Class<T> clazz;


    protected void setClazz(Class<T> clazz) {
        this.clazz = clazz;
    }

    public void save(T entity, Session session){

        transaction=session.getTransaction();
        transaction.begin();
        session.save(entity);
        transaction.commit();
        hibernateUtil.closeSession(session);

    }
    public void update(T entity, Session session){
        transaction=session.getTransaction();
        transaction.begin();
        session.update(entity);
        transaction.commit();
        hibernateUtil.closeSession(session);
    }
    public  T getById(Integer id, Session session){


        transaction=session.getTransaction();
        transaction.begin();
        Criteria criteria=session.createCriteria(clazz);
        T entity=(T)criteria.list().get(0);
        transaction.commit();
        hibernateUtil.closeSession(session);
        return entity;
    }
    public List<T> getAll(Session session){
        transaction=session.getTransaction();
        transaction.begin();
        Criteria criteria=session.createCriteria(clazz);
        List<T> listAll=criteria.list();
        transaction.commit();
        hibernateUtil.closeSession(session);

        return listAll;
    }

}
