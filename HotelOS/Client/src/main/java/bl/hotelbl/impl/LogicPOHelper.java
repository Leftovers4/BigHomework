package bl.hotelbl.impl;

import po.hotel.HotelPO;
import po.hotel.RoomPO;
import util.IDProducer;
import vo.hotel.HotelVO;
import vo.hotel.RoomVO;

import java.util.Random;

/**
 * Created by kevin on 2016/11/25.
 */
public class LogicPOHelper {

    /**
     * 传给数据：创建包含网站管理人员添加新酒店信息的po
     *
     * @param hotelVO 新加酒店的信息
     * @return 包含新加酒店信息的po
     */
    public HotelPO create(HotelVO hotelVO) {
        HotelPO res = new HotelPO();

        res.setHotelID(IDProducer.produceHotelID());
        res.setHotelName(hotelVO.hotelName);
        res.setStar(hotelVO.star);

        return res;
    }

    /**
     * 传给数据：创建包含酒店工作人员修改酒店信息的po
     *
     * @param hotelPO 原来po的信息
     * @param hotelVO po被修改的信息
     * @return 包含酒店工作人员修改酒店信息的po
     */
    public HotelPO create(HotelPO hotelPO, HotelVO hotelVO) {
        HotelPO res = new HotelPO();

        res = hotelPO;
        res.setAddress(hotelVO.address);
        res.setTradingArea(hotelVO.tradingArea);
        res.setDescription(hotelVO.description);
        res.setService(hotelVO.service);

        return res;
    }

    /**
     * 传给数据：创建包含酒店工作人员添加新房间类型信息的po
     *
     * @param roomVO 新加房间类型的信息
     * @return 包含酒店工作人员添加新房间类型信息的po
     */
    public RoomPO create(RoomVO roomVO){
        RoomPO res = new RoomPO();

        res.setroomID(IDProducer.produceGeneralID());
        res.sethotelID(roomVO.hotelID);
        res.setRoomType(roomVO.roomType);
        res.setTotal(roomVO.total);
        res.setAvailable(roomVO.total);
        res.setPrice(roomVO.price);

        return res;
    }

    /**
     * 传给数据：创建包含酒店工作人员添加新房间类型信息的po
     *
     * @param roomPO 原来房间类型的信息
     * @param roomVO 修改的房间类型信息
     * @return 包含酒店工作人员添加新房间类型信息的po
     */
    public RoomPO create(RoomPO roomPO, RoomVO roomVO){
        RoomPO res = new RoomPO();

        res = roomPO;
        res.setTotal(roomVO.total);
        res.setPrice(roomVO.price);

        return res;
    }

}
