package bl.hotelbl.impl;

import po.hotel.RoomPO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kevin on 2016/12/2.
 */
public class RoomList extends ArrayList<RoomPO> {

    public RoomList(List<RoomPO> roomPOList){
        for (int i = 0; i < roomPOList.size(); i++) {
            this.add(roomPOList.get(i));
        }
    }

    public int getOfflineCheckInRoomAmount(){
        int res = 0;

        for (RoomPO roomPO : this) {
            res += new Room(roomPO).getOfflineCheckinRoomAmount();
        }

        return res;
    }

    public double getHotelPrice(){
        double res = this.get(0).getPrice();

        for (RoomPO roomPO : this) {
            if (roomPO.getPrice() < res){
                res = roomPO.getPrice();
            }
        }

        return res;
    }

}
