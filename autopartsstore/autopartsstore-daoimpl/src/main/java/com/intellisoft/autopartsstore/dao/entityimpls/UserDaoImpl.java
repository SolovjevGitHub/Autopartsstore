package com.intellisoft.autopartsstore.dao.entityimpls;

import com.intellisoft.autopartsstore.dao.entitydao.IUserDao;
import com.intellisoft.autopartsstore.dao.entitydao.IUserRoleDao;
import com.intellisoft.autopartsstore.dao.genericdaoimpl.GenericDaoImpl;
import com.intellisoft.autopartsstore.entitys.Order;
import com.intellisoft.autopartsstore.entitys.User;
import com.intellisoft.autopartsstore.entitys.UserRole;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by Сирожа и Маха on 04.08.2017.
 */
public class UserDaoImpl extends GenericDaoImpl<User,Integer> implements IUserDao {
    private  Class clazz=User.class;
    public UserDaoImpl(){super(User.class);}


    public List<User> getUsersByRole(UserRole userRole, Session session) throws Exception {
        Criteria criteria = session.createCriteria(clazz);
        criteria.add(Restrictions.eq("userRole", userRole));

        return (List<User>) criteria.list();
    }

    public User getUserByFirstName(String firstName, Session session) throws Exception {
        Criteria criteria = session.createCriteria(clazz);
        criteria.add(Restrictions.eq("firstName",firstName));

        return (User) criteria.list().get(0);    }

    public User getUserByLastName(String lastName, Session session) throws Exception {
        Criteria criteria = session.createCriteria(clazz);
        criteria.add(Restrictions.eq("lastName",lastName));

        return (User) criteria.list().get(0);
    }

    public Boolean userIsRegistered(User user, Session session) throws Exception {
        Criteria criteria = session.createCriteria(clazz);
        criteria.add(Restrictions.and(Restrictions.eq("firstName", user.getFirstName()),(Restrictions.eq("lastName", user.getLastName()))));
        if(criteria.list().size()>0){
            return true;
        }else return false;

    }
}
