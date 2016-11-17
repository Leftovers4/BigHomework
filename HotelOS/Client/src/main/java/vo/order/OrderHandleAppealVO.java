package vo.order;

import util.HandleAppealResult;

import java.util.Date;

/**
 * Created by Hiki on 11/17/2016.
 */
public class OrderHandleAppealVO {

    public Date haTime;

    public HandleAppealResult ha_result;

    public OrderHandleAppealVO(Date haTime, HandleAppealResult ha_result) {
        this.haTime = haTime;
        this.ha_result = ha_result;
    }
}
