package data.datahelper.datahelperfactory;

import data.datahelper.hoteldatahelper.HotelDataHelper;
import data.datahelper.hoteldatahelper.HotelDataHelperImpl;
import data.datahelper.orderdatahelper.OrderDataHelper;
import data.datahelper.orderdatahelper.OrderDataHelperImpl;
import data.datahelper.personneldatahelper.PersonnelDataHelper;
import data.datahelper.personneldatahelper.PersonnelDataHelperImpl;
import data.datahelper.promotiondatahelper.PromotionDataHelper;
import data.datahelper.promotiondatahelper.PromotionDataHelperImpl;
import data.datahelper.userdatahelper.UserDataHelper;
import data.datahelper.userdatahelper.UserDataHelperImpl;

/**
 * Created by Hiki on 11/20/2016.
 */
public class DataHelperFactoryImpl implements DataHelperFactory{


    @Override
    public HotelDataHelper getHotelDataHelper() {
        return new HotelDataHelperImpl();
    }

    @Override
    public OrderDataHelper getOrderDataHelper() {
        return new OrderDataHelperImpl();
    }

    @Override
    public PersonnelDataHelper getPersonnelDataHelper() {
        return new PersonnelDataHelperImpl();
    }

    @Override
    public PromotionDataHelper getPromotionDataHelper() {
        return new PromotionDataHelperImpl();
    }

    @Override
    public UserDataHelper getUserDataHelper() {
        return new UserDataHelperImpl();
    }
}
