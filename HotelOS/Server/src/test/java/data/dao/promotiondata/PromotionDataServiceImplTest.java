package data.dao.promotiondata;

import com.sun.org.apache.bcel.internal.generic.POP;
import data.datahelper.promotiondatahelper.PromotionDataHelperImpl;
import org.junit.Before;
import org.junit.Test;
import po.promotion.PromotionPO;
import util.CommonMethod;
import util.POProducer;
import util.ResultMessage;

import java.awt.geom.RectangularShape;
import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Hiki on 12/4/2016.
 */
public class PromotionDataServiceImplTest {

    PromotionDataServiceImpl tested;

    @Before
    public void setUp() throws Exception {
        tested = new PromotionDataServiceImpl();
    }

    @Test
    public void insert() throws Exception {
        ResultMessage resultMessage = tested.insert(POProducer.getPromotionPO());
        System.out.println(resultMessage.toString());
    }

    @Test
    public void delete() throws Exception {
        ResultMessage resultMessage = tested.delete(POProducer.getPromotionPO().getPromotionID());
        System.out.println(resultMessage.toString());
    }

    @Test
    public void update() throws Exception {
        ResultMessage resultMessage = tested.update(POProducer.getPromotionPO());
        System.out.println(resultMessage.toString());
    }

    @Test
    public void findAll() throws Exception {
        ArrayList<PromotionPO> promotionPOs = tested.findAll();
        for (PromotionPO each : promotionPOs) {
            CommonMethod.printClass(each);
        }

    }

    @Test
    public void findByHotelID() throws Exception {
        ArrayList<PromotionPO> promotionPOs = tested.findByHotelID(POProducer.getPromotionPO().getHotelID());
        for (PromotionPO each : promotionPOs) {
            CommonMethod.printClass(each);
        }
    }

    @Test
    public void findAllWebPromotion() throws Exception {
        ArrayList<PromotionPO> promotionPOs = tested.findAllWebPromotion();
        for (PromotionPO each : promotionPOs) {
            CommonMethod.printClass(each);
        }
    }

    @Test
    public void findByHotelIDAndType() throws Exception {
        ArrayList<PromotionPO> promotionPOs = tested.findByHotelIDAndType(POProducer.getPromotionPO().getHotelID(), POProducer.getPromotionPO().getPromotionType());
        for (PromotionPO each : promotionPOs) {
            CommonMethod.printClass(each);
        }
    }

    @Test
    public void findByPromotionID() throws Exception {
        PromotionPO promotionPO = tested.findByPromotionID(POProducer.getPromotionPO().getPromotionID());
        if(promotionPO != null){
            CommonMethod.printClass(promotionPO);
        }
    }

}