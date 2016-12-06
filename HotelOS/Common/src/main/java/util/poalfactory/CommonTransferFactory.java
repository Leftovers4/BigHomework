package util.poalfactory;

import util.TableName;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Hiki on 11/26/2016.
 */
public interface CommonTransferFactory {


    /**
     * 将List<Object>转换成Iterator<Object>
     * @param als
     * @return
     */
    public Iterator<Object> alToItr(List<Object> als);


    /**
     * 将List<List<Object>>转换成Iterator<Iterator<Object>>
     * @return
     */
    public Iterator<Iterator<Object>> alsToItrs(List<ArrayList<Object>> als);


    // TODO: not used
    /**
     * 将传入的al对象转换成能够被数据库查询，默认值要改成'%'
     * @param conditionAl
     * @param tableName
     * @return
     */
    public ArrayList<Object> adaptToSQL(List<Object> conditionAl, TableName tableName);


}
