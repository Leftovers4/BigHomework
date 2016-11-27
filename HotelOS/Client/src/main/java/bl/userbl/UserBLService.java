package bl.userbl;
import util.*;
import vo.user.CreditRecordVO;
import vo.user.CreditVO;
import vo.user.MemberVO;
import vo.user.UserVO;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Hiki on 2016/10/15.
 */
public interface UserBLService {

    /**
     * 客户登入
     *
     * @param username 用户名
     * @param password 密码
     * @return SUCCESS, FAIL
     */
    ResultMessage login(String username, String password);

    /**
     * 客户登出
     *
     * @param username 用户名
     * @return the result message
     */
    ResultMessage logout(String username);

    /**
     * 客户查看个人基本信息
     *
     * @param username 用户名
     * @return 客户个人基本信息
     */
    UserVO getBasicUserInfo(String username);

    /**
     * 客户修改个人基本信息
     *
     * @param userVO 客户个人基本信息中可修改的信息
     * @return the result message
     */
    ResultMessage updateBasicUserInfo(UserVO userVO);

    /**
     * 客户查看自己的信用变化记录
     *
     * @param username 用户名
     * @return 客户的信用变化记录
     */
    List<CreditRecordVO> getCreditRecordsByUsername(String username);

    /**
     * 客户注册普通会员
     *
     * @param userVO the user vo
     * @return the result message
     */
    ResultMessage registerNormalMember(UserVO userVO);

    /**
     * 客户注册企业会员
     *
     * @param userVO the user vo
     * @return the result message
     */
    ResultMessage registerEnterpriseMember(UserVO userVO);

    /**
     * 网站营销人员为客户充值
     *
     * @param creditRecordVO 
     * @return the result message
     */
    ResultMessage topup(CreditRecordVO creditRecordVO);

}
