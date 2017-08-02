package com.intellisoft.autopartsstore.runner;

import com.intellisoft.autopartsstore.api.AbstarctDao;
import com.intellisoft.autopartsstore.dao.impls.ICarMakeImpl;
import com.intellisoft.autopartsstore.entitys.CarMake;
import com.intellisoft.autopartsstore.hibernateutil.HibernateUtil;
import com.intellisoft.autopartsstore.service.entityservices.CarMakeService;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by Сирожа и Маха on 01.08.2017.
 */
public class RunApp {
    public static void main(String[] args) {
        CarMakeService carMakeService=new CarMakeService();
       // carMakeService.getById(2);
      // carMakeService.getAll();
        CarMake carMake=carMakeService.getById(-5);






    }
}
