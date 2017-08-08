package com.intellisoft.autopartsstore.service.entityserviceimpls;

import com.intellisoft.autopartsstore.dao.entityimpls.UserRoleDaoImpl;
import com.intellisoft.autopartsstore.dao.hibernateutil.HibernateUtil;
import com.intellisoft.autopartsstore.entitys.UserRole;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;


public class UserRoleServiceImpl {
    private static Logger logger=Logger.getLogger(UserRoleServiceImpl.class);
    private HibernateUtil hibernateUtil=HibernateUtil.getInstance();
    private UserRoleDaoImpl userRoleImpl=new UserRoleDaoImpl();


    public UserRole getUserRoleById(Integer id){
        UserRole userRole=null;
        Transaction transaction=null;
        Session session=null;
        try{
            session=hibernateUtil.openSession();
            transaction=session.getTransaction();
            transaction.begin();
            userRole = userRoleImpl.getById(id, session);
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

        return userRole;
    }
    public void deleteUserRole(UserRole userRole){
        Transaction transaction=null;
        Session session=null;
        try{
            session=hibernateUtil.openSession();
            transaction=session.getTransaction();
            transaction.begin();
            userRoleImpl.delete(userRole, session);
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
    public List<UserRole> getAllUserRoles(){
        List<UserRole> userRoleList=null;
        Transaction transaction=null;
        Session session=null;
        try{
            session=hibernateUtil.openSession();
            transaction=session.getTransaction();
            transaction.begin();
            userRoleList = userRoleImpl.getAll(session);
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

        return userRoleList;
    }
    public void saveUserRole(UserRole userRole){
        Transaction transaction=null;
        Session session=null;
        try{
            session=hibernateUtil.openSession();
            transaction=session.getTransaction();
            transaction.begin();
            userRoleImpl.save(userRole, session);
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
    public void updateUserRole(UserRole userRole){

        Transaction transaction=null;
        Session session=null;
        try{
            session=hibernateUtil.openSession();
            transaction=session.getTransaction();
            transaction.begin();
            userRoleImpl.update(userRole, session);
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
