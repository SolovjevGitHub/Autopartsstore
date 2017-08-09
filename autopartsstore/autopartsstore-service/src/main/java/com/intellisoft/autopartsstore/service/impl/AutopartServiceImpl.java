package com.intellisoft.autopartsstore.service.impl;

import com.intellisoft.autopartsstore.api.entity.IAutopartDao;
import com.intellisoft.autopartsstore.api.service.IAutopartService;
import com.intellisoft.autopartsstore.dao.impl.AutopartDaoImpl;
import com.intellisoft.autopartsstore.service.utils.HibernateUtil;
import com.intellisoft.autopartsstore.entity.Autopart;
import com.intellisoft.autopartsstore.entity.AutopartBrand;
import com.intellisoft.autopartsstore.entity.AutopartCategorie;
import com.intellisoft.autopartsstore.entity.CarModel;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;


public class AutopartServiceImpl implements IAutopartService {
    private static Logger logger=Logger.getLogger(AutopartServiceImpl.class);
    private HibernateUtil hibernateUtil=HibernateUtil.getInstance();
    private IAutopartDao autopartDao;

    public AutopartServiceImpl() {
        this.autopartDao = new AutopartDaoImpl();
    }

    public Autopart getAutopartByPartNumber(String partNumber) {
        Autopart autopart=null;
        Transaction transaction=null;
        Session session=null;
        try{
            session=hibernateUtil.openSession();
            transaction=session.getTransaction();
            transaction.begin();
            autopart = autopartDao.getAutopartByPartNumber(partNumber,session);
            transaction.commit();
        }
        catch (Exception ex){
            transaction.rollback();
            System.out.println("Sorry! A system error occurred. Could not query database. Contact your system administrator");
            logger.info(this.getClass()+" : Exception in getAutopartByPartNumber-method;",ex);
        }
        finally {
            hibernateUtil.closeSession(session);
        }

        return autopart;
    }

    public List<Autopart> getAutopartsByAutopartBrand(AutopartBrand autopartBrand) {
        List<Autopart> autopartList= null;
        Transaction transaction=null;
        Session session=null;
        try{
            session=hibernateUtil.openSession();
            transaction=session.getTransaction();
            transaction.begin();
            autopartList = autopartDao.getAutopartsByAutopartBrand(autopartBrand, session);
            transaction.commit();
        }
        catch (Exception ex){
            transaction.rollback();
            System.out.println("Sorry! A system error occurred. Could not query database. Contact your system administrator");
            logger.info(this.getClass()+" : Exception in getAutopartsByAutopartBrand-method;",ex);
        }
        finally {
            hibernateUtil.closeSession(session);
        }

        return autopartList;
    }

    public List<Autopart> getAutopartsByAutopartCategorie(AutopartCategorie autopartCategorie) {
        List<Autopart> autopartList= null;
        Transaction transaction=null;
        Session session=null;
        try{
            session=hibernateUtil.openSession();
            transaction=session.getTransaction();
            transaction.begin();
            autopartList = autopartDao.getAutopartsByAutopartCategorie(autopartCategorie, session);
            transaction.commit();
        }
        catch (Exception ex){
            transaction.rollback();
            System.out.println("Sorry! A system error occurred. Could not query database. Contact your system administrator");
            logger.info(this.getClass()+" : Exception in getAutopartsByAutopartCategorie-method;",ex);
        }
        finally {
            hibernateUtil.closeSession(session);
        }

        return autopartList;
    }

    public List<Autopart> getAutopartsByCarModel(CarModel carModel) {
        List<Autopart> autopartList= null;
        Transaction transaction=null;
        Session session=null;
        try{
            session=hibernateUtil.openSession();
            transaction=session.getTransaction();
            transaction.begin();
            autopartList = autopartDao.getAutopartsByCarModel(carModel, session);
            transaction.commit();
        }
        catch (Exception ex){
            transaction.rollback();
            System.out.println("Sorry! A system error occurred. Could not query database. Contact your system administrator");
            logger.info(this.getClass()+" : Exception in  getAutopartsByCarModel-method;",ex);
        }
        finally {
            hibernateUtil.closeSession(session);
        }

        return autopartList;
    }

    public Autopart getAutopartById(Integer id){
        Autopart autopart=null;
        Transaction transaction=null;
        Session session=null;
        try{
            session=hibernateUtil.openSession();
            transaction=session.getTransaction();
            transaction.begin();
            autopart = autopartDao.getById(id, session);
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

        return autopart;
    }

    public void deleteAutopart(Autopart autopart){
        Transaction transaction=null;
        Session session=null;
        try{
            session=hibernateUtil.openSession();
            transaction=session.getTransaction();
            transaction.begin();
            autopartDao.delete(autopart, session);
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

    public List<Autopart> getAllAutoparts(){
        List<Autopart> autopartList=null;
        Transaction transaction=null;
        Session session=null;
        try{
            session=hibernateUtil.openSession();
            transaction=session.getTransaction();
            transaction.begin();
            autopartList = autopartDao.getAll(session);
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

        return autopartList;
    }

    public void saveAutopart(Autopart autopart){
        Transaction transaction=null;
        Session session=null;
        try{
            session=hibernateUtil.openSession();
            transaction=session.getTransaction();
            transaction.begin();
            autopartDao.save(autopart, session);
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

    public void updateAutopart(Autopart autopart){

        Transaction transaction=null;
        Session session=null;
        try{
            session=hibernateUtil.openSession();
            transaction=session.getTransaction();
            transaction.begin();
            autopartDao.update(autopart, session);
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
}
