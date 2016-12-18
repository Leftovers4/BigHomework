package bl.promotionbl.impl;

import bl.promotionbl.PromotionBLService;
import org.junit.Before;
import org.junit.Test;
import util.IDProducer;
import util.PromotionType;
import util.ResultMessage;
import vo.promotion.PromotionVO;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by kevin on 2016/12/7.
 */
public class PromotionBlServiceImplTest {
    PromotionBLService tested;

    @Before
    public void setUp() throws Exception {
        tested = new PromotionBlServiceImpl();
    }

    @Test
    public void create() throws Exception {
        PromotionVO promotionVO = new PromotionVO();

        //说明：当创建促销策略时，hotelID跟promotionType是一定要赋值的，
        //      当促销策略是网站营销人员制定时，调用IDProducer.produceHotelIDforWP（）
        //      来给hotelID赋值，其余promotionVO的属性的填写根据界面的输入框，有就赋值，
        //      没有就不用赋值。

        //等级优惠
        promotionVO.hotelID = IDProducer.produceHotelIDForWP();
        promotionVO.promotionType = PromotionType.UserLevelPromotion;
        promotionVO.promotionMRVOs.get(0).credit = 500;
        promotionVO.promotionMRVOs.get(1).credit = 1000;
        promotionVO.promotionMRVOs.get(2).credit = 1500;
        promotionVO.promotionMRVOs.get(3).credit = 2000;
        promotionVO.promotionMRVOs.get(4).credit = 3000;
        promotionVO.promotionMRVOs.get(5).credit = 5000;
        promotionVO.promotionMRVOs.get(0).memberDiscount = 0.98;
        promotionVO.promotionMRVOs.get(1).memberDiscount = 0.95;
        promotionVO.promotionMRVOs.get(2).memberDiscount = 0.9;
        promotionVO.promotionMRVOs.get(3).memberDiscount = 0.85;
        promotionVO.promotionMRVOs.get(4).memberDiscount = 0.75;
        promotionVO.promotionMRVOs.get(5).memberDiscount = 0.6;
//
//        //多间优惠
//        promotionVO.hotelID = 961529;
//        promotionVO.promotionType = PromotionType.MultipleRoomPromotion;
//        promotionVO.leastRooms = 2;
////        promotionVO.discount = 0.9;
//        PromotionVO promotionVO = new PromotionVO();
//        promotionVO.promotionTraAreaVOs.get(0).tradingArea = "xianlin";
//        promotionVO.promotionTraAreaVOs.get(0).traDiscount = 0.9;
//        promotionVO.hotelID = IDProducer.produceHotelIDForWP();
//        promotionVO.promotionType = PromotionType.VIPSpecialAreaPromotion;

        ResultMessage resultMessage = tested.create(promotionVO);
    }

    @Test
    public void delete() throws Exception {
        ResultMessage resultMessage = tested.delete(809274);
    }

    @Test
    public void update() throws Exception {
        PromotionVO promotionVO = new PromotionVO();

        //说明：此处仅以等级优惠为例，ID一定要，其他看界面。
        promotionVO.promotionID = 208400;
        promotionVO.promotionMRVOs.get(0).credit = 500;
        promotionVO.promotionMRVOs.get(1).credit = 1000;
        promotionVO.promotionMRVOs.get(2).credit = 1500;
        promotionVO.promotionMRVOs.get(3).credit = 2000;
        promotionVO.promotionMRVOs.get(4).credit = 3000;
        promotionVO.promotionMRVOs.get(5).credit = 5000;
        promotionVO.promotionMRVOs.get(0).memberDiscount = 0.98;
        promotionVO.promotionMRVOs.get(1).memberDiscount = 0.95;
        promotionVO.promotionMRVOs.get(2).memberDiscount = 0.9;
        promotionVO.promotionMRVOs.get(3).memberDiscount = 0.85;
        promotionVO.promotionMRVOs.get(4).memberDiscount = 0.75;
        promotionVO.promotionMRVOs.get(5).memberDiscount = 0.6;

        ResultMessage resultMessage = tested.update(promotionVO);
    }

    @Test
    public void viewPromotionList() throws Exception {
        List<PromotionVO> promotionVOList = tested.viewPromotionList(888888, PromotionType.BirthdayPromotion);
    }

}