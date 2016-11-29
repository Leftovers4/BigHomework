package bl.userbl.impl;

import util.MemberType;
import util.ResultMessage;

import java.util.Date;

/**
 * Created by kevin on 2016/11/6.
 */
public class MockUser extends User {

    /**
     * 用户名
     */
    private String username;

    /**
     * 会员类型
     */
    private MemberType memberType;

    /**
     * 信用（包括信用值，信用记录）
     */
    private double credit;

    /**
     * 生日
     */
    private Date birthday;

    /**
     * Instantiates a new Mock user.
     *
     * @param username   the username
     * @param memberType the member type
     * @param credit     the credit
     */
    public MockUser(String username, MemberType memberType, double credit) {
        this.username = username;
        this.memberType = memberType;
        this.credit = credit;
    }

    /**
     * Getter for property 'memberType'.
     *
     * @return Value for property 'memberType'.
     */
    public MemberType getMemberType() {
        return memberType;
    }

    /**
     * Getter for property 'credit'.
     *
     * @return Value for property 'credit'.
     */
    public double getCredit() {
        return credit;
    }

    /**
     * Add credit.
     *
     * @param credit the credit to add
     * @return the result message
     */
    public ResultMessage addCredit(double credit){
        this.credit += credit;
        return ResultMessage.Success;
    }

    /**
     * Deduct credit.
     *
     * @param credit the credit to deduct
     * @return the result message
     */
    public ResultMessage deductCredit(double credit){
        if (this.credit < credit){
            return ResultMessage.CreditNotEnough;
        }else {
            this.credit -= credit;
            return ResultMessage.Success;
        }
    }

    /**
     * judge whether the date is this user's birthday.
     *
     * @param date the date
     * @return true or false
     */
    public boolean isBirthDay(Date date){
        if (date.equals(birthday)){
            return true;
        }else {
            return false;
        }
    }

}
