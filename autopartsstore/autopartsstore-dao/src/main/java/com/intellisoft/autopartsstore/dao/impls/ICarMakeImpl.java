package com.intellisoft.autopartsstore.dao.impls;

import com.intellisoft.autopartsstore.api.AbstarctDao;
import com.intellisoft.autopartsstore.entitys.CarMake;

import java.io.Serializable;

/**
 * Created by Сирожа и Маха on 02.08.2017.
 */
public class ICarMakeImpl extends AbstarctDao<CarMake> {
    public ICarMakeImpl() {setClazz(CarMake.class);
    }
}
