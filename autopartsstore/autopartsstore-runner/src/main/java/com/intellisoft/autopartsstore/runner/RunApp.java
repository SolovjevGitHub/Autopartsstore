package com.intellisoft.autopartsstore.runner;

import com.intellisoft.autopartsstore.entitys.CarMake;
import com.intellisoft.autopartsstore.service.entityservices.CarMakeService;

/**
 * Created by Сирожа и Маха on 01.08.2017.
 */
public class RunApp {
    public static void main(String[] args) {
        CarMakeService carMakeService=new CarMakeService();
       // carMakeService.getById(2);
      // carMakeService.getAll();
        CarMake carMake=carMakeService.getById(-5);






    }
}
