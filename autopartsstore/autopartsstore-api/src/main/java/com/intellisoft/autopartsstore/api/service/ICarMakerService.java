package com.intellisoft.autopartsstore.api.service;



import com.intellisoft.autopartsstore.entity.CarMaker;
import com.intellisoft.autopartsstore.entity.CarModel;



import java.util.List;

/**
 * Autoparts store project.
 * Author: Solovjev Sergey
 */
public interface ICarMakerService {
    public void saveCarMaker(CarMaker carMaker);

    public void updateCarMaker(CarMaker carMaker);

    public void deleteCarMaker(CarMaker carMaker);

    public CarMaker getCarMakerById(Integer id);

    public List<CarMaker> getAllCarMakers();

    public List<CarModel> getCarModelsByCarMaker(CarMaker carMaker);



}
