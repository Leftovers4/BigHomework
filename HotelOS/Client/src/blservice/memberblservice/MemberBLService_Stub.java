package blservice.memberblservice;

import util.ResultMessage;
import vo.member.MemberVO;

/**
 * Created by kevin on 2016/10/16.
 */
public class MemberBLService_Stub implements MemberBLService {
    @Override
    public ResultMessage register(MemberVO memberVO) {
        return ResultMessage.SUCCESS;
    }

    @Override
    public ResultMessage delete(String username) {
        return ResultMessage.SUCCESS;
    }

    @Override
    public MemberVO showInfo(String username) {
        return null;
    }
}
