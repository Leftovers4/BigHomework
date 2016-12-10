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

    public Room(RoomPO roomPO){
        //初始化roomPO
        this.roomPO = roomPO;

        //初始化timeline
        timeline = new Timeline(roomPO.getAvailable());
    }

    public int getOfflineCheckinRoomAmount(){
        return (roomPO.getTotal() - roomPO.getAvailable());
    }

    public int getBookableRoomAmount(LocalDateTime beginTime, LocalDateTime endTime) throws RemoteException {
        List<OrderPO> orderPOList = RemoteHelper.getInstance().getOrderDAO().findByHotelID(roomPO.gethotelID());

        new OrderList(orderPOList).filterByRoomType(roomPO.getRoomType()).filterByIsNotOverdue().fillTimeline(timeline);

        return timeline.getBookableRoomAmount(beginTime, endTime);
    }

}
