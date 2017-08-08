package com.intellisoft.autopartsstore.dao.entitydao;

import com.intellisoft.autopartsstore.dao.genecricdao.IGenericDao;
import com.intellisoft.autopartsstore.entitys.Autopart;
import com.intellisoft.autopartsstore.entitys.AutopartBrand;
import com.intellisoft.autopartsstore.entitys.AutopartCategorie;
import com.intellisoft.autopartsstore.entitys.CarModel;
import org.hibernate.Session;

import java.util.List;

/**
 * Autoparts store project.
 * Author: Solovjev Sergey
 */
public interface IAutopartDao extends IGenericDao<Autopart,Integer> {

    public Autopart getAutopartByPartNumber(String partNumber, Session session) throws Exception;
    public List<Autopart> getAutopartsByAutopartBrand(AutopartBrand autopartBrand, Session session) throws Exception;
    public List<Autopart> getAutopartsByAutopartCategorie(AutopartCategorie autopartCategorie, Session session) throws Exception;
    public List<Autopart> getAutopartsByCarModel(CarModel carModel, Session session) throws Exception;
}
