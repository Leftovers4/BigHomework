package blservice.memberblservice;
import util.*;
import vo.Member.MemberVO;

/**
 * Created by Hiki on 2016/10/15.
 */
public interface MemberBLService {

    // 注册会员
    public util.ResultMessage register(MemberVO memberVO);

    // 删除会员
    public util.ResultMessage delete(String username);

    // 显示会员信息
    public MemberVO showInfo(String username);

}
