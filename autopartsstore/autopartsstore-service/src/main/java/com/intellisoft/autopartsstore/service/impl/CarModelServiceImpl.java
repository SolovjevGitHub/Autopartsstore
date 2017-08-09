package com.intellisoft.autopartsstore.service.impl;

import com.intellisoft.autopartsstore.api.entity.ICarModelDao;
import com.intellisoft.autopartsstore.api.service.ICarModelService;
import com.intellisoft.autopartsstore.dao.impl.CarModelDaoImpl;
import com.intellisoft.autopartsstore.service.utils.HibernateUtil;
import com.intellisoft.autopartsstore.entity.CarModel;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;


public class CarModelServiceImpl implements ICarModelService {
    private static Logger logger=Logger.getLogger(CarModelServiceImpl.class);
    private HibernateUtil hibernateUtil=HibernateUtil.getInstance();
    private ICarModelDao carModelDao;

    public CarModelServiceImpl() {
        this.carModelDao = new CarModelDaoImpl();
    }

    public CarModel getCarModelById(Integer id){
       CarModel carModel=null;
        Transaction transaction=null;
        Session session=null;
        try{
            session=hibernateUtil.openSession();
            transaction=session.getTransaction();
            transaction.begin();
            carModel = carModelDao.getById(id, session);
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

        return carModel;
    }
    public void deleteCarModel(CarModel carModel){
        Transaction transaction=null;
        Session session=null;
        try{
            session=hibernateUtil.openSession();
            transaction=session.getTransaction();
            transaction.begin();
            carModelDao.delete(carModel, session);
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
    public List<CarModel> getAllCarModels(){
        List<CarModel> carModelList=null;
        Transaction transaction=null;
        Session session=null;
        try{
            session=hibernateUtil.openSession();
            transaction=session.getTransaction();
            transaction.begin();
            carModelList = carModelDao.getAll(session);
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

        return carModelList;
    }
    public void saveCarModel(CarModel carModel){
        Transaction transaction=null;
        Session session=null;
        try{
            session=hibernateUtil.openSession();
            transaction=session.getTransaction();
            transaction.begin();
            carModelDao.save(carModel, session);
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
    public void updateCarModel(CarModel carModel){

        Transaction transaction=null;
        Session session=null;
        try{
            session=hibernateUtil.openSession();
            transaction=session.getTransaction();
            transaction.begin();
            carModelDao.update(carModel, session);
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
    public List<CarModel> getCarModelsByBodyCode(String code) {
        List<CarModel> carModelList=null;
        Transaction transaction=null;
        Session session=null;
        try{
            session=hibernateUtil.openSession();
            transaction=session.getTransaction();
            transaction.begin();
            carModelList = carModelDao.getCarModelsByBodyCode(code,session);
            transaction.commit();
        }
        catch (Exception ex){
            transaction.rollback();
            System.out.println("Sorry! A system error occurred. Could not query database. Contact your system administrator");
            logger.info(this.getClass()+" : Exception in  getCarModelsByBodyCode-method;",ex);
        }
        finally {
            hibernateUtil.closeSession(session);
        }
        return carModelList;

    }
    public List<CarModel> getCarModelsByEngineType(String engineType) {
        List<CarModel> carModelList=null;
        Transaction transaction=null;
        Session session=null;
        try{
            session=hibernateUtil.openSession();
            transaction=session.getTransaction();
            transaction.begin();
            carModelList = carModelDao.getCarModelsByEngineType(engineType,session);
            transaction.commit();
        }
        catch (Exception ex){
            transaction.rollback();
            System.out.println("Sorry! A system error occurred. Could not query database. Contact your system administrator");
            logger.info(this.getClass()+" : Exception in getCarModelsByEngineType-method;",ex);
        }
        finally {
            hibernateUtil.closeSession(session);
        }
        return carModelList;

    }
    public List<CarModel> getCarModelsByYearFrom(Integer yearFrom) {
        List<CarModel> carModelList=null;
        Transaction transaction=null;
        Session session=null;
        try{
            session=hibernateUtil.openSession();
            transaction=session.getTransaction();
            transaction.begin();
            carModelList = carModelDao.getCarModelsByYearFrom(yearFrom,session);
            transaction.commit();
        }
        catch (Exception ex){
            transaction.rollback();
            System.out.println("Sorry! A system error occurred. Could not query database. Contact your system administrator");
            logger.info(this.getClass()+" : Exception in getCarModelsByYearFrom-method;",ex);
        }
        finally {
            hibernateUtil.closeSession(session);
        }
        return carModelList;

    }
    public List<CarModel> getCarModelsByYearTo(Integer yearTo) {
        List<CarModel> carModelList=null;
        Transaction transaction=null;
        Session session=null;
        try{
            session=hibernateUtil.openSession();
            transaction=session.getTransaction();
            transaction.begin();
            carModelList = carModelDao.getCarModelsByYearTo(yearTo,session);
            transaction.commit();
        }
        catch (Exception ex){
            transaction.rollback();
            System.out.println("Sorry! A system error occurred. Could not query database. Contact your system administrator");
            logger.info(this.getClass()+" : getCarModelsByYearTo;",ex);
        }
        finally {
            hibernateUtil.closeSession(session);
        }
        return carModelList;

    }
}
