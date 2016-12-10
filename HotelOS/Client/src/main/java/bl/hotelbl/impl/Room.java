package bl.hotelbl.impl;

import po.hotel.RoomPO;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Created by kevin on 2016/12/2.
 */
public class Room{

    private RoomPO roomPO;

    private Timeline timeline;

    public Room(RoomPO roomPO){
        this.roomPO = roomPO;
    }

    public int getOfflineCheckinRoomAmount(){
        return (roomPO.getTotal() - roomPO.getAvailable());
    }

    public void setTimeline(Timeline timeline) {
        this.timeline = timeline;
    }

}
