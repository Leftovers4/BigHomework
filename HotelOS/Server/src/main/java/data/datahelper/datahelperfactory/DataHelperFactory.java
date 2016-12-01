package data.datahelper.datahelperfactory;

import data.datahelper.hoteldatahelper.HotelDataHelper;
import data.datahelper.hoteldatahelper.HotelImageHelper;
import data.datahelper.hoteldatahelper.RoomDataHelper;
import data.datahelper.orderdatahelper.OrderDataHelper;
import data.datahelper.personneldatahelper.PersonnelDataHelper;
import data.datahelper.promotiondatahelper.PromotionDataHelper;
import data.datahelper.userdatahelper.CreditRecordDataHelper;
import data.datahelper.userdatahelper.UserDataHelper;
import data.datahelper.userdatahelper.UserImageHelper;


/**
 * Created by Hiki on 11/20/2016.
 */
public interface DataHelperFactory {

    // Hotel
    public HotelDataHelper getHotelDataHelper();

    public RoomDataHelper getRoomDataHelper();

    public HotelImageHelper getHotelImageHelper();

    // Order
    public OrderDataHelper getOrderDataHelper();

    // Personnel
    public PersonnelDataHelper getPersonnelDataHelper();

    // Promotion
    public PromotionDataHelper getPromotionDataHelper();

    // User
    public UserDataHelper getUserDataHelper();

    public CreditRecordDataHelper getCreditRecordDataHelper();

    public UserImageHelper getUserImageHelper();
}
