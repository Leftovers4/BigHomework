package bl.orderbl.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by kevin on 2016/12/16.
 */
public class OrderTimeRule {

    /**
     * 根据客户线上选择的入住日期获取预计入住时间
     *
     * @param expectedCheckInDate 客户选择的入住日期
     * @return 预计入住时间
     */
    public static LocalDateTime getExpectedCheckInTime(LocalDate expectedCheckInDate){
        LocalDateTime now = LocalDateTime.now();

        if (expectedCheckInDate.isEqual(now.toLocalDate()) && now.isAfter(now.withHour(14).withMinute(0).withSecond(0))){
            return now;
        }else {
            return expectedCheckInDate.atTime(14, 0, 0);
        }
    }

    /**
     * 根据客户线上选择的离开日期获取预计离开时间
     *
     * @param expectedLeaveDate 客户选择的离开日期
     * @return 预计离开时间
     */
    public static LocalDateTime getExpectedLeaveTime(LocalDate expectedLeaveDate){
        return expectedLeaveDate.atTime(12, 0, 0);
    }

    /**
     * 获取线下入住的预计入住时间
     *
     * @return 线下入住的预计入住时间
     */
    public static LocalDateTime getLastExecuteTime(LocalDateTime expectedCheckInTime){
        return expectedCheckInTime.plusHours(6);
    }

    /**
     * 获取线下入住的预计离开时间
     *
     * @return 线下入住的预计离开时间
     */
    public static LocalDateTime getOfflineLeaveTime(LocalDateTime offlineCheckInTime){
        if(offlineCheckInTime.isAfter(offlineCheckInTime.withHour(0).withMinute(0).withSecond(0)) && offlineCheckInTime.isBefore(offlineCheckInTime.withHour(12).withMinute(0).withSecond(0))){
            return offlineCheckInTime.withHour(12).withMinute(0).withSecond(0);
        }else {
            return offlineCheckInTime.plusDays(1).withHour(12).withMinute(0).withSecond(0);
        }
    }

}
