package com.intellisoft.autopartsstore.dao.entityimpls;

import com.intellisoft.autopartsstore.dao.entitydao.IAutopartBrandDao;
import com.intellisoft.autopartsstore.dao.genericdaoimpl.GenericDaoImpl;
import com.intellisoft.autopartsstore.entitys.AutopartBrand;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 * Created by Сирожа и Маха on 04.08.2017.
 */
public class AutopartBrandDaoImpl extends GenericDaoImpl<AutopartBrand,Integer> implements IAutopartBrandDao {
   public AutopartBrandDaoImpl(Class<AutopartBrand> clazz) {
        super(clazz);
    }
    private final Class clazz=AutopartBrand.class;


}
