package bl.promotionbl.impl;

import bl.promotionbl.PromotionBLService;
import org.junit.Before;
import org.junit.Test;
import util.PromotionType;
import vo.promotion.PromotionVO;

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

        promotionVO.hotelID = 522000;
    }

    @Test
    public void delete() throws Exception {

    }

    @Test
    public void update() throws Exception {

    }

    @Test
    public void viewPromotionList() throws Exception {
        List<PromotionVO> promotionVOList = tested.viewPromotionList(888888, PromotionType.BirthdayPromotion);
    }

}