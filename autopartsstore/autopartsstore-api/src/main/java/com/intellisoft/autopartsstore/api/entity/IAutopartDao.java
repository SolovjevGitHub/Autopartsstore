package com.intellisoft.autopartsstore.api.entity;

import com.intellisoft.autopartsstore.api.dao.IGenericDao;
import com.intellisoft.autopartsstore.entity.Autopart;
import com.intellisoft.autopartsstore.entity.AutopartBrand;
import com.intellisoft.autopartsstore.entity.AutopartCategorie;
import com.intellisoft.autopartsstore.entity.CarModel;
import org.hibernate.Session;

import java.util.List;

/**
 * Autoparts store project.
 * Author: Solovjev Sergey
 */
public interface IAutopartDao extends IGenericDao<Autopart,Integer> {

    public Autopart getAutopartByPartNumber(String partNumber, Session session) throws Exception;
    public List<Autopart> getAutopartsByAutopartCategorie(AutopartCategorie autopartCategorie, Session session) throws Exception;
    public List<Autopart> getAutopartsByCarModel(CarModel carModel, Session session) throws Exception;
    public List<Autopart> getAutopartsByAutopartBrand(AutopartBrand autopartBrand, Session session)throws Exception;
    }

