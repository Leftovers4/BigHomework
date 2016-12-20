package vo.user;

import bl.userbl.impl.CreditRecordList;
import bl.userbl.impl.User;
import po.user.CreditRecordPO;
import po.user.UserPO;
import rmi.RemoteHelper;
import util.MemberType;

import java.lang.reflect.InvocationTargetException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kevin on 2016/12/3.
 */
public class UserVOCreater {

    /**
     * 传给界面：创建包含用户查看基本信息的界面信息的对象
     *
     */
    public UserVO createFullUserVO(UserPO userPO, List<CreditRecordPO> creditRecordPOList) throws ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException, RemoteException {
        UserVO res = new UserVO();

        res.username = userPO.getUsername();
        res.name = userPO.getName();
        res.gender = userPO.isGender();
        res.phone = userPO.getPhone();
        res.image = RemoteHelper.getInstance().getUserDAO().getImage(userPO.getUsername());
        res.creditVO.credit = new CreditRecordList(creditRecordPOList).getCurrentCredit();
        res.creditVO.creditRecords = createAllOrdinaryCreditRecordVO(creditRecordPOList);
        res.memberVO.memberType = userPO.getMemberPO().getMemberType();
        res.memberVO.birthday = userPO.getMemberPO().getBirthday();
        res.memberVO.level = new CreditRecordList(creditRecordPOList).getLevel(new User(userPO).isMember());
        res.memberVO.enterprise = userPO.getMemberPO().getEnterprise();

        return res;
    }


    /**
     * 传给界面：创建包含用户查看信用记录的界面信息的对象
     *
     */
    public CreditRecordVO createOrdinaryCreditRecordVO(CreditRecordPO creditRecordPO){
        CreditRecordVO res = new CreditRecordVO();

        res.recordID = creditRecordPO.getrecordID();
        res.changedTime = creditRecordPO.getChangedTime();
        res.orderID = creditRecordPO.getOrderID();
        res.creditChangedCause = creditRecordPO.getCreditChangedCause();
        res.changedCredit = creditRecordPO.getChangedCredit();
        res.currentCredit = creditRecordPO.getCurrentCredit();

        return res;
    }

    public List<CreditRecordVO> createAllOrdinaryCreditRecordVO(List<CreditRecordPO> creditRecordPOList){
        List<CreditRecordVO> res = new ArrayList<>();

        for (CreditRecordPO creditRecordPO : creditRecordPOList) {
            res.add(createOrdinaryCreditRecordVO(creditRecordPO));
        }

        return res;
    }

}
