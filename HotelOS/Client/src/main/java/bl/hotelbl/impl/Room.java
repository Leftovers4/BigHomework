package bl.hotelbl.impl;

import bl.orderbl.impl.Order;
import bl.orderbl.impl.OrderList;
import po.hotel.RoomPO;
import po.order.OrderPO;
import rmi.RemoteHelper;

import java.rmi.RemoteException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kevin on 2016/12/2.
 */
public class Room{

    private RoomPO roomPO;

    private Timeline timeline;

    /**
     * Instantiates a new Room.
     *
     * @param roomPO the room po
     */
    public Room(RoomPO roomPO){
        //初始化roomPO
        this.roomPO = roomPO;

        //初始化timeline
        timeline = new Timeline(roomPO.getAvailable());
    }

    /**
     * Get offline checkin room amount int.
     *
     * @return the int
     */
    public int getOfflineCheckinRoomAmount(){
        return (roomPO.getTotal() - roomPO.getAvailable());
    }

    /**
     * Gets bookable room amount.
     *
     * @param beginTime the begin time
     * @param endTime   the end time
     * @return the bookable room amount
     * @throws RemoteException the remote exception
     */
    public int getBookableRoomAmount(LocalDateTime beginTime, LocalDateTime endTime) throws RemoteException {
        List<OrderPO> orderPOList = RemoteHelper.getInstance().getOrderDAO().findByHotelID(roomPO.gethotelID());

        new OrderList(orderPOList).filterByRoomType(roomPO.getRoomType()).filterByIsNotOverdue().fillTimeline(timeline);

        return timeline.getBookableRoomAmount(beginTime, endTime);
    }

}
