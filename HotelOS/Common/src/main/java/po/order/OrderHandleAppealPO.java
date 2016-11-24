package po.order;

import util.HandleAppealResult;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * Created by Hiki on 11/17/2016.
 */
public class OrderHandleAppealPO {

    private LocalDateTime haTime;

    private HandleAppealResult ha_result;


    public OrderHandleAppealPO(){
        initial();
    }

    public OrderHandleAppealPO(LocalDateTime haTime, HandleAppealResult ha_result) {
        initial();
        this.haTime = haTime;
        this.ha_result = ha_result;
    }

    private void initial(){
        this.haTime = null;
        this.ha_result = null;
    }


    public LocalDateTime getHaTime() {
        return haTime;
    }

    public void setHaTime(LocalDateTime haTime) {
        this.haTime = haTime;
    }

    public HandleAppealResult getHa_result() {
        return ha_result;
    }

    public void setHa_result(HandleAppealResult ha_result) {
        this.ha_result = ha_result;
    }
}
