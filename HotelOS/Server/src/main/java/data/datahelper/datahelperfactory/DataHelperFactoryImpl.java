package data.datahelper.datahelperfactory;

import data.datahelper.hoteldatahelper.*;
import data.datahelper.orderdatahelper.OrderDataHelper;
import data.datahelper.orderdatahelper.OrderDataHelperImpl;
import data.datahelper.personneldatahelper.PersonnelDataHelper;
import data.datahelper.personneldatahelper.PersonnelDataHelperImpl;
import data.datahelper.promotiondatahelper.PromotionDataHelper;
import data.datahelper.promotiondatahelper.PromotionDataHelperImpl;
import data.datahelper.userdatahelper.*;

/**
 * Created by Hiki on 11/20/2016.
 */
public class DataHelperFactoryImpl implements DataHelperFactory{


    @Override
    public HotelDataHelper getHotelDataHelper() {
        return new HotelDataHelperImpl();
    }

    @Override
    public RoomDataHelper getRoomDataHelper() {
        return new RoomDataHelperImpl();
    }

    @Override
    public HotelImageHelper getHotelImageHelper() {
        return new HotelImageHelperImpl();
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

    @Override
    public CreditRecordDataHelper getCreditRecordDataHelper() {
        return new CreditRecordDataHelperImpl();
    }

    @Override
    public UserImageHelper getUserImageHelper() {
        return new UserImageHelperImpl();
    }
}
