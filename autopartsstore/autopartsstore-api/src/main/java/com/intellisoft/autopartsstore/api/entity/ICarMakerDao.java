package com.intellisoft.autopartsstore.api.entity;

import com.intellisoft.autopartsstore.api.dao.IGenericDao;
import com.intellisoft.autopartsstore.entity.CarMaker;
import com.intellisoft.autopartsstore.entity.CarModel;
import org.hibernate.Session;

import java.util.List;

/**
 * Autoparts store project.
 * Author: Solovjev Sergey
 */
public interface ICarMakerDao extends IGenericDao<CarMaker,Integer> {
    public List<CarModel> getCarModelsByCarMaker(CarMaker carMaker, Session session) throws Exception;

}
