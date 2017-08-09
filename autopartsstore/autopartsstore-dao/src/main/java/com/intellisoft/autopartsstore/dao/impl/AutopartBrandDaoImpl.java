package com.intellisoft.autopartsstore.dao.impl;

import com.intellisoft.autopartsstore.api.entity.IAutopartBrandDao;
import com.intellisoft.autopartsstore.entity.Autopart;
import com.intellisoft.autopartsstore.entity.AutopartBrand;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;


public class AutopartBrandDaoImpl extends GenericDaoImpl<AutopartBrand,Integer> implements IAutopartBrandDao {
   public AutopartBrandDaoImpl() {
        super(AutopartBrand.class);
    }


    public List<Autopart> getAutopartsByAutopartBrand(AutopartBrand autopartBrand, Session session) throws Exception {
        Criteria criteria = session.createCriteria(Autopart.class);
        criteria.add(Restrictions.eq("autopartBrand",autopartBrand));
        return (List<Autopart>)criteria.list();

    }
}
