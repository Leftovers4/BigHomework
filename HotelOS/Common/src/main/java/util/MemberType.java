package util;

/**
 * Created by Hiki on 2016/10/15.
 */
public enum MemberType {

    /**
     * 无
     */
    None,

    /**
     * 普通会员
     */
    NormalMember,

    /**
     * 企业会员
     */
    EnterpriseMember,

    /**
     * 既是普通会员又是企业会员
     */
    Both;

    public MemberType getType(String type){
        switch(type){
            case "None":
                return MemberType.None;
            case "NormalMember":
                return MemberType.NormalMember;
            case "EnterpriseMember":
                return MemberType.EnterpriseMember;
            case "Both":
                return MemberType.Both;

        }
        // TODO：这种方式可能会导致错误，需要对输入有极高的准确性要求
        return null;
    }


}
