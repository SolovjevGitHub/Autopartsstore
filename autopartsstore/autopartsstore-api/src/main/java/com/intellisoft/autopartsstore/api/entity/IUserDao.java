package com.intellisoft.autopartsstore.api.entity;

import com.intellisoft.autopartsstore.api.dao.IGenericDao;
import com.intellisoft.autopartsstore.entity.User;
import com.intellisoft.autopartsstore.entity.UserRole;
import org.hibernate.Session;

import java.util.List;

/**
 * Autoparts store project.
 * Author: Solovjev Sergey
 */
public interface IUserDao extends IGenericDao<User,Integer> {


    public Boolean userIsRegistered(User user, Session session) throws Exception;
    public List<User> getUsersByRole(UserRole userRole, Session session) throws Exception;

}
