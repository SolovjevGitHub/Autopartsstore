package com.intellisoft.autopartsstore.service.entityservices;

import com.intellisoft.autopartsstore.dao.impls.ICarMakeImpl;
import com.intellisoft.autopartsstore.entitys.CarMake;
import com.intellisoft.autopartsstore.hibernateutil.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Сирожа и Маха on 02.08.2017.
 */
public class CarMakeService {
    private static Logger logger=Logger.getLogger(CarMakeService.class);
    private HibernateUtil hibernateUtil=HibernateUtil.getHibernateSessionFactory();
    private ICarMakeImpl carMakeImpl=new ICarMakeImpl();
    private Session session;



    public  CarMake getById(Integer id){
        CarMake carMake=new CarMake();
        try {
            session = hibernateUtil.openSessionWithTransaction();
            carMake = carMakeImpl.getById(id, session);
            hibernateUtil.closeSessionWithTransaction();
        }
        catch (Exception ex){
            System.out.println(this.getClass()+" : Exception in getById-method;");
            logger.info(this.getClass()+" : Exception in getById-method;",ex);
        }
        finally {
            hibernateUtil.closeSessionWithTransaction();
        }

        return carMake;
    }
    public void delete(CarMake carMake){
        try {
            session = hibernateUtil.openSessionWithTransaction();
            carMakeImpl.delete(carMake, session);
            hibernateUtil.closeSessionWithTransaction();
        }
        catch (Exception ex){
            System.out.println(this.getClass()+" : Exception in delete-method;");
            logger.info(this.getClass()+" : Exception in delete-method;",ex);
        }
        finally {
            hibernateUtil.closeSessionWithTransaction();
        }
    }
    public List<CarMake> getAll(){
        List<CarMake> carMakeList=new ArrayList<CarMake>();
        try {
            session = hibernateUtil.openSessionWithTransaction();
            carMakeList = carMakeImpl.getAll(session);
            hibernateUtil.closeSessionWithTransaction();
        }
        catch (Exception ex){
            System.out.println(this.getClass()+" : Exception in getAll-method;");
            logger.info(this.getClass()+" : Exception in getAll-method;",ex);
        }
        finally {
            hibernateUtil.closeSessionWithTransaction();
        }
       return carMakeList;
    }
    public void save(CarMake carMake){
        try {
            session = hibernateUtil.openSessionWithTransaction();
            carMakeImpl.save(carMake, session);
            hibernateUtil.closeSessionWithTransaction();
        }
        catch (Exception ex){
            System.out.println(this.getClass()+" : Exception in save-method;");
            logger.info(this.getClass()+" : Exception in save-method;",ex);
        }
        finally {
            hibernateUtil.closeSessionWithTransaction();
        }
    }
    public void update(CarMake carMake){
        try {
            session = hibernateUtil.openSessionWithTransaction();
            carMakeImpl.update(carMake, session);
            hibernateUtil.closeSessionWithTransaction();
        }
        catch (Exception ex){
            System.out.println(this.getClass()+" : Exception in getById-method;");
            logger.info(this.getClass()+" : Exception in getById-method;",ex);
        }
        finally {
            hibernateUtil.closeSessionWithTransaction();
        }
    }
}
