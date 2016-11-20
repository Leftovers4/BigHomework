package data.datahelper.datahelperfactory;

import data.datahelper.hoteldatahelper.HotelDataHelper;
import data.datahelper.orderdatahelper.OrderDataHelper;
import data.datahelper.personneldatahelper.PersonnelDataHelper;
import data.datahelper.promotiondatahelper.PromotionDataHelper;
import data.datahelper.userdatahelper.UserDataHelper;


/**
 * Created by Hiki on 11/20/2016.
 */
public interface DataHelperFactory {

    public HotelDataHelper getHotelDataHelper();

    public OrderDataHelper getOrderDataHelper();

    public PersonnelDataHelper getPersonnelDataHelper();

    public PromotionDataHelper getPromotionDataHelper();

    public UserDataHelper getUserDataHelper();


}
