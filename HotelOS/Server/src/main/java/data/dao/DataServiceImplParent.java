package data.dao;

import util.poalfactory.Al2Po_Factory;
import util.poalfactory.CommonTransferFactory;
import util.poalfactory.Po2Al_Factory;
import util.poalfactory.impl.Al2Po_FactoryImpl;
import util.poalfactory.impl.CommonTransferFactoryImpl;
import util.poalfactory.impl.Po2Al_FactoryImpl;
import data.dao.datafactory.DataFactoryServiceImpl;
import data.datahelper.datahelperfactory.DataHelperFactory;
import data.datahelper.datahelperfactory.DataHelperFactoryImpl;
import dataservice.datafactoryservice.DataFactoryService;


/**
 * Created by Hiki on 11/30/2016.
 */
public class DataServiceImplParent {

    // 需要调用的辅助转换类
    protected CommonTransferFactory ctFactory;

    protected Al2Po_Factory apFactory;

    protected Po2Al_Factory paFactory;

    protected DataHelperFactory dhFactory;

    protected DataFactoryService dsFactory;

    public DataServiceImplParent(){
        this.ctFactory = new CommonTransferFactoryImpl();
        this.apFactory = new Al2Po_FactoryImpl();
        this.paFactory = new Po2Al_FactoryImpl();
        this.dhFactory = new DataHelperFactoryImpl();
        this.dsFactory = new DataFactoryServiceImpl();

    }





}
