package com.intellisoft.autopartsstore.dao.entityimpls;

import com.intellisoft.autopartsstore.dao.entitydao.IAutopartCategorieDao;
import com.intellisoft.autopartsstore.dao.genericdaoimpl.GenericDaoImpl;
import com.intellisoft.autopartsstore.entitys.AutopartBrand;
import com.intellisoft.autopartsstore.entitys.AutopartCategorie;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 * Created by Сирожа и Маха on 04.08.2017.
 */
public class AutopartCategorieDaoImpl extends GenericDaoImpl<AutopartCategorie,Integer> implements IAutopartCategorieDao{
    public AutopartCategorieDaoImpl(){super(AutopartCategorie.class);}
    private final Class clazz=AutopartCategorie.class;

}
