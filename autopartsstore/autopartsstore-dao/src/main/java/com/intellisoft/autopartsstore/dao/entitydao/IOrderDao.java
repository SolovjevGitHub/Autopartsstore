package com.intellisoft.autopartsstore.dao.entitydao;

import com.intellisoft.autopartsstore.dao.genecricdao.IGenericDao;
import com.intellisoft.autopartsstore.entitys.Order;
import com.intellisoft.autopartsstore.entitys.User;
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
