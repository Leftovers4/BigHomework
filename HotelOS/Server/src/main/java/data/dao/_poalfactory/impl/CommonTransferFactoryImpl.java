package data.dao._poalfactory.impl;

import data.dao._poalfactory.CommonTransferFactory;
import util.DefaultAl;
import util.TableName;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Hiki on 11/26/2016.
 */
public class CommonTransferFactoryImpl implements CommonTransferFactory {


    @Override
    public Iterator<Object> alToItr(List<Object> als) {
        return als.iterator();
    }

    @Override
    public Iterator<Iterator<Object>> alsToItrs(List<ArrayList<Object>> als) {
        List<Iterator<Object>> temp = new ArrayList<>();
        for (List<Object> each : als) {
            temp.add(each.iterator());
        }

        return temp.iterator();

    }

    @Override
    public ArrayList<Object> adaptToSQL(List<Object> conditionAl, TableName tableName) {
        // TODO: 此处可能会产生变更问题，如果表名变了，这个地方必须改动
        switch (tableName.toString()){
            case "hotel":
                return changeDefault(conditionAl, DefaultAl.getHotelDefaultAl());
        }


        System.out.println("Cannot find expected list to adapt to SQL!");
        return null;
    }


    private ArrayList<Object> changeDefault(List<Object> toChangeAl, List<Object> defaultAl){

        // 若两个比较的List长度不相等，返回null，打印日志
        if(toChangeAl.size() != defaultAl.size()){
            System.out.println("Wrong al size to changeDefault!");
            return null;
        }

        // 进行比较，如果相等，则将 '%' 存放到result中
        // 若不相等，则将toChangeAl的当前值存到result中
        ArrayList<Object> result = new ArrayList<>();
        for(int i = 0; i < toChangeAl.size(); i++){
            if(toChangeAl.get(i).equals(defaultAl.get(i))){
                result.add('%');
            }else{
                result.add(toChangeAl.get(i));
            }
        }
        return result;




    }


}
