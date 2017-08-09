package com.intellisoft.autopartsstore.api.service;

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
public interface IAutopartService {
    public void saveAutopart(Autopart autopart);

    public void updateAutopart(Autopart autopart);

    public void deleteAutopart(Autopart autopart);

    public Autopart getAutopartById(Integer id);

    public List<Autopart> getAllAutoparts();

    public Autopart getAutopartByPartNumber(String partNumber);

    public List<Autopart> getAutopartsByAutopartCategorie(AutopartCategorie autopartCategorie);

    public List<Autopart> getAutopartsByCarModel(CarModel carModel);

    public List<Autopart> getAutopartsByAutopartBrand(AutopartBrand autopartBrand);



}
