package com.intellisoft.autopartsstore.api.entity;

import com.intellisoft.autopartsstore.api.dao.IGenericDao;
import com.intellisoft.autopartsstore.entity.Order;
import com.intellisoft.autopartsstore.entity.User;
import org.hibernate.Session;

import java.util.List;

/**
 * Autoparts store project.
 * Author: Solovjev Sergey
 */
public interface IOrderDao extends IGenericDao<Order,Integer> {
    public Order getOrderByNumber(Integer number, Session session) throws  Exception;
    public List<Order> getOrdersByUser(User user, Session session) throws Exception;

}
