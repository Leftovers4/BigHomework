package data.dao._poalfactory;

import java.awt.image.AreaAveragingScaleFilter;
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
    public Iterator<Object> alToItr(ArrayList<Object> als);


    /**
     * 将List<List<Object>>转换成Iterator<Iterator<Object>>
     * @return
     */
    public Iterator<Iterator<Object>> alsToItrs(ArrayList<ArrayList<Object>> als);

}
