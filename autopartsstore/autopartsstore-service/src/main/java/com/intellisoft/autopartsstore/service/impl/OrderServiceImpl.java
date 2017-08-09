package com.intellisoft.autopartsstore.service.impl;

import com.intellisoft.autopartsstore.api.entity.IOrderDao;
import com.intellisoft.autopartsstore.api.service.IOrderService;
import com.intellisoft.autopartsstore.dao.impl.OrderDaoImpl;
import com.intellisoft.autopartsstore.entity.User;
import com.intellisoft.autopartsstore.service.utils.HibernateUtil;
import com.intellisoft.autopartsstore.entity.Order;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;


public class OrderServiceImpl implements IOrderService{
    private static Logger logger=Logger.getLogger(OrderServiceImpl.class);
    private HibernateUtil hibernateUtil=HibernateUtil.getInstance();
    private IOrderDao orderDao;

    public OrderServiceImpl() {
        this.orderDao = new OrderDaoImpl();
    }

    public Order getOrderById(Integer id){
        Order order=null;
        Transaction transaction=null;
        Session session=null;
        try{
            session=hibernateUtil.openSession();
            transaction=session.getTransaction();
            transaction.begin();
            order = orderDao.getById(id, session);
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

        return order;
    }
    public void deleteOrder(Order order){
        Transaction transaction=null;
        Session session=null;
        try{
            session=hibernateUtil.openSession();
            transaction=session.getTransaction();
            transaction.begin();
            orderDao.delete(order, session);
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
    public List<Order> getAllOrders(){
        List<Order> orderList=null;
        Transaction transaction=null;
        Session session=null;
        try{
            session=hibernateUtil.openSession();
            transaction=session.getTransaction();
            transaction.begin();
             orderList = orderDao.getAll(session);
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

        return orderList;
    }
    public void saveOrder(Order order){
        Transaction transaction=null;
        Session session=null;
        try{
            session=hibernateUtil.openSession();
            transaction=session.getTransaction();
            transaction.begin();
            orderDao.save(order, session);
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
    public void updateOrder(Order order){

        Transaction transaction=null;
        Session session=null;
        try{
            session=hibernateUtil.openSession();
            transaction=session.getTransaction();
            transaction.begin();
            orderDao.update(order, session);
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

    public Order getOrderByNumber(Integer number) {
        Order order=null;
        Transaction transaction=null;
        Session session=null;
        try{
            session=hibernateUtil.openSession();
            transaction=session.getTransaction();
            transaction.begin();
            order = orderDao.getOrderByNumber(number, session);
            transaction.commit();
        }
        catch (Exception ex){
            transaction.rollback();
            System.out.println("Sorry! A system error occurred. Could not query database. Contact your system administrator");
            logger.info(this.getClass()+" : Exception in getOrderByNumber-method;",ex);
        }
        finally {
            hibernateUtil.closeSession(session);
        }

        return order;
    }

    public List<Order> getOrdersByUser(User user) {
        List<Order> orderList=null;
        Transaction transaction=null;
        Session session=null;
        try{
            session=hibernateUtil.openSession();
            transaction=session.getTransaction();
            transaction.begin();
            orderList = orderDao.getOrdersByUser(user,session);
            transaction.commit();
        }
        catch (Exception ex){
            transaction.rollback();
            System.out.println("Sorry! A system error occurred. Could not query database. Contact your system administrator");
            logger.info(this.getClass()+" : Exception in getOrdersByUserl-method;",ex);
        }
        finally {
            hibernateUtil.closeSession(session);
        }

        return orderList;
    }
}
