package com.intellisoft.autopartsstore.api.entity;

import com.intellisoft.autopartsstore.api.dao.IGenericDao;
import com.intellisoft.autopartsstore.entity.Autopart;
import com.intellisoft.autopartsstore.entity.AutopartBrand;
import org.hibernate.Session;

import java.util.List;


/**
 * Autoparts store project.
 * Author: Solovjev Sergey
 */
public interface IAutopartBrandDao extends IGenericDao<AutopartBrand,Integer> {
    public List<Autopart> getAutopartsByAutopartBrand(AutopartBrand autopartBrand, Session session) throws Exception;

}
