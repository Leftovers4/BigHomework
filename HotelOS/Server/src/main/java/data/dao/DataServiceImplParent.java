package data.dao;

import data.dao._poalfactory.Al2Po_Factory;
import data.dao._poalfactory.CommonTransferFactory;
import data.dao._poalfactory.Po2Al_Factory;
import data.dao._poalfactory.impl.Al2Po_FactoryImpl;
import data.dao._poalfactory.impl.CommonTransferFactoryImpl;
import data.dao._poalfactory.impl.Po2Al_FactoryImpl;
import data.datahelper.datahelperfactory.DataHelperFactory;
import data.datahelper.datahelperfactory.DataHelperFactoryImpl;


/**
 * Created by Hiki on 11/30/2016.
 */
public class DataServiceImplParent {

    // 需要调用的辅助转换类
    protected CommonTransferFactory ctFactory;

    protected Al2Po_Factory apFactory;

    protected Po2Al_Factory paFactory;

    protected DataHelperFactory dhFactory;

    public DataServiceImplParent(){
        this.ctFactory = new CommonTransferFactoryImpl();
        this.apFactory = new Al2Po_FactoryImpl();
        this.paFactory = new Po2Al_FactoryImpl();
        this.dhFactory = new DataHelperFactoryImpl();


    }





}
