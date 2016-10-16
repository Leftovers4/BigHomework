package vo.order;

import java.util.Date;

/**
 * Created by Hiki on 2016/10/16.
 */
public class EvaluationVO {


    /**
     * 用户名
     */
    private String username;

    /**
     * 酒店ID
     */
    private long hotelID;

    /**
     * 评价时间
     */
    private Date evaluateTime;

    /**
     * 评价内容
     */
    private String evaluation;


    public EvaluationVO(){}

    /**
     * 用于客户评价
     */
    public EvaluationVO(String username, long hotelID, Date evaluateTime, String evaluation) {
        super();
        this.username = username;
        this.hotelID = hotelID;
        this.evaluateTime = evaluateTime;
        this.evaluation = evaluation;
    }
}
