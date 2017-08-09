package com.intellisoft.autopartsstore.dao.impl;

import com.intellisoft.autopartsstore.api.entity.ICarMakerDao;
import com.intellisoft.autopartsstore.entity.CarMaker;
import com.intellisoft.autopartsstore.entity.CarModel;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by Сирожа и Маха on 02.08.2017.
 */
public class CarMakerDaoImpl extends GenericDaoImpl<CarMaker,Integer> implements ICarMakerDao {
    public CarMakerDaoImpl() {super(CarMaker.class);}

    public List<CarModel> getCarModelsByCarMaker(CarMaker carMaker, Session session) throws Exception {
        Criteria criteria = session.createCriteria(CarModel.class);
        criteria.add(Restrictions.eq("carMaker",carMaker));

        return (List<CarModel>)criteria.list();
    }
}
