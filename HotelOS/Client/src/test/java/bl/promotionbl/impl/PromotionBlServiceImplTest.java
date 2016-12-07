package bl.promotionbl.impl;

import bl.promotionbl.PromotionBLService;
import org.junit.Before;
import org.junit.Test;
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
        //      没有就不用赋值，此处仅以特定期间优惠为例。
        promotionVO.hotelID = 522001;
        promotionVO.promotionType = PromotionType.SpecialTimePromotion;
        promotionVO.promotionTimeVO.beginTime = LocalDateTime.now();
        promotionVO.promotionTimeVO.endTime = LocalDateTime.now().plusDays(2);
        promotionVO.discount = 0.9;

        ResultMessage resultMessage = tested.create(promotionVO);
    }

    @Test
    public void delete() throws Exception {
        tested.delete(100001);
    }

    @Test
    public void update() throws Exception {
        PromotionVO promotionVO = new PromotionVO();

        //说明：此处仅以生日优惠为例，ID一定要，其他看界面。
        promotionVO.promotionID = 999999;
        promotionVO.discount = 0.9;

        tested.update(promotionVO);
    }

    @Test
    public void viewPromotionList() throws Exception {
        List<PromotionVO> promotionVOList = tested.viewPromotionList(888888, PromotionType.BirthdayPromotion);
    }

}