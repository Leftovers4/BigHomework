package data.dao._poalfactory.impl;

import data.dao._poalfactory.CommonTransferFactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Hiki on 11/26/2016.
 */
public class CommonTransferFactoryImpl implements CommonTransferFactory {


    @Override
    public Iterator<Object> alToItr(ArrayList<Object> als) {
        return als.iterator();
    }

    @Override
    public Iterator<Iterator<Object>> alsToItrs(ArrayList<ArrayList<Object>> als) {
        List<Iterator<Object>> temp = new ArrayList<>();
        for (List<Object> each : als) {
            temp.add(each.iterator());
        }

        return temp.iterator();

    }

}
