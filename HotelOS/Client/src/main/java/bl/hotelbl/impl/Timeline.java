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

    public void addPeriod(LocalDateTime[] period, int amount){
        addPeriod(period[0], period[1], amount);
    }

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

}
