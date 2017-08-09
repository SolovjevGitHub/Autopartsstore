package com.intellisoft.autopartsstore.service.impl;

import com.intellisoft.autopartsstore.api.entity.ICarMakerDao;
import com.intellisoft.autopartsstore.api.service.ICarMakerService;
import com.intellisoft.autopartsstore.entity.CarModel;
import com.intellisoft.autopartsstore.service.utils.HibernateUtil;
import com.intellisoft.autopartsstore.dao.impl.CarMakerDaoImpl;

import com.intellisoft.autopartsstore.entity.CarMaker;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;


public class CarMakerServiceImpl implements ICarMakerService {
    private static Logger logger=Logger.getLogger(CarMakerServiceImpl.class);
    private HibernateUtil hibernateUtil=HibernateUtil.getInstance();
    private ICarMakerDao carMakerDao;

    public CarMakerServiceImpl() {
        this.carMakerDao = new CarMakerDaoImpl();
    }

    public CarMaker getCarMakerById(Integer id){
        CarMaker carMaker =null;
        Transaction transaction=null;
        Session session=null;
        try{
        session=hibernateUtil.openSession();
        transaction=session.getTransaction();
        transaction.begin();
        carMaker = carMakerDao.getById(id, session);
        transaction.commit();
        }
        catch (Exception ex){
            transaction.rollback();
            System.out.println("Sorry! A system error occurred. Could not query database. Contact your system administrator");
            logger.info(this.getClass()+" : Exception in getById-method;",ex);
        }
        finally {
            hibernateUtil.closeSession(session);
        }

        return carMaker;
    }
    public void deleteCarMaker(CarMaker carMaker){
        Transaction transaction=null;
        Session session=null;
        try{
            session=hibernateUtil.openSession();
            transaction=session.getTransaction();
            transaction.begin();
            carMakerDao.delete(carMaker, session);
            transaction.commit();
        }
        catch (Exception ex){
            transaction.rollback();
            System.out.println("Sorry! A system error occurred. Failed to delete data from the database. Contact your system administrator");
            logger.info(this.getClass()+" : Exception in delete-method;",ex);
        }
        finally {
            hibernateUtil.closeSession(session);
        }
    }
    public List<CarMaker> getAllCarMakers(){
        List<CarMaker> carMakerList =null;
        Transaction transaction=null;
        Session session=null;
        try{
            session=hibernateUtil.openSession();
            transaction=session.getTransaction();
            transaction.begin();
            carMakerList = carMakerDao.getAll(session);
            transaction.commit();
        }
        catch (Exception ex){
            transaction.rollback();
            System.out.println("Sorry! A system error occurred. Could not query database. Contact your system administrator");
            logger.info(this.getClass()+" : Exception in geAll-method;",ex);
        }
        finally {
            hibernateUtil.closeSession(session);
        }

       return carMakerList;
    }
    public void saveCarMaker(CarMaker carMaker){
        Transaction transaction=null;
        Session session=null;
        try{
            session=hibernateUtil.openSession();
            transaction=session.getTransaction();
            transaction.begin();
            carMakerDao.save(carMaker, session);
            transaction.commit();
        }
        catch (Exception ex){
            transaction.rollback();
            System.out.println("Sorry! A system error occurred. Failed to add new data to the database. Contact your system administrator");
            logger.info(this.getClass()+" : Exception in save-method;",ex);
        }
        finally {
            hibernateUtil.closeSession(session);
        }
    }
    public void updateCarMaker(CarMaker carMaker){

        Transaction transaction=null;
        Session session=null;
        try{
            session=hibernateUtil.openSession();
            transaction=session.getTransaction();
            transaction.begin();
            carMakerDao.update(carMaker, session);
            transaction.commit();
        }
        catch (Exception ex){
            transaction.rollback();
            System.out.println("Sorry! A system error occurred. Could not update the cached data. Contact your system administrator");
            logger.info(this.getClass()+" : Exception in update-method;",ex);
        }
        finally {
            hibernateUtil.closeSession(session);
        }
    }
    public List<CarModel> getCarModelsByCarMaker(CarMaker carMaker) {
        List<CarModel> carModelList=null;
        Transaction transaction=null;
        Session session=null;
        try{
            session=hibernateUtil.openSession();
            transaction=session.getTransaction();
            transaction.begin();
            carModelList=carMakerDao.getCarModelsByCarMaker(carMaker, session);
            transaction.commit();
        }
        catch (Exception ex){
            transaction.rollback();
            System.out.println("Sorry! A system error occurred. Could not query database. Contact your system administrator");
            logger.info(this.getClass()+" : Exception in getCarModelsByCarMaker-method;",ex);
        }
        finally {
            hibernateUtil.closeSession(session);
        }
        return carModelList;
    }


}
