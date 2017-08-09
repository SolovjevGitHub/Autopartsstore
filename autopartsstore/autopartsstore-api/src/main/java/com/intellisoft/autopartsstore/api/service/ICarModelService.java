package com.intellisoft.autopartsstore.api.service;




import com.intellisoft.autopartsstore.entity.CarModel;


import java.util.List;

/**
 * Autoparts store project.
 * Author: Solovjev Sergey
 */
public interface ICarModelService {
    public void saveCarModel(CarModel carModel);

    public void updateCarModel(CarModel carModel);

    public void deleteCarModel(CarModel carModel);

    public CarModel getCarModelById(Integer id);

    public List<CarModel> getAllCarModels();

    public List<CarModel> getCarModelsByBodyCode(String code);

    public List<CarModel> getCarModelsByEngineType(String engineType);

    public List<CarModel> getCarModelsByYearFrom(Integer yearFrom);

    public List<CarModel> getCarModelsByYearTo(Integer yearTo);
}
