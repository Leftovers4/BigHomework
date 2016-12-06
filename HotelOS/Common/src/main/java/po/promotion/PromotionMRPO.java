package po.promotion;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Hiki on 11/24/2016.
 * description: MR(Member Regulation) 指定会员规则：会员等级 —— 对应信用值 —— 对应折扣
 */
public class PromotionMRPO implements Serializable {

    /**
     * 序列化UID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 信用值
     */
    private double credit;

    /**
     * 折扣
     */
    private double memberDiscount;


    public PromotionMRPO(){
        initial();
    }

    public PromotionMRPO(double credit, double memberDiscount) {
        initial();

        this.credit = credit;
        this.memberDiscount = memberDiscount;
    }

    private void initial(){
        this.credit = 0.0;
        this.memberDiscount = 1.0;
    }



    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public double getMemberDiscount() {
        return memberDiscount;
    }

    public void setMemberDiscount(double memberDiscount) {
        this.memberDiscount = memberDiscount;
    }
}
