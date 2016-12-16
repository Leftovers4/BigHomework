package bl.orderbl.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by kevin on 2016/12/16.
 */
public class OrderTimeRule {

    public static LocalDateTime getExpectedCheckInTime(LocalDate expectedCheckInDate){
        LocalDateTime now = LocalDateTime.now();

        if (expectedCheckInDate.isEqual(now.toLocalDate()) && now.isAfter(now.withHour(14).withMinute(0).withSecond(0))){
            return now;
        }else {
            return expectedCheckInDate.atTime(14, 0, 0);
        }
    }

    public static LocalDateTime getExpectedLeaveTime(LocalDate expectedLeaveDate){
        return expectedLeaveDate.atTime(12, 0, 0);
    }

    public static LocalDateTime getLastExecuteTime(LocalDateTime expectedCheckInTime){
        return expectedCheckInTime.plusHours(6);
    }

}
