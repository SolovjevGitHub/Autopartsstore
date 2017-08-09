package com.intellisoft.autopartsstore.api.entity;

import com.intellisoft.autopartsstore.api.dao.IGenericDao;
import com.intellisoft.autopartsstore.entity.CarModel;
import org.hibernate.Session;

import java.util.List;

/**
 * Autoparts store project.
 * Author: Solovjev Sergey
 */
public interface ICarModelDao extends IGenericDao<CarModel, Integer> {

    public List<CarModel> getCarModelsByBodyCode(String code, Session session) throws Exception;
    public List<CarModel> getCarModelsByEngineType(String engineType, Session session) throws Exception;
    public List<CarModel> getCarModelsByYearFrom(Integer yearFrom, Session session) throws Exception;
    public List<CarModel> getCarModelsByYearTo(Integer yearTo, Session session) throws Exception;

}
