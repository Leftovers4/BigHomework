package bl.hotelbl;

import po.hotel.HotelPO;
import vo.hotel.HotelVO;

/**
 * Created by kevin on 2016/11/25.
 */
public class PoHelper {

    public HotelPO convert(HotelVO hotelVO, String type){
        HotelPO res = null;

        switch (type){
            case "new hotel info":
                // TODO: 2016/11/26 编写新的构造器
                //res = new HotelPO(hotelVO.hotelName, hotelVO.star);
                break;
        }

        return res;
    }

    public HotelPO merge(HotelPO hotelPO, HotelVO hotelVO, String type){
        HotelPO res = null;

        switch (type){
            case "update basic hotel info":
                res = hotelPO;
                res.setAddress(hotelVO.address);
                res.setTradingArea(hotelVO.tradingArea);
                res.setDescription(hotelVO.description);
                res.setService(hotelVO.service);
                break;
        }

        return res;
    }

}
