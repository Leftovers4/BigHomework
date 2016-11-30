package data.dao.promotiondata;

import data.dao.datafactory.DataFactoryServiceImpl;
import data.datahelper.promotiondatahelper.PromotionDataHelper;
import data.datahelper.promotiondatahelper.PromotionExtraInfoHelper.AddressDataHelper;
import data.datahelper.promotiondatahelper.PromotionExtraInfoHelper.EnterpriseDataHelper;
import data.datahelper.promotiondatahelper.PromotionExtraInfoHelper.MemberRegulationDataHelper;
import data.datahelper.promotiondatahelper.PromotionExtraInfoHelper.impl.AddressDataHelperImpl;
import data.datahelper.promotiondatahelper.PromotionExtraInfoHelper.impl.EnterpriseDataHelperImpl;
import data.datahelper.promotiondatahelper.PromotionExtraInfoHelper.impl.MemberRegulationDataHelperImpl;

/**
 * Created by Hiki on 11/30/2016.
 * PromotionDataServiceImpl的辅助类
 * 主要内容：地址、商圈、会员规则
 */
public class PromotionExtraDataService extends DataFactoryServiceImpl{

    // 需要调用的DataHelper
    private AddressDataHelper addDataHelper;

    private EnterpriseDataHelper entDataHelper;

    private MemberRegulationDataHelper mrDataHelper;

    public PromotionExtraDataService(){
        super();
        this.addDataHelper = new AddressDataHelperImpl();
        this.entDataHelper = new EnterpriseDataHelperImpl();
        this.mrDataHelper = new MemberRegulationDataHelperImpl();
    }

    // 调用


}
