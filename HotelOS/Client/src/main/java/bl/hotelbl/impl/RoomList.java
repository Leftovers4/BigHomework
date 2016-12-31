package bl.hotelbl.impl;

import po.hotel.RoomPO;
import util.RoomType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kevin on 2016/12/2.
 */
public class RoomList extends ArrayList<RoomPO> {

    /**
     * Instantiates a new Room list.
     *
     * @param roomPOList the room po list
     */
    public RoomList(List<RoomPO> roomPOList){
        for (int i = 0; i < roomPOList.size(); i++) {
            this.add(roomPOList.get(i));
        }
    }

    /**
     * Get offline check in room amount int.
     *
     * @return the int
     */
    public int getOfflineCheckInRoomAmount(){
        int res = 0;

        for (RoomPO roomPO : this) {
            res += new Room(roomPO).getOfflineCheckinRoomAmount();
        }

        return res;
    }

    /**
     * Get hotel price double.
     *
     * @return the double
     */
    public double getHotelPrice(){
        //酒店没有房间的情况
        if (this.size() == 0)
            return 0;

        //酒店有房间的情况
        double res = this.get(0).getPrice();

        for (RoomPO roomPO : this) {
            if (roomPO.getPrice() < res){
                res = roomPO.getPrice();
            }
        }

        return res;
    }

    /**
     * Filter by room type room po.
     *
     * @param roomType the room type
     * @return the room po
     */
    public RoomPO filterByRoomType(RoomType roomType){
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getRoomType().equals(roomType)){
                return this.get(i);
            }
        }

        return null;
    }

    /**
     * Get hotel min room num int.
     *
     * @return the int
     */
    public int getHotelMinRoomNum(){
        //表为空的情况
        if (this.isEmpty())
            return 0;

        //表不为空的情况
        int res = this.get(0).getTotal();

        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getTotal() < res){
                res = this.get(i).getTotal();
            }
        }

        return res;
    }

}
