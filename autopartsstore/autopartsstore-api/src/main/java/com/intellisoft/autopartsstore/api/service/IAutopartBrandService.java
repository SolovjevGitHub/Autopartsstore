package com.intellisoft.autopartsstore.api.service;

import com.intellisoft.autopartsstore.entity.Autopart;
import com.intellisoft.autopartsstore.entity.AutopartBrand;
import com.intellisoft.autopartsstore.entity.User;


import java.util.List;

/**
 * Autoparts store project.
 * Author: Solovjev Sergey
 */
public interface IAutopartBrandService {

    public void saveAutopartBrand(AutopartBrand autopartBrand);

    public void updateAutopartBrand(AutopartBrand autopartBrand);

    public void deleteAutopartBrand(AutopartBrand autopartBrand);

    public AutopartBrand getAutopartBrandById(Integer id);

    public List<AutopartBrand> getAllAutopartBrands();

    public List<Autopart> getAutopartsByAutopartBrand(AutopartBrand autopartBrand);


}
