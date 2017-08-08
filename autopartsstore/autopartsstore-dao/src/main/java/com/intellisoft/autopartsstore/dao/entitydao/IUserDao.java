package com.intellisoft.autopartsstore.dao.entitydao;

import com.intellisoft.autopartsstore.dao.genecricdao.IGenericDao;
import com.intellisoft.autopartsstore.entitys.User;
import com.intellisoft.autopartsstore.entitys.UserRole;
import org.hibernate.Session;

import java.util.List;

/**
 * Autoparts store project.
 * Author: Solovjev Sergey
 */
public interface IUserDao extends IGenericDao<User,Integer> {

    public User getUserByFirstName(String firstName, Session session) throws Exception;
    public User getUserByLastName(String lastName, Session session) throws Exception;
    public Boolean userIsRegistered(User user, Session session) throws Exception;
    public List<User> getUsersByRole(UserRole userRole, Session session) throws Exception;

}
