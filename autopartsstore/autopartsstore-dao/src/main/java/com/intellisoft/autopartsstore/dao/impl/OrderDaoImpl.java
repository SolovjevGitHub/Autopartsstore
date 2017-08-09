package com.intellisoft.autopartsstore.dao.impl;

import com.intellisoft.autopartsstore.api.entity.IOrderDao;
import com.intellisoft.autopartsstore.entity.Order;
import com.intellisoft.autopartsstore.entity.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by Сирожа и Маха on 04.08.2017.
 */
public class OrderDaoImpl extends GenericDaoImpl<Order, Integer> implements IOrderDao {
    public OrderDaoImpl() {
        super(Order.class);
    }


    public Order getOrderByNumber(Integer number, Session session) throws Exception {
        Criteria criteria = session.createCriteria(Order.class);
        criteria.add(Restrictions.eq("number", number));
        return (Order) criteria.list().get(0);
    }

    public List<Order> getOrdersByUser(User user, Session session) throws Exception {
        Criteria criteria = session.createCriteria(Order.class);
        criteria.add(Restrictions.eq("user", user));

        return (List<Order>) criteria.list().get(0);
    }
}
