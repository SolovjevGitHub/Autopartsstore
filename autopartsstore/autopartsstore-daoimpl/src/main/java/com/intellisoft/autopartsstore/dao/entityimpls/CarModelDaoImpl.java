package com.intellisoft.autopartsstore.dao.entityimpls;

import com.intellisoft.autopartsstore.dao.entitydao.ICarModelDao;
import com.intellisoft.autopartsstore.dao.genericdaoimpl.GenericDaoImpl;
import com.intellisoft.autopartsstore.entitys.Autopart;
import com.intellisoft.autopartsstore.entitys.CarMake;
import com.intellisoft.autopartsstore.entitys.CarModel;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by Сирожа и Маха on 04.08.2017.
 */
public class CarModelDaoImpl extends GenericDaoImpl<CarModel,Integer> implements ICarModelDao {
    public CarModelDaoImpl(){super(CarModel.class);}
    private final Class clazz=CarModel.class;


    public List<CarModel> getCarModelsByBodyCode(String code, Session session) throws Exception {

        Criteria criteria = session.createCriteria(clazz);
        criteria.add(Restrictions.eq("bodyCode",code));
        return (List<CarModel>)criteria.list();
    }

    public List<CarModel> getCarModelsByEngineType(Integer engineType, Session session) throws Exception {
        Criteria criteria = session.createCriteria(clazz);
        criteria.add(Restrictions.eq("engineType",engineType));
        return (List<CarModel>)criteria.list();
    }

    public List<CarModel> getCarModelsByYearFrom(Integer yearFrom, Session session) throws Exception {
        Criteria criteria = session.createCriteria(clazz);
        criteria.add(Restrictions.eq("yearFrom",yearFrom));
        return (List<CarModel>)criteria.list();
    }

    public List<CarModel> getCarModelsByYearTo(Integer yearTo, Session session) throws Exception {
        Criteria criteria = session.createCriteria(clazz);
        criteria.add(Restrictions.eq("yearTo",yearTo));
        return (List<CarModel>)criteria.list();
    }
}
