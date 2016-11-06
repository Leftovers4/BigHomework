package blservice_driver;

import blservice.promotionblservice.PromotionBLService;
import org.junit.Before;
import org.junit.Test;
import util.PromotionType;
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

    }

    @Test
    public void find() throws Exception {
        PromotionVO res = tested.find(1);
        printPromotionVO(res);
    }

    @Test
    public void getHotelPromList() throws Exception {
        ArrayList<PromotionVO> res = tested.getHotelPromList(123456);
        for (int i = 0; i < res.size(); i++) {
            printPromotionVO(res.get(i));
        }
    }

    @Test
    public void getWebPromList() throws Exception {
        ArrayList<PromotionVO> res = tested.getWebPromList();
        for (int i = 0; i < res.size(); i++) {
            printPromotionVO(res.get(i));
        }
    }

    @Test
    public void add() throws Exception {
        assertEquals(ResultMessage.SUCCESS, tested.add(new PromotionVO(1, "生日特惠", "折扣： 0.9")));
    }

    @Test
    public void del() throws Exception {
        assertEquals(ResultMessage.SUCCESS, tested.del(new PromotionVO(1, "生日特惠", "折扣： 0.9")));
    }

    @Test
    public void modify() throws Exception {
        assertEquals(ResultMessage.SUCCESS, tested.modify(new PromotionVO(1, "生日特惠", "折扣： 0.9")));
    }

    private void printPromotionVO(PromotionVO promotionVO){
        System.out.println(promotionVO.getPromotionID());
        System.out.println(promotionVO.getPromotionType());
        System.out.println(promotionVO.getPromotionInfo());
    }
}