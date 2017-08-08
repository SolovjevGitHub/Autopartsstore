package com.intellisoft.autopartsstore.service.entityserviceimpls;

import com.intellisoft.autopartsstore.dao.entityimpls.AutopartDaoImpl;
import com.intellisoft.autopartsstore.dao.hibernateutil.HibernateUtil;
import com.intellisoft.autopartsstore.entitys.Autopart;
import com.intellisoft.autopartsstore.entitys.AutopartBrand;
import com.intellisoft.autopartsstore.entitys.AutopartCategorie;
import com.intellisoft.autopartsstore.entitys.CarModel;
import com.intellisoft.autopartsstore.service.com.intellisoft.autopartsstore.service.servicesapi.IAutopartService;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;


public class AutopartServiceImpl implements IAutopartService {
    private static Logger logger=Logger.getLogger(AutopartServiceImpl.class);
    private HibernateUtil hibernateUtil=HibernateUtil.getInstance();
    private AutopartDaoImpl autopartImpl=new AutopartDaoImpl();

    public Autopart getAutopartByPartNumber(String partNumber) {
        return null;
    }
    public List<Autopart> getAutopartsByAutopartBrand(AutopartBrand autopartBrand) {
        return null;
    }
    public List<Autopart> getAutopartsByAutopartCategorie(AutopartCategorie autopartCategorie) {
        return null;
    }
    public List<Autopart> getAutopartsByCarModel(CarModel carModel) {
        return null;
    }
    public Autopart getAutopartById(Integer id){
        Autopart autopart=null;
        Transaction transaction=null;
        Session session=null;
        try{
            session=hibernateUtil.openSession();
            transaction=session.getTransaction();
            transaction.begin();
            autopart = autopartImpl.getById(id, session);
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

        return autopart;
    }
    public void deleteAutopart(Autopart autopart){
        Transaction transaction=null;
        Session session=null;
        try{
            session=hibernateUtil.openSession();
            transaction=session.getTransaction();
            transaction.begin();
            autopartImpl.delete(autopart, session);
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
    public List<Autopart> getAllAutoparts(){
        List<Autopart> autopartList=null;
        Transaction transaction=null;
        Session session=null;
        try{
            session=hibernateUtil.openSession();
            transaction=session.getTransaction();
            transaction.begin();
            autopartList = autopartImpl.getAll(session);
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

        return autopartList;
    }
    public void saveAutopart(Autopart autopart){
        Transaction transaction=null;
        Session session=null;
        try{
            session=hibernateUtil.openSession();
            transaction=session.getTransaction();
            transaction.begin();
            autopartImpl.save(autopart, session);
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
    public void updateAutopart(Autopart autopart){

        Transaction transaction=null;
        Session session=null;
        try{
            session=hibernateUtil.openSession();
            transaction=session.getTransaction();
            transaction.begin();
            autopartImpl.update(autopart, session);
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
}
