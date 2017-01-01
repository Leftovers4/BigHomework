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

    /**
     * 获取该房间类型的线下入住房间数
     *
     * @return 该房间类型的线下入住房间数
     */
    public int getOfflineCheckinRoomAmount(){
        return (roomPO.getTotal() - roomPO.getAvailable());
    }

    /**
     * 获取该房间类型的可预定房间数
     *
     * @param beginTime 入住时间
     * @param endTime   离开时间
     * @return 可预定房间数
     * @throws RemoteException 连接服务器异常
     */
    public int getBookableRoomAmount(LocalDateTime beginTime, LocalDateTime endTime) throws RemoteException {
        List<OrderPO> orderPOList = RemoteHelper.getInstance().getOrderDAO().findByHotelID(roomPO.gethotelID());

        new OrderList(orderPOList).filterByRoomType(roomPO.getRoomType()).filterByIsNotOverdue().fillTimeline(timeline);

        return timeline.getBookableRoomAmount(beginTime, endTime);
    }

}
