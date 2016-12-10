package data.datahelper.addressdatahelper;

import data.datahelper.DataHelperParent;
import util.TableName;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Hiki on 12/10/2016.
 */
public class AddressDataHelperImpl extends DataHelperParent implements AddressDataHelper {

    // 格式："city", "trading_area"

    private static final String ADDRESS_TABLENAME = TableName.address.toString();

    @Override
    public ArrayList<String> findAllCities() {

        String sql = "select distinct city from " + ADDRESS_TABLENAME;

        return sqlFind(sql);

    }

    @Override
    public ArrayList<String> findTradingAreaByCity(String city) {

        String sql = "select distinct trading_area from " + ADDRESS_TABLENAME + " where city=\"" + city + "\"";

        return sqlFind(sql);
    }




    private ArrayList<String> sqlFind(String sql){
        // 创建存放结果的容器
        ArrayList<String> resultContent = new ArrayList<>();

        try {

            preparedStatement = conn.prepareStatement(sql);

            System.out.println(preparedStatement.toString());

            resultSet = preparedStatement.executeQuery();

            resultContent = this.getInfoFromResultSet(resultSet);

        } catch (SQLException e) {
            // TODO 以后要注释掉
//            e.printStackTrace();
        }

        return resultContent;


    }




    /*----------------------------------------------------辅助类------------------------------------------- */
    private ArrayList<String> getInfoFromResultSet(ResultSet resultSet){
        // 创建存放结果的容器
        ArrayList<String> resultContent = new ArrayList<>();

        try {
            while (resultSet.next()){
               String result = resultSet.getString(1);
               resultContent.add(result);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultContent;
    }

    }


