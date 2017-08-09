package com.intellisoft.autopartsstore.api.service;



import com.intellisoft.autopartsstore.entity.Order;
import com.intellisoft.autopartsstore.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;


import java.util.List;

/**
 * Autoparts store project.
 * Author: Solovjev Sergey
 */
public interface IOrderService {

    public void saveOrder(Order order);

    public void updateOrder(Order order);

    public void deleteOrder(Order order);

    public Order getOrderById(Integer id);

    public Order getOrderByNumber(Integer number);

    public List<Order> getOrdersByUser(User user);

    public List<Order> getAllOrders();



}
