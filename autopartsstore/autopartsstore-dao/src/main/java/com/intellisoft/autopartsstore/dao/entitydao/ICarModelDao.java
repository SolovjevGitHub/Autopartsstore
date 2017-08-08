package com.intellisoft.autopartsstore.dao.entitydao;

import com.intellisoft.autopartsstore.dao.genecricdao.IGenericDao;
import com.intellisoft.autopartsstore.entitys.CarModel;
import org.hibernate.Session;

import java.util.List;

/**
 * Autoparts store project.
 * Author: Solovjev Sergey
 */
public interface ICarModelDao extends IGenericDao<CarModel, Integer> {

    public List<CarModel> getCarModelsByBodyCode(String code, Session session) throws Exception;
    public List<CarModel> getCarModelsByEngineType(Integer engineType, Session session) throws Exception;
    public List<CarModel> getCarModelsByYearFrom(Integer yearFrom, Session session) throws Exception;
    public List<CarModel> getCarModelsByYearTo(Integer yearTo, Session session) throws Exception;

}
