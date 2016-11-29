package dataservice_driver;

import dataservice.promotiondataservice.PromotionDataService;
import org.junit.Before;
import org.junit.Test;
import po.promotion.PromotionPO;
import util.PromotionType;

import java.util.ArrayList;

/**
 * Created by kevin on 2016/10/16.
 */
public class PromotionDataService_Driver {
    PromotionDataService tested;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void findByHotelID() throws Exception {
        ArrayList<PromotionPO> res = tested.findByHotelID(123456);
        for (int i = 0; i < res.size(); i++) {
            printPromotionPO(res.get(i));
        }
    }


    @Test
    public void findByPromotionID() throws Exception {
        PromotionPO res = tested.findByPromotionID(1);
        printPromotionPO(res);
    }

    @Test
    public void insert() throws Exception {

    }

    @Test
    public void delete() throws Exception {

    }

    @Test
    public void update() throws Exception {

    }

    private void printPromotionPO(PromotionPO promotionPO){
        System.out.println(promotionPO.getPromotionID());
        System.out.println(promotionPO.getPromotionType());
        System.out.println(promotionPO.getBeginTime());
        System.out.println(promotionPO.getEndTime());
        System.out.println(promotionPO.getDiscount());
    }
}