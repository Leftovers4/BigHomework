package bl.promotionbl.impl;

import bl.hotelbl.HotelBLService;
import bl.userbl.impl.CreditRecordList;
import blservice_stub.HotelBLService_Stub;
import po.hotel.HotelPO;
import po.promotion.PromotionPO;
import po.user.CreditRecordPO;
import rmi.RemoteHelper;
import util.Const;
import util.IDProducer;
import util.PromotionType;
import vo.hotel.HotelVO;
import vo.order.OrderVO;

import java.lang.reflect.InvocationTargetException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import static util.TableName.hotel;

/**
 * Created by kevin on 2016/11/6.
 */
public class VIPSpecialAreaPromotion implements Sale{

    private ArrayList<String> tradingAreas;

    private ArrayList<Double> traDiscounts;

    private double[] levelDiscounts;

    public VIPSpecialAreaPromotion(PromotionPO promotionPO) throws RemoteException {
        //初始化tradingAreas
        tradingAreas = new ArrayList<>();
        for (int i = 0; i < promotionPO.getPromotionTraAreaPOs().size(); i++) {
            tradingAreas.add(promotionPO.getPromotionTraAreaPOs().get(i).getTradingArea());
        }

        //初始化traDiscounts
        traDiscounts = new ArrayList<>();
        for (int i = 0; i < promotionPO.getPromotionTraAreaPOs().size(); i++) {
            traDiscounts.add(promotionPO.getPromotionTraAreaPOs().get(i).getTraDiscount());
        }

        //初始化levelDiscounts
        levelDiscounts = new double[Const.MaxMemberLevel];
        List<PromotionPO> promotionPOList = RemoteHelper.getInstance().getPromotionDAO().findByHotelIDAndType(IDProducer.produceHotelIDForWP(), PromotionType.UserLevelPromotion);

        if (promotionPOList.isEmpty()) {
            for (int i = 0; i < levelDiscounts.length; i++) {
                levelDiscounts[i] = 1;
            }
        }else {
            for (int i = 0; i < levelDiscounts.length; i++) {
                levelDiscounts[i] = promotionPOList.get(0).getPromotionMRPOs().get(i).getMemberDiscount();
            }
        }

    }

    @Override
    public double getActualPrice(OrderVO orderVO) throws RemoteException, ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException {
        double price = orderVO.orderPriceVO.originPrice;

        HotelPO hotelPO = RemoteHelper.getInstance().getHotelDAO().findByHotelID(orderVO.hotelID);

        for (int i = 0; i < tradingAreas.size(); i++) {
            if ((hotelPO.getAddress() + hotelPO.getTradingArea()).equals(tradingAreas.get(i))){
                List<CreditRecordPO> creditRecordPOList = RemoteHelper.getInstance().getUserDAO().findCreditRecordsByUsername(orderVO.username);
                int level = new CreditRecordList(creditRecordPOList).getLevel();

                if (level == 0)
                    return price * traDiscounts.get(i);

                return price * levelDiscounts[level] * traDiscounts.get(i);
            }
        }

        return price;
    }

}
