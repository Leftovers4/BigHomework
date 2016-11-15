package po.user;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Hiki on 2016/10/16.
 */
public class CreditPO implements Serializable {

    /**
     * 序列化UID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 用户名
     */
    private String username;

    /**
     * 信用值
     */
    private double credit;

    /**
     * 信用记录（增加/扣除）
     */
    private ArrayList<CreditRecordPO> creditRecord;


    public CreditPO(){}

    /**
     * 用于创建信用类
     */
    public CreditPO(String username, double credit, ArrayList<CreditRecordPO> creditRecord) {
        super();
        this.username = username;
        this.credit = credit;
        this.creditRecord = creditRecord;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public ArrayList<CreditRecordPO> getCreditRecord() {
        return creditRecord;
    }

    public void setCreditRecord(ArrayList<CreditRecordPO> creditRecord) {
        this.creditRecord = creditRecord;
    }
}


