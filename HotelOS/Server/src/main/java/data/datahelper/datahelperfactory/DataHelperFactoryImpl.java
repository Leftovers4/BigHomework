package data.datahelper.datahelperfactory;

import data.datahelper.hoteldatahelper.HotelDataHelper;
import data.datahelper.orderdatahelper.OrderDataHelper;
import data.datahelper.personneldatahelper.PersonnelDataHelper;
import data.datahelper.promotiondatahelper.PromotionDataHelper;
import data.datahelper.userdatahelper.UserDataHelper;

/**
 * Created by Hiki on 11/20/2016.
 */
public class DataHelperFactoryImpl implements DataHelperFactory{


    @Override
    public HotelDataHelper getHotelDataHelper() {
       return null;
    }

    @Override
    public OrderDataHelper getOrderDataHelper() {
        return null;
    }

    @Override
    public PersonnelDataHelper getPersonnelDataHelper() {
        return null;
    }

    @Override
    public PromotionDataHelper getPromotionDataHelper() {
        return null;
    }

    @Override
    public UserDataHelper getUserDataHelper() {
        return null;
    }
}
