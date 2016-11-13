package blservice_driver;

import blservice.promotionblservice.PromotionBLService;
import blservice_stub.PromotionBLService_Stub;
import org.junit.Before;
import org.junit.Test;
import util.ResultMessage;
import vo.promotion.PromotionVO;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by kevin on 2016/10/16.
 */
public class PromotionBLService_Driver {
    PromotionBLService tested;

    @Before
    public void setUp() throws Exception {
        tested = new PromotionBLService_Stub();
    }

    @Test
    public void delete() throws Exception {
        assertEquals(ResultMessage.SUCCESS, tested.delete(1));
    }

    @Test
    public void update() throws Exception {
        assertEquals(ResultMessage.SUCCESS, tested.update(1));
    }

    @Test
    public void create() throws Exception {
        assertEquals(ResultMessage.SUCCESS, tested.create(new PromotionVO(1, "生日特惠", "折扣： 0.9")));
    }

    @Test
    public void showList() throws Exception {
        for(PromotionVO vo : tested.showList(1)) {
            printPromotionVO(vo);
        }
    }
    private void printPromotionVO(PromotionVO promotionVO){
        System.out.println(promotionVO.getPromotionID());
        System.out.println(promotionVO.getPromotionType());
        System.out.println(promotionVO.getPromotionInfo());
    }
}