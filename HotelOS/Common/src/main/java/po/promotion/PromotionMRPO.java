package po.promotion;

import java.util.ArrayList;

/**
 * Created by Hiki on 11/24/2016.
 * description: MR(Member Regulation) 指定会员规则：会员等级 —— 对应信用值 —— 对应折扣
 */
public class PromotionMRPO {

    /**
     * 会员等级
     */
    private int level;

    /**
     * 信用值
     */
    private double credit;

    /**
     * 折扣
     */
    private double discount;


    public PromotionMRPO(){
        initial();
    }

    public PromotionMRPO(int level, double credit, double discount) {
        initial();
        this.level = level;
        this.credit = credit;
        this.discount = discount;
    }

    private void initial(){
        this.level = 0;
        this.credit = 0.0;
        this.discount = 1;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
