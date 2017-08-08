package com.intellisoft.autopartsstore.dao.entityimpls;

import com.intellisoft.autopartsstore.dao.entitydao.IUserRoleDao;
import com.intellisoft.autopartsstore.dao.genericdaoimpl.GenericDaoImpl;
import com.intellisoft.autopartsstore.entitys.User;
import com.intellisoft.autopartsstore.entitys.UserRole;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by Сирожа и Маха on 04.08.2017.
 */
public class UserRoleDaoImpl extends GenericDaoImpl<UserRole,Integer> implements IUserRoleDao {
    public UserRoleDaoImpl(){super(UserRole.class);}
    private final Class clazz=UserRole.class;

    }

