package com.intellisoft.autopartsstore.dao.impl;

import com.intellisoft.autopartsstore.api.entity.IUserDao;
import com.intellisoft.autopartsstore.entity.User;
import com.intellisoft.autopartsstore.entity.UserRole;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by Сирожа и Маха on 04.08.2017.
 */
public class UserDaoImpl extends GenericDaoImpl<User, Integer> implements IUserDao {
    private Class clazz = User.class;

    public UserDaoImpl() {
        super(User.class);
    }


    public Boolean userIsRegistered(User user, Session session) throws Exception {
        Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.eq("email", user.getEmail()));

        if (criteria.list().size() > 0) {
            return true;
        } else return false;

    }

    public List<User> getUsersByRole(UserRole userRole, Session session) throws Exception {
        Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.eq("userRole", userRole));

        return (List<User>) criteria.list().get(0);
    }
}
