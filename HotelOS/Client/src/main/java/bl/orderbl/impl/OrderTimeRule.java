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

    public static LocalDateTime getOfflineLeaveTime(LocalDateTime offlineCheckInTime){
        if(offlineCheckInTime.isAfter(offlineCheckInTime.withHour(0).withMinute(0).withSecond(0)) && offlineCheckInTime.isBefore(offlineCheckInTime.withHour(12).withMinute(0).withSecond(0))){
            return offlineCheckInTime.withHour(12).withMinute(0).withSecond(0);
        }else {
            return offlineCheckInTime.plusDays(1).withHour(12).withMinute(0).withSecond(0);
        }
    }

}
