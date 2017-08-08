package com.intellisoft.autopartsstore.runner;

import com.intellisoft.autopartsstore.dao.entityimpls.CarModelDaoImpl;
import com.intellisoft.autopartsstore.dao.hibernateutil.HibernateUtil;
import com.intellisoft.autopartsstore.entitys.CarModel;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 * Created by Сирожа и Маха on 01.08.2017.
 */
public class RunApp {
    public static void main(String[] args) throws Exception {
       // AutopartBrandServiceImpl autopartBrandService=new AutopartBrandServiceImpl();
        //AutopartCategorieServiceImpl autopartCategorieService=new AutopartCategorieServiceImpl();
        //AutopartServiceImpl autopartService=new AutopartServiceImpl();
        //CarMakeServiceImpl carMakeService=new CarMakeServiceImpl();
        //CarModelServiceImpl carModelService=new CarModelServiceImpl();
        //OrderServiceImpl orderService=new OrderServiceImpl();
        //UserRoleServiceImpl userRoleService=new UserRoleServiceImpl();
        //UserServiceImpl userService=new UserServiceImpl();

        /**CarMake*/


        //CarMake carMake=new CarMake();
        //System.out.println(carMakeService.getCarMakeByName("KIA").toString());

                /**saveCarMake*/
        //carMake.setName("VolksWagen");
        //carMakeService.saveCarMake(carMake);
                /**getCarMakeById*/
        //carMake=carMakeService.getCarMakeById(3);
        //System.out.println(carMake.toString());
                /**deleteCarMake*/
        //carMake=carMakeService.getCarMakeById(3);
        //carMakeService.deleteCarMake(carMake);
                /**updateCarMake*/
        //carMake=carMakeService.getCarMakeById(15);
        //carMake.setName("DAIHATSU");
        //carMakeService.updateCarMake(carMake);
                /**getAllCarMakes*/
        //List<CarMake> carMakeList=carMakeService.getAllCarMakes();
        //for(CarMake carMake:carMakeList){
        // System.out.println(carMake.toString());        }

        CarModelDaoImpl carModelDao=new CarModelDaoImpl();
        Session session=HibernateUtil.getInstance().openSession();
        Transaction transaction=session.getTransaction();
        transaction.begin();
        Criteria criteria = session.createCriteria(CarModel.class);
        criteria.add(Restrictions.eq("bodyCode","a4b5"));
        System.out.println(criteria.list().size());
        transaction.commit();
        session.close();











    }
}
