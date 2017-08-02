package com.intellisoft.autopartsstore.hibernateutil;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {
    private static Logger logger = Logger.getLogger(HibernateUtil.class);

    private static HibernateUtil hibernateUtil = new HibernateUtil();

    private static SessionFactory sessionFactory;

    private Session session;

    private HibernateUtil() {
    }

    public static HibernateUtil getHibernateSessionFactory() {
        setSessionFactory();
        return hibernateUtil;
    }

    private static void setSessionFactory() throws ExceptionInInitializerError {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
            logger.info("Hibernate Configuration loaded. SessionFactory is build");
        } catch (ExceptionInInitializerError ex) {
            logger.info("Hibernate Configuration error", ex);
            throw new ExceptionInInitializerError();


        }

    }


    public Session getSession() {
        if (session == null) {
            session = sessionFactory.openSession();
        }
        return session;
    }
    public void closeSession(Session session){
        session.close();
    }


}
