package com.intellisoft.autopartsstore.service.impl;

import com.intellisoft.autopartsstore.api.dao.IGenericDao;
import com.intellisoft.autopartsstore.api.entity.IUserDao;
import com.intellisoft.autopartsstore.api.service.IUserService;
import com.intellisoft.autopartsstore.dao.impl.UserDaoImpl;
import com.intellisoft.autopartsstore.entity.Order;
import com.intellisoft.autopartsstore.entity.User;
import com.intellisoft.autopartsstore.entity.UserRole;
import com.intellisoft.autopartsstore.service.utils.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;


public class UserServiceImpl implements IUserService {
    private static Logger logger = Logger.getLogger(UserServiceImpl.class);
    private HibernateUtil hibernateUtil = HibernateUtil.getInstance();
    private IUserDao userDao;

    public UserServiceImpl() {
        this.userDao = new UserDaoImpl();
    }

    public void saveUser(User user) {
        Transaction transaction=null;
        Session session=null;
        try{
            session=hibernateUtil.openSession();
            transaction=session.getTransaction();
            transaction.begin();
            userDao.save(user, session);
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

    public void updateUser(User user) {
        Transaction transaction=null;
        Session session=null;
        try{
            session=hibernateUtil.openSession();
            transaction=session.getTransaction();
            transaction.begin();
            userDao.update(user, session);
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

    public void deleteUser(User user) {
        Transaction transaction=null;
        Session session=null;
        try{
            session=hibernateUtil.openSession();
            transaction=session.getTransaction();
            transaction.begin();
            userDao.delete(user, session);
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

    public User getUserById(Integer id) {
        User user=null;
        Transaction transaction=null;
        Session session=null;
        try{
            session=hibernateUtil.openSession();
            transaction=session.getTransaction();
            transaction.begin();
            user = userDao.getById(id, session);
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

        return user;
    }

    public List<User> getAllUsers() {
        List<User> userList=null;
        Transaction transaction=null;
        Session session=null;
        try{
            session=hibernateUtil.openSession();
            transaction=session.getTransaction();
            transaction.begin();
            userList = userDao.getAll(session);
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

        return userList;
    }

    public Boolean userIsRegistered(User user) {
        Boolean isRegistered=false;
        Transaction transaction=null;
        Session session=null;
        try{
            session=hibernateUtil.openSession();
            transaction=session.getTransaction();
            transaction.begin();
            isRegistered=userDao.userIsRegistered(user, session);
            transaction.commit();

        }
        catch (Exception ex){
            transaction.rollback();
            System.out.println("Sorry! A system error occurred. Could not query database. Contact your system administrator");
            logger.info(this.getClass()+" : Exception in userIsRegistered-method;",ex);
        }
        finally {
            hibernateUtil.closeSession(session);
        }
        return isRegistered;
    }

    public List<User> getUsersByRole(UserRole userRole) {
        List<User> userList=null;
        Transaction transaction=null;
        Session session=null;
        try{
            session=hibernateUtil.openSession();
            transaction=session.getTransaction();
            transaction.begin();
            userList = userDao.getUsersByRole(userRole, session);
            transaction.commit();
        }
        catch (Exception ex){
            transaction.rollback();
            System.out.println("Sorry! A system error occurred. Could not query database. Contact your system administrator");
            logger.info(this.getClass()+" : Exception in getUsersByRole-method;",ex);
        }
        finally {
            hibernateUtil.closeSession(session);
        }

        return userList;
    }
}
