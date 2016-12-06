package data.dao.userdata;

import com.sun.corba.se.spi.ior.ObjectKey;
import data.dao.DataServiceImplParent;
import data.datahelper.userdatahelper.CreditRecordDataHelper;
import data.datahelper.userdatahelper.UserDataHelper;
import data.datahelper.userdatahelper.UserImageHelper;
import dataservice.userdataservice.UserDataService;
import po.user.CreditRecordPO;
import po.user.MemberPO;
import po.user.UserPO;
import util.Coder;
import util.ResultMessage;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by kevin on 2016/11/16.
 */
public class UserDataServiceImpl extends DataServiceImplParent implements UserDataService {

    // 需要调用的DataHelper
    private UserDataHelper userDataHelper;
    private CreditRecordDataHelper crDataHelper;
    private UserImageHelper userImageHelper;

    // 将需要调用的底层类初始化
    public UserDataServiceImpl(){
        super();
        userDataHelper = dhFactory.getUserDataHelper();
        crDataHelper = dhFactory.getCreditRecordDataHelper();
        userImageHelper = dhFactory.getUserImageHelper();
    }


    @Override
    public ResultMessage insert(UserPO userPO) throws RemoteException {

        // 将userPO转换成userAL
        ArrayList<Object> userAL = paFactory.toUserAl(userPO);

        // 将userAL插入到user表中
        return userDataHelper.insertToSQL(userAL);

    }

    @Override
    public ResultMessage delete(String username) throws RemoteException {
        // 先将username加密
        username = Coder.encode(username);
        return userDataHelper.deleteFromSQL(username);
    }

    @Override
    public ResultMessage update(UserPO userPO) throws RemoteException {
        // 将userPO转换成userAL
        ArrayList<Object> userAL = paFactory.toUserAl(userPO);

        // 将userAL更新到user表中
        return userDataHelper.updateFromSQL(userAL);
    }

    @Override
    public ArrayList<UserPO> findAll() throws RemoteException {
        // 在user表中获取所有的userALs
        ArrayList<ArrayList<Object>> userALs = userDataHelper.findFromSQL();
        // 构造userALs的迭代器
        Iterator<Iterator<Object>> userInfos = ctFactory.alsToItrs(userALs);
        // 生成userPOs
        ArrayList<UserPO> userPOs = new ArrayList<>();
        while(userInfos.hasNext()){
            userPOs.add(apFactory.toUserPO(userInfos.next()));
        }

        // 对每个userPO设置相应的creditRecordPOs
        ArrayList<UserPO> setUserPOs = new ArrayList<>();
        for (UserPO each : userPOs) {
            each.setCreditRecordPOs(getCreditRecordsByUsername(findAllCreditRecord(), each.getUsername()));
            setUserPOs.add(each);
        }

        return setUserPOs;


    }

    @Override
    public UserPO findByUsername(String username) throws RemoteException {
        // 先将username加密
        username = Coder.encode(username);
        // 根据用户名在user表中获取userAL
        ArrayList<Object> userAL = userDataHelper.findByIDFromSQL(username);
        // 构造userAL的迭代器
        Iterator<Object> userInfo = ctFactory.alToItr(userAL);
        // 生成userPO
        UserPO userPO = apFactory.toUserPO(userInfo);

        // 查找对应username的credit records
        ArrayList<CreditRecordPO> creditRecordPOs = findCreditRecordsByUsername(username);

        // 设置userPO
        userPO.setCreditRecordPOs(creditRecordPOs);

        return userPO;
    }

    @Override
    public ResultMessage insertCreditRecord(CreditRecordPO creditRecordPO) throws RemoteException {
        // 将crPO转换成crAL
        ArrayList<Object> crAL = paFactory.toCreditRecordAl(creditRecordPO);

        return crDataHelper.insertToSQL(crAL);

    }

    @Override
    public ArrayList<CreditRecordPO> findCreditRecordsByUsername(String username) throws RemoteException{
        // 调用findAllCreditRecord
        return getCreditRecordsByUsername(findAllCreditRecord(), username);

    }

    @Override
    public byte[] getImage(String username) throws RemoteException {
        return userImageHelper.findUserImageByUsername(username);
    }

    @Override
    public ResultMessage setImage(String username, byte[] image) throws RemoteException {
        return userImageHelper.setUserImage(username, image);
    }


    /*----------------------------------------------辅助类-------------------------------------------------------------*/

    /**
     * 查找所有credit record
     * @return
     */
    private ArrayList<CreditRecordPO> findAllCreditRecord(){
        // 获取所有的creditRecordALs
        ArrayList<ArrayList<Object>> creditRecordALs = crDataHelper.findFromSQL();
        // 构造所有creditRecord的迭代器
        Iterator<Iterator<Object>> creditRecordInfos = ctFactory.alsToItrs(creditRecordALs);
        // 转换成creditRecordPOs
        ArrayList<CreditRecordPO> creditRecordPOs = new ArrayList<>();
        while(creditRecordInfos.hasNext()){
            creditRecordPOs.add(apFactory.toCreditRecordPO(creditRecordInfos.next()));
        }

        return creditRecordPOs;
    }

    /**
     * 获取usernmae对应的creditRecordPOs
     * @param username
     */
    private ArrayList<CreditRecordPO> getCreditRecordsByUsername(ArrayList<CreditRecordPO> creditRecordPOs, String username){

        ArrayList<CreditRecordPO> creditRecords = new ArrayList<>();

        for (CreditRecordPO each : creditRecordPOs) {
            if(each.getUsername().equals(username)){
                creditRecords.add(each);
            }
        }

        return creditRecords;

    }

}
