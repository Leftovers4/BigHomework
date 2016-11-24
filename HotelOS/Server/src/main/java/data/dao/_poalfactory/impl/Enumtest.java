package data.dao._poalfactory.impl;

/**
 * Created by Hiki on 11/24/2016.
 */
public enum Enumtest {

    /**
     * 无
     */
    NONE,

    /**
     * 普通会员
     */
    NORMAL_MEMBER,

    /**
     * 企业会员
     */
    ENTERPRISE_MEMBER,

    /**
     * 既是普通会员又是企业会员
     */
    BOTH;

    public static Enumtest getType(String name) {
        switch (name) {
            case "NONE":
                return Enumtest.NONE;
            case "NORMAL_MEMBER":
                return Enumtest.NORMAL_MEMBER;
            case "ENTERPRISE_MEMBER":
                return Enumtest.ENTERPRISE_MEMBER;
            case "BOTH":
                return Enumtest.BOTH;

        }
        // TODO：这种方式可能会导致错误，需要对输入有极高的准确性要求
        return null;
    }
}
