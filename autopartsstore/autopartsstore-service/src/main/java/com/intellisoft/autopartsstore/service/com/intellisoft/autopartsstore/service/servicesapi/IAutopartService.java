package com.intellisoft.autopartsstore.service.com.intellisoft.autopartsstore.service.servicesapi;

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
public interface IAutopartService {
    public Autopart getAutopartByPartNumber(String partNumber);
    public List<Autopart> getAutopartsByAutopartBrand(AutopartBrand autopartBrand);
    public List<Autopart> getAutopartsByAutopartCategorie(AutopartCategorie autopartCategorie);
    public List<Autopart> getAutopartsByCarModel(CarModel carModel);
}
