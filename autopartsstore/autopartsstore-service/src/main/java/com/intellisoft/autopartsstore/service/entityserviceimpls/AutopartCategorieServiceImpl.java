package com.intellisoft.autopartsstore.service.entityserviceimpls;

import com.intellisoft.autopartsstore.dao.entityimpls.AutopartCategorieDaoImpl;
import com.intellisoft.autopartsstore.dao.hibernateutil.HibernateUtil;
import com.intellisoft.autopartsstore.entitys.AutopartCategorie;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;


public class AutopartCategorieServiceImpl {
    private static Logger logger=Logger.getLogger(AutopartCategorieServiceImpl.class);
    private HibernateUtil hibernateUtil=HibernateUtil.getInstance();
    private AutopartCategorieDaoImpl autopartCategoriesImpl=new AutopartCategorieDaoImpl();



    public AutopartCategorie getAutopartCategorieById(Integer id){
        AutopartCategorie autopartCategorie=null;
        Transaction transaction=null;
        Session session=null;
        try{
            session=hibernateUtil.openSession();
            transaction=session.getTransaction();
            transaction.begin();
            autopartCategorie = autopartCategoriesImpl.getById(id, session);
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

        return autopartCategorie;
    }
    public void deleteAutopartCategorie(AutopartCategorie autopartCategorie){
        Transaction transaction=null;
        Session session=null;
        try{
            session=hibernateUtil.openSession();
            transaction=session.getTransaction();
            transaction.begin();
            autopartCategoriesImpl.delete(autopartCategorie, session);
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
    public List<AutopartCategorie> getAllAutopartCategories(){
        List<AutopartCategorie> autopartCategorieList=null;
        Transaction transaction=null;
        Session session=null;
        try{
            session=hibernateUtil.openSession();
            transaction=session.getTransaction();
            transaction.begin();
            autopartCategorieList = autopartCategoriesImpl.getAll(session);
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

        return autopartCategorieList;
    }
    public void saveAutopartCategorie(AutopartCategorie autopartCategorie){
        Transaction transaction=null;
        Session session=null;
        try{
            session=hibernateUtil.openSession();
            transaction=session.getTransaction();
            transaction.begin();
            autopartCategoriesImpl.save(autopartCategorie, session);
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
    public void updateAutopartCategorie(AutopartCategorie autopartCategorie){

        Transaction transaction=null;
        Session session=null;
        try{
            session=hibernateUtil.openSession();
            transaction=session.getTransaction();
            transaction.begin();
            autopartCategoriesImpl.update(autopartCategorie, session);
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
