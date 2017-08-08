package com.intellisoft.autopartsstore.dao.entityimpls;

import com.intellisoft.autopartsstore.dao.entitydao.ICarMakeDao;
import com.intellisoft.autopartsstore.dao.genericdaoimpl.GenericDaoImpl;

import com.intellisoft.autopartsstore.entitys.Autopart;
import com.intellisoft.autopartsstore.entitys.CarMake;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 * Created by Сирожа и Маха on 02.08.2017.
 */
public class CarMakeDaoImpl extends GenericDaoImpl<CarMake,Integer> implements ICarMakeDao {
    public CarMakeDaoImpl() {
        super(CarMake.class);
    }
    private final Class clazz=CarMake.class;


}
