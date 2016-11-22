package util;

/**
 * Created by Hiki on 2016/10/15.
 */

public enum ResultMessage {

    /**
     * 成功
     */
    SUCCESS,

    /**
     * 失败
     */
    FAIL,

    /**
     * 登录失败：用户名不存在
     */
    USERNAME_EXISTED,

    /**
     * 登录失败：密码错误
     */
    PASSWORD_WRONG,

    /**
     * 中断
     */
    PAUSE,

    /**
     * 数据已存在
     */
    HAS_EXIST,

    /**
     * 数据不存在
     */
    NOT_EXIST,

    /**
     * 数据库错误
     */
    SQL_ERROR,

    /**
     * 信用值不足
     */
    CREDIT_NOT_ENOUGH;




}

