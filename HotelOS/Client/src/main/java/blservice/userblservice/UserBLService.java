package blservice.userblservice;
import util.*;
import vo.user.CreditVO;
import vo.user.MemberVO;
import vo.user.UserVO;

import java.util.ArrayList;


/**
 * Created by Hiki on 2016/10/15.
 */


public interface UserBLService {

    // 用户登录
    public ResultMessage login(UserVO userVO);

    // 用户登出
    public ResultMessage logout();

    // 添加账户
    public ResultMessage add(UserVO userVO);

    // 删除账户
    public ResultMessage del(String username);

    // 根据用户名查找用户
    public UserVO find(String username);


    // 显示用户信息
    public UserVO getInfo(String username);

    // 修改用户信息
    public ResultMessage setInfo(UserVO userVO);

    // 显示用户列表
    public ArrayList<UserVO> showList();

    // 显示用户会员类型
    public MemberType getMemberType(String username);

    // 注册会员
    public ResultMessage register(MemberVO memberVO);

    // 删除会员
    public ResultMessage delete(String username);

    // 显示会员信息
    public MemberVO showInfo(String username);

    // 增加用户信用值
    public ResultMessage addCredit(String username, double amount);

    // 扣除用户信用值
    public ResultMessage deductCredit(String username, double amount);

    // 显示信用记录
    public CreditVO showCreditRecord (String username);


}
