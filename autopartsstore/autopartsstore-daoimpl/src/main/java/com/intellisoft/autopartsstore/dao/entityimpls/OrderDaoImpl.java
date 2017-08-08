package com.intellisoft.autopartsstore.dao.entityimpls;

import com.intellisoft.autopartsstore.dao.entitydao.IOrderDao;
import com.intellisoft.autopartsstore.dao.genericdaoimpl.GenericDaoImpl;
import com.intellisoft.autopartsstore.entitys.CarModel;
import com.intellisoft.autopartsstore.entitys.Order;
import com.intellisoft.autopartsstore.entitys.User;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by Сирожа и Маха on 04.08.2017.
 */
public class OrderDaoImpl extends GenericDaoImpl<Order,Integer> implements IOrderDao{
    public OrderDaoImpl(){super(Order.class);}
    private final Class clazz=Order.class;



    public Order getOrderByNumber(Integer number, Session session) throws Exception {
        Criteria criteria = session.createCriteria(clazz);
        criteria.add(Restrictions.eq("number",number));
        return (Order) criteria.list().get(0);
    }

    public List<Order> getOrdersByUser(User user, Session session) throws Exception {
        Criteria criteria = session.createCriteria(clazz);
        criteria.add(Restrictions.eq("user",user));

        return (List<Order>)criteria.list().get(0);
    }
}
