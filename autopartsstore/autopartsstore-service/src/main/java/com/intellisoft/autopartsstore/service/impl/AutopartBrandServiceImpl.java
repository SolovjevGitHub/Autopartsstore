package com.intellisoft.autopartsstore.service.impl;




import com.intellisoft.autopartsstore.api.entity.IAutopartBrandDao;
import com.intellisoft.autopartsstore.api.service.IAutopartBrandService;
import com.intellisoft.autopartsstore.dao.impl.AutopartBrandDaoImpl;
import com.intellisoft.autopartsstore.entity.Autopart;
import com.intellisoft.autopartsstore.entity.AutopartBrand;
import com.intellisoft.autopartsstore.service.utils.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;


public class AutopartBrandServiceImpl implements IAutopartBrandService {
    private static Logger logger=Logger.getLogger(AutopartBrandServiceImpl.class);
    private HibernateUtil hibernateUtil=HibernateUtil.getInstance();
    private IAutopartBrandDao autopartBrandDao;

    public AutopartBrandServiceImpl() {
        this.autopartBrandDao = new AutopartBrandDaoImpl();
    }



    public void saveAutopartBrand(AutopartBrand autopartBrand) {
        Transaction transaction=null;
        Session session=null;
        try{
            session=hibernateUtil.openSession();
            transaction=session.getTransaction();
            transaction.begin();
            autopartBrandDao.save(autopartBrand, session);
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

    public void updateAutopartBrand(AutopartBrand autopartBrand) {
        Transaction transaction=null;
        Session session=null;
        try{
            session=hibernateUtil.openSession();
            transaction=session.getTransaction();
            transaction.begin();
            autopartBrandDao.update(autopartBrand, session);
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

    public void deleteAutopartBrand(AutopartBrand autopartBrand) {
        Transaction transaction=null;
        Session session=null;
        try{
            session=hibernateUtil.openSession();
            transaction=session.getTransaction();
            transaction.begin();
            autopartBrandDao.delete(autopartBrand, session);
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

    public AutopartBrand getAutopartBrandById(Integer id) {
        AutopartBrand autopartBrand=null;
        Transaction transaction=null;
        Session session=null;
        try{
            session=hibernateUtil.openSession();
            transaction=session.getTransaction();
            transaction.begin();
            autopartBrand = autopartBrandDao.getById(id, session);
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

        return autopartBrand;
    }

    public List<AutopartBrand> getAllAutopartBrands() {
        List<AutopartBrand> autopartBrandList=null;
        Transaction transaction=null;
        Session session=null;
        try{
            session=hibernateUtil.openSession();
            transaction=session.getTransaction();
            transaction.begin();
            autopartBrandList = autopartBrandDao.getAll(session);
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

        return autopartBrandList;
    }

    public List<Autopart> getAutopartsByAutopartBrand(AutopartBrand autopartBrand) {
        List<Autopart> autopartList=null;
        Transaction transaction=null;
        Session session=null;
        try{
            session=hibernateUtil.openSession();
            transaction=session.getTransaction();
            transaction.begin();
            autopartList = autopartBrandDao.getAutopartsByAutopartBrand(autopartBrand,session);
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

        return autopartList;    }
}
