package util;

/**
 * Created by Hiki on 2016/10/15.
 */

public enum ResultMessage {

    /**
     * 成功
     */
    Success,

    /**
     * 失败
     */
    Fail,

    /**
     * 连接服务器失败
     */
    ConnectionError,

    /**
     * 登录失败：用户名不存在
     */
    UsernameNotExisted,

    /**
     * 登录失败：密码错误
     */
    PasswordWrong,

    /**
     * 中断
     */
    Pause,

    /**
     * 数据已存在
     */
    DataExisted,

    /**
     * 数据不存在
     */
    DataNotExisted,

    /**
     * 数据库错误
     */
    SqlError,

    /**
     * 信用值不足
     */
    CreditNotEnough;




}

