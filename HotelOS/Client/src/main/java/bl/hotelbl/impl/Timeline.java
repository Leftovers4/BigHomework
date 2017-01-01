package bl.hotelbl.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Created by kevin on 2016/12/10.
 */
public class Timeline{

    private int roomTotal;

    private ArrayList<LocalDateTime> timeline;

    private ArrayList<Integer> timelineRoomNums;

    public Timeline(int roomTotal){
        //初始化roomTotal
        this.roomTotal = roomTotal;

        //初始化timeline
        timeline = new ArrayList<>();
        timeline.add(LocalDateTime.MIN);
        timeline.add(LocalDateTime.MAX);

        //初始化roomNums
        timelineRoomNums = new ArrayList<>();
        timelineRoomNums.add(roomTotal);
    }

    /**
     * 在时间线上添加一个订单
     *
     * @param period 长度为2的LocalDateTime数组，0位置表示订单对房间占用的开始时间，
     *               1位置表示订单对房间占用的结束时间
     * @param amount 订单房间数量
     */
    public void addPeriod(LocalDateTime[] period, int amount){
        addPeriod(period[0], period[1], amount);
    }

    /**
     * 在时间线上添加一个订单
     *
     * @param beginTime 订单对房间占用的开始时间
     * @param endTime   订单对房间占用的结束时间
     * @param amount    订单房间数量
     */
    public void addPeriod(LocalDateTime beginTime, LocalDateTime endTime, int amount){
        for (int i = addTime(beginTime, true); i <= addTime(endTime, false); i++) {
            timelineRoomNums.set(i, timelineRoomNums.get(i) - amount);
        }
    }

    private int addTime(LocalDateTime time, boolean beginTime){
        for (int i = 0; i < timeline.size(); i++) {
            if (time.isEqual(timeline.get(i)))
                return beginTime ? i : i - 1;

            if (time.isAfter(timeline.get(i)) && time.isBefore(timeline.get(i + 1))){
                timeline.add(i + 1, time);
                timelineRoomNums.add(i, timelineRoomNums.get(i));
                return beginTime ? i + 1 : i;
            }
        }

        return -1;
    }

    /**
     * 获取房间类型的在某段时间的可预定房间数量
     *
     * @param beginTime 入住时间
     * @param endTime   离开时间
     * @return 可预定房间数量
     */
    public int getBookableRoomAmount(LocalDateTime beginTime, LocalDateTime endTime){
        int res = roomTotal;

        for (int i = getLocation(beginTime, true); i <= getLocation(endTime, false); i++) {
            if (timelineRoomNums.get(i) < res)
                res = timelineRoomNums.get(i);
        }

        return res;
    }

    private int getLocation(LocalDateTime time, boolean beginTime){
        for (int i = 0; i < timeline.size(); i++) {
            if (time.isEqual(timeline.get(i)))
                return beginTime ? i : i - 1;

            if (time.isAfter(timeline.get(i)) && time.isBefore(timeline.get(i + 1)))
                return i;
        }

        return -1;
    }

}
