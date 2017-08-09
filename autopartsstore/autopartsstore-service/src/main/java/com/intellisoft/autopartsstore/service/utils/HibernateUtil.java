package com.intellisoft.autopartsstore.service.utils;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {
    private static Logger logger = Logger.getLogger(HibernateUtil.class);

    private static HibernateUtil instance = new HibernateUtil();

    private static SessionFactory sessionFactory;

    private Session session;


    private HibernateUtil() {
        setSessionFactory();
    }

    public static HibernateUtil getInstance() {
         return instance;
    }

    private  void setSessionFactory() throws ExceptionInInitializerError {
        if (sessionFactory == null) {
            try {
                sessionFactory = new Configuration().configure().buildSessionFactory();
                logger.info("Hibernate Configuration loaded. SessionFactory is build");
            } catch (ExceptionInInitializerError ex) {
                logger.info("Hibernate Configuration error", ex);
                throw new ExceptionInInitializerError();


            }

        }
    }

    public Session openSession() {
        if (session == null || !session.isOpen()) {
            session = sessionFactory.openSession();
        }
        return session;
    }

    public void closeSession(Session session) {
        session.close();
    }



}
