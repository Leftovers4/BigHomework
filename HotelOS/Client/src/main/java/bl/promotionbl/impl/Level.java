package bl.promotionbl.impl;

/**
 * Created by kevin on 2016/11/18.
 */
public interface Level extends Promotion {

    /**
     * 获取客户等级
     *
     * @param credit 客户当前信用
     * @return 客户等级
     */
    int getLevel(double credit);

}
