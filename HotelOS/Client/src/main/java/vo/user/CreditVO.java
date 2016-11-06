package vo.user;

import java.util.ArrayList;

/**
 * Created by Hiki on 2016/10/16.
 */
public class CreditVO {

    /**
     * 用户名
     */
    public String username;

    /**
     * 信用值
     */
    public double credit;

    /**
     * 信用记录（增加/扣除）
     */
    public ArrayList<Double> creditRecord;


    public CreditVO(){}

    /**
     * 用于创建信用类
     */
    public CreditVO(String username, double credit, ArrayList<Double> creditRecord) {
        super();
        this.username = username;
        this.credit = credit;
    }
}
