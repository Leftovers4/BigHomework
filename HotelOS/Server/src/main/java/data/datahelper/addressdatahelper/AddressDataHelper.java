package data.datahelper.addressdatahelper;

import data.datahelper.DataHelperParent;
import util.TableName;

import java.util.ArrayList;

/**
 * Created by Hiki on 12/10/2016.
 */
public interface AddressDataHelper{

    /**
     * 在address表中查找所有城市列表
     * @return
     */
    public ArrayList<String> findAllCities();

    /**
     * 根据城市名查找对应的商圈列表
     * @param city
     * @return
     */
    public ArrayList<String> findTradingAreaByCity(String city);



}
