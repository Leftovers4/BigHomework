package bl.promotionbl;

import blservice.hotelblservice.HotelBLService;
import blservice_stub.HotelBLService_Stub;
import po.promotion.PromotionPO;
import util.TradingArea;
import vo.hotel.HotelVO;
import vo.order.OrderVO;

/**
 * Created by kevin on 2016/11/6.
 */
public class VIPSpecialAreaPromotion implements Sale{
    private String tradingArea;
    private double[] discounts;

    public VIPSpecialAreaPromotion(PromotionPO promotionPO) {
        // TODO: 2016/11/18
        this.tradingArea = tradingArea;
        this.discounts = discounts;
    }

    @Override
    public double getActualPrice(OrderVO orderVO) {
        double price = orderVO.orderPriceVO.originPrice;
        //todo get HotelBLService
        HotelBLService hotelBLService = new HotelBLService_Stub();
        HotelVO hotel = hotelBLService.findHotelByID(orderVO.hotelID);
        boolean checkTradingArea = hotel.tradingArea == tradingArea;

        if (checkTradingArea){
            //todo get level
            int level = 0;
            return price * discounts[level];
        }else {
            return price;
        }
    }
}
