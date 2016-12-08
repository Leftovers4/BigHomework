package bl.userbl;
import util.*;
import vo.user.CreditRecordVO;
import vo.user.CreditVO;
import vo.user.MemberVO;
import vo.user.UserVO;

import java.lang.reflect.InvocationTargetException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Hiki on 2016/10/15.
 */
public interface UserBLService {

    /**
     * 客户注册
     *
     * @param username 用户名
     * @param password 密码
     * @return DataExisted（用户名已存在），以及数据库返回的result message
     */
    ResultMessage registerUser(String username, String password) throws RemoteException;

    /**
     * 客户登入
     *
     * @param username 用户名
     * @param password 密码
     * @return Success, UsernameNotExisted, PasswordWrong
     */
    ResultMessage login(String username, String password) throws RemoteException;

    /**
     * 客户登出
     *
     * @param username 用户名
     * @return the result message
     */
    ResultMessage logout(String username);

    /**
     * 客户查看自己的信用变化记录
     *
     * @param username 用户名
     * @return 客户的信用变化记录表，可能返回空表
     */
    List<CreditRecordVO> getCreditRecordsByUsername(String username) throws RemoteException;

/*--------------------------------------------------------------------------------------------------------------------*/

    /**
     * 客户查看个人基本信息
     *
     * @param username 用户名
     * @return 客户个人基本信息，可能为null
     */
    UserVO viewBasicUserInfo(String username) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, RemoteException;

    /**
     * 客户修改个人基本信息
     *
     * @param userVO 客户个人基本信息中可修改的信息
     * @return UsernameNotExisted, 以及数据库返回的result message
     */
    ResultMessage updateBasicUserInfo(UserVO userVO) throws RemoteException;

    /**
     * 客户注册普通会员
     *
     * @param userVO 注册普通会员时填写的信息
     * @return UsernameNotExisted， DataExisted（客户已经注册了普通会员）， 以及数据库返回的result message
     */
    ResultMessage registerNormalMember(UserVO userVO) throws RemoteException;

    /**
     * 客户注册企业会员
     *
     * @param userVO 注册企业会员时填写的信息
     * @return UsernameNotExisted， DataExisted（客户已经注册了企业会员）， 以及数据库返回的result message
     */
    ResultMessage registerEnterpriseMember(UserVO userVO) throws RemoteException;

/*--------------------------------------------------------------------------------------------------------------------*/

    /**
     * 网站营销人员为客户充值
     *
     * @param username 用户名
     * @param amount 充值金额，单位为元
     * @return UsernameNotExisted， 以及数据库返回的result message
     */
    ResultMessage topup(String username, double amount) throws RemoteException;

/*--------------------------------------------------------------------------------------------------------------------*/
    /**
     * 网站管理人员删除客户
     *
     * @param username 用户名
     * @return 数据库返回的result message
     */
    ResultMessage deleteUser(String username) throws RemoteException;

}
