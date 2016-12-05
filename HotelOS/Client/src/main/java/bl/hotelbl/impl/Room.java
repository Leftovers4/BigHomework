package bl.hotelbl.impl;

import po.hotel.RoomPO;

/**
 * Created by kevin on 2016/12/2.
 */
public class Room{

    RoomPO roomPO;

    public Room(RoomPO roomPO){
        this.roomPO = roomPO;
    }

    public int getOfflineCheckinRoomAmount(){
        return (roomPO.getTotal() - roomPO.getAvailable());
    }

}
