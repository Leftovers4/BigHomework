package vo.order;

import util.HandleAppealResult;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * Created by Hiki on 11/17/2016.
 */
public class OrderHandleAppealVO {

    public LocalDateTime haTime;

    public HandleAppealResult ha_result;

    public OrderHandleAppealVO(LocalDateTime haTime, HandleAppealResult ha_result) {
        this.haTime = haTime;
        this.ha_result = ha_result;
    }
}
