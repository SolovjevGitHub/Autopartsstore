package com.intellisoft.autopartsstore.service.entityserviceimpls;

import com.intellisoft.autopartsstore.dao.entityimpls.OrderDaoImpl;
import com.intellisoft.autopartsstore.dao.hibernateutil.HibernateUtil;
import com.intellisoft.autopartsstore.entitys.Order;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;


public class OrderServiceImpl {
    private static Logger logger=Logger.getLogger(OrderServiceImpl.class);
    private HibernateUtil hibernateUtil=HibernateUtil.getInstance();
    private OrderDaoImpl orderImpl=new OrderDaoImpl();



    public Order getOrderById(Integer id){
        Order order=null;
        Transaction transaction=null;
        Session session=null;
        try{
            session=hibernateUtil.openSession();
            transaction=session.getTransaction();
            transaction.begin();
            order = orderImpl.getById(id, session);
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

        return order;
    }
    public void deleteOrder(Order order){
        Transaction transaction=null;
        Session session=null;
        try{
            session=hibernateUtil.openSession();
            transaction=session.getTransaction();
            transaction.begin();
            orderImpl.delete(order, session);
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
    public List<Order> getAllOrders(){
        List<Order> orderList=null;
        Transaction transaction=null;
        Session session=null;
        try{
            session=hibernateUtil.openSession();
            transaction=session.getTransaction();
            transaction.begin();
             orderList = orderImpl.getAll(session);
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

        return orderList;
    }
    public void saveOrder(Order order){
        Transaction transaction=null;
        Session session=null;
        try{
            session=hibernateUtil.openSession();
            transaction=session.getTransaction();
            transaction.begin();
            orderImpl.save(order, session);
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
    public void updateOrder(Order order){

        Transaction transaction=null;
        Session session=null;
        try{
            session=hibernateUtil.openSession();
            transaction=session.getTransaction();
            transaction.begin();
            orderImpl.update(order, session);
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
