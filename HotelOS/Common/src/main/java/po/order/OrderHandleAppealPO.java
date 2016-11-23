package po.order;

import util.HandleAppealResult;

import java.util.Date;

/**
 * Created by Hiki on 11/17/2016.
 */
public class OrderHandleAppealPO {

    private Date haTime;

    private HandleAppealResult ha_result;


    public OrderHandleAppealPO(){
        initial();
    }

    public OrderHandleAppealPO(Date haTime, HandleAppealResult ha_result) {
        initial();
        this.haTime = haTime;
        this.ha_result = ha_result;
    }

    private void initial(){
        this.haTime = null;
        this.ha_result = null;
    }


    public Date getHaTime() {
        return haTime;
    }

    public void setHaTime(Date haTime) {
        this.haTime = haTime;
    }

    public HandleAppealResult getHa_result() {
        return ha_result;
    }

    public void setHa_result(HandleAppealResult ha_result) {
        this.ha_result = ha_result;
    }
}
