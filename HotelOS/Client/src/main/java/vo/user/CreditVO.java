package vo.user;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hiki on 2016/10/16.
 */
public class CreditVO {

    /**
     * 信用值
     */
    public double credit;

    /**
     * 信用记录（增加/扣除）
     */
    public List<CreditRecordVO> creditRecords;

    public CreditVO(){}

    /**
     * 用于创建信用类
     */
    public CreditVO(double credit, List<CreditRecordVO> creditRecords) {
        super();
        this.credit = credit;
        this.creditRecords = creditRecords;
    }

}
