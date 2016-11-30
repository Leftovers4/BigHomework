package data.dao.personneldata;

import data.dao.DataServiceImplParent;
import data.datahelper.personneldatahelper.PersonnelDataHelper;
import dataservice.personneldataservice.PersonnelDataService;
import po.personnel.PersonnelPO;
import util.PersonnelType;
import util.ResultMessage;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by kevin on 2016/11/16.
 */
public class PersonnelDataServiceImpl extends DataServiceImplParent implements PersonnelDataService {

    // 需要调用的DataHelper
    private PersonnelDataHelper personnelDataHelper;

    // 将需要调用的底层类初始化
    public PersonnelDataServiceImpl(){
        super();
        this.personnelDataHelper = dhFactory.getPersonnelDataHelper();
    }


    @Override
    public ResultMessage insert(PersonnelPO personnelPO) throws RemoteException {
        // 将personnelPO转换成personnelAL
        ArrayList<Object> personnelAL = paFactory.toPersonnelAl(personnelPO);

        // 将AL存到personnel表中
        return personnelDataHelper.insertToSQL(personnelAL);

    }

    @Override
    public ResultMessage delete(long personnelID) throws RemoteException {
        return personnelDataHelper.deleteFromSQL(personnelID);
    }

    @Override
    public ResultMessage update(PersonnelPO personnelPO) throws RemoteException {
        // 将personnelPO转换成personnelAL
        ArrayList<Object> personnelAL = paFactory.toPersonnelAl(personnelPO);

        // 在personnel表中更新personnelAL
        return personnelDataHelper.updateFromSQL(personnelAL);

    }

    @Override
    public ArrayList<PersonnelPO> findAll() throws RemoteException {
        // 将所有personnelAL取出
        ArrayList<ArrayList<Object>> personnelALs = personnelDataHelper.findFromSQL();

        // 构造personnelALs的迭代器
        Iterator<Iterator<Object>> personnelInfos = ctFactory.alsToItrs(personnelALs);

        // 将personnelInfos转换成personnelPO
        ArrayList<PersonnelPO> personnelPOs = new ArrayList<>();

        while(personnelInfos.hasNext()){
            personnelPOs.add(apFactory.toPersonnelPO(personnelInfos.next()));
        }

        return personnelPOs;


    }

    @Override
    public ArrayList<PersonnelPO> findByType(PersonnelType personnelType) throws RemoteException {
        // 调用findAll
        ArrayList<PersonnelPO> personnelPOs = this.findAll();

        // 对比personnelType
        ArrayList<PersonnelPO> result = new ArrayList<>();

        for (PersonnelPO each : personnelPOs) {
            if(each.getPersonnelType().equals(personnelType)){
                result.add(each);
            }
        }

        return result;


    }

    @Override
    public PersonnelPO findByPersonnelID(long personnelID) throws RemoteException {
        // 将personnelAL取出来
        ArrayList<Object> personnelAL = personnelDataHelper.findByIdFromSQL(personnelID);

        // 构造personnelAL的迭代器
        Iterator<Object> personnelInfo = ctFactory.alToItr(personnelAL);

        // 将取出来的AL转换成PO
        PersonnelPO personnelPO = apFactory.toPersonnelPO(personnelInfo);

        return personnelPO;
    }

}
