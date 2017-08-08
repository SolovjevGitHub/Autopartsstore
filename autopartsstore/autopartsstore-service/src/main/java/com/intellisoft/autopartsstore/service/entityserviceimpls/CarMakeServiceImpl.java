package com.intellisoft.autopartsstore.service.entityserviceimpls;

import com.intellisoft.autopartsstore.dao.hibernateutil.HibernateUtil;
import com.intellisoft.autopartsstore.dao.entityimpls.CarMakeDaoImpl;

import com.intellisoft.autopartsstore.entitys.CarMake;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;


public class CarMakeServiceImpl {
    private static Logger logger=Logger.getLogger(CarMakeServiceImpl.class);
    private HibernateUtil hibernateUtil=HibernateUtil.getInstance();
    private CarMakeDaoImpl carMakeImpl=new CarMakeDaoImpl();



    public  CarMake getCarMakeById(Integer id){
        CarMake carMake=null;
        Transaction transaction=null;
        Session session=null;
        try{
        session=hibernateUtil.openSession();
        transaction=session.getTransaction();
        transaction.begin();
        carMake = carMakeImpl.getById(id, session);
        transaction.commit();
        }
        catch (Exception ex){
            transaction.rollback();
            System.out.println("Error while retrieving the result of the request");
            logger.info(this.getClass()+" : Exception in getById-method;",ex);
        }
        finally {
            hibernateUtil.closeSession(session);
        }

        return carMake;
    }
    public void deleteCarMake(CarMake carMake){
        Transaction transaction=null;
        Session session=null;
        try{
            session=hibernateUtil.openSession();
            transaction=session.getTransaction();
            transaction.begin();
            carMakeImpl.delete(carMake, session);
            transaction.commit();
        }
        catch (Exception ex){
            transaction.rollback();
            System.out.println("Error while retrieving the result of the request");
            logger.info(this.getClass()+" : Exception in delete-method;",ex);
        }
        finally {
            hibernateUtil.closeSession(session);
        }
    }
    public List<CarMake> getAllCarMakes(){
        List<CarMake> carMakeList=null;
        Transaction transaction=null;
        Session session=null;
        try{
            session=hibernateUtil.openSession();
            transaction=session.getTransaction();
            transaction.begin();
            carMakeList = carMakeImpl.getAll(session);
            transaction.commit();
        }
        catch (Exception ex){
            transaction.rollback();
            System.out.println("Error while retrieving the result of the request");
            logger.info(this.getClass()+" : Exception in geAll-method;",ex);
        }
        finally {
            hibernateUtil.closeSession(session);
        }

       return carMakeList;
    }
    public void saveCarMake(CarMake carMake){
        Transaction transaction=null;
        Session session=null;
        try{
            session=hibernateUtil.openSession();
            transaction=session.getTransaction();
            transaction.begin();
            carMakeImpl.save(carMake, session);
            transaction.commit();
        }
        catch (Exception ex){
            transaction.rollback();
            System.out.println("Error while retrieving the result of the request");
            logger.info(this.getClass()+" : Exception in save-method;",ex);
        }
        finally {
            hibernateUtil.closeSession(session);
        }
    }
    public void updateCarMake(CarMake carMake){

        Transaction transaction=null;
        Session session=null;
        try{
            session=hibernateUtil.openSession();
            transaction=session.getTransaction();
            transaction.begin();
            carMakeImpl.update(carMake, session);
            transaction.commit();
        }
        catch (Exception ex){
            transaction.rollback();
            System.out.println("Error while retrieving the result of the request");
            logger.info(this.getClass()+" : Exception in update-method;",ex);
        }
        finally {
            hibernateUtil.closeSession(session);
        }
    }

    public CarMake getCarMakeByName(String name) {
        CarMake carMake=null;
        Transaction transaction=null;
        Session session=null;
        try{
            session=hibernateUtil.openSession();
            transaction=session.getTransaction();
            transaction.begin();
            Criteria criteria = session.createCriteria(CarMake.class);
            criteria.add(Restrictions.eq("name", name));
            carMake=(CarMake)criteria.list().get(0);
            transaction.commit();
        }
        catch (Exception ex){
            transaction.rollback();
            System.out.println("Error while retrieving the result of the request");
            logger.info(this.getClass()+" : Exception in getById-method;",ex);
        }
        finally {
            hibernateUtil.closeSession(session);
        }

        return  carMake;
    }
}
