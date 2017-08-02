package com.intellisoft.autopartsstore.runner;

import com.intellisoft.autopartsstore.api.AbstarctDao;
import com.intellisoft.autopartsstore.dao.impls.ICarMakeImpl;
import com.intellisoft.autopartsstore.entitys.CarMake;
import com.intellisoft.autopartsstore.hibernateutil.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by Сирожа и Маха on 01.08.2017.
 */
public class RunApp {
    public static void main(String[] args) {
       ICarMakeImpl iCarMake=new ICarMakeImpl();
       Session session=HibernateUtil.getHibernateSessionFactory().getSession();


        System.out.println(iCarMake.getById(2,session).toString());

    }
}
