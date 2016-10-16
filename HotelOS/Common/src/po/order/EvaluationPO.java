package po.order;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Hiki on 2016/10/16.
 */
public class EvaluationPO implements Serializable {

    /**
     * 序列化UID
     */
    private static final long serialVersionUID = 1L;

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

    /**
     * 用于客户评价
     */
    public EvaluationPO(String username, long hotelID, Date evaluateTime, String evaluation) {
        this.username = username;
        this.hotelID = hotelID;
        this.evaluateTime = evaluateTime;
        this.evaluation = evaluation;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getHotelID() {
        return hotelID;
    }

    public void setHotelID(long hotelID) {
        this.hotelID = hotelID;
    }

    public Date getEvaluateTime() {
        return evaluateTime;
    }

    public void setEvaluateTime(Date evaluateTime) {
        this.evaluateTime = evaluateTime;
    }

    public String getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(String evaluation) {
        this.evaluation = evaluation;
    }
}
