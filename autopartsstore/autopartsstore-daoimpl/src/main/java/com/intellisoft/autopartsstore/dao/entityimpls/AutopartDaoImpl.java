package com.intellisoft.autopartsstore.dao.entityimpls;

import com.intellisoft.autopartsstore.dao.entitydao.IAutopartDao;
import com.intellisoft.autopartsstore.dao.genericdaoimpl.GenericDaoImpl;
import com.intellisoft.autopartsstore.entitys.Autopart;
import com.intellisoft.autopartsstore.entitys.AutopartBrand;
import com.intellisoft.autopartsstore.entitys.AutopartCategorie;
import com.intellisoft.autopartsstore.entitys.CarModel;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by Сирожа и Маха on 04.08.2017.
 */
public class AutopartDaoImpl extends GenericDaoImpl<Autopart,Integer> implements IAutopartDao {
    public AutopartDaoImpl(){super(Autopart.class);}

    private final Class clazz=Autopart.class;


    public Autopart getAutopartByPartNumber(String partNumber, Session session) throws Exception {
        Criteria criteria = session.createCriteria(clazz);
        criteria.add(Restrictions.eq("partNumber",partNumber));
        return (Autopart)criteria.list().get(0);
    }

    public List<Autopart> getAutopartsByAutopartBrand(AutopartBrand autopartBrand, Session session) throws Exception {
        Criteria criteria = session.createCriteria(clazz);
        criteria.add(Restrictions.eq("autopartBrand",autopartBrand));
        return (List<Autopart>)criteria.list();
    }

    public List<Autopart> getAutopartsByAutopartCategorie(AutopartCategorie autopartCategorie, Session session) throws Exception {
        Criteria criteria = session.createCriteria(clazz);
        criteria.add(Restrictions.eq("autopartCategories",autopartCategorie));
        return (List<Autopart>)criteria.list();
    }

    public List<Autopart> getAutopartsByCarModel(CarModel carModel, Session session) throws Exception {
        Criteria criteria = session.createCriteria(clazz);
        criteria.add(Restrictions.eq("carModel",carModel));
        return (List<Autopart>)criteria.list();
    }
}
