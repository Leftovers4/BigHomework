package util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by Hiki on 11/24/2016.
 * Enum工厂，用于通过name获取Enum
 */
public class EnumFactory {

    private final static Map<String, Enum> enumMap = new HashMap<>();

    static{
        // CreditChangedCause
        enumMap.put("撤销订单", CreditChangedCause.CancelOrder);
        enumMap.put("异常订单", CreditChangedCause.AbnormalOrder);
        enumMap.put("执行订单", CreditChangedCause.ExecuteOrder);
        enumMap.put("撤销异常订单", CreditChangedCause.CancelAbnormalOrder);
        enumMap.put("信用充值", CreditChangedCause.Recharge);

        // HandleAppealResult
        enumMap.put("驳回", HandleAppealResult.Reject);
        enumMap.put("恢复所有信用值", HandleAppealResult.All);
        enumMap.put("恢复一半信用值", HandleAppealResult.Half);

        // MemberType
        enumMap.put("普通用户", MemberType.None);
        enumMap.put("普通会员", MemberType.NormalMember);
        enumMap.put("企业会员", MemberType.EnterpriseMember);
        enumMap.put("至尊会员", MemberType.Both);

        // OrderType
        enumMap.put("异常订单", OrderType.Abnormal);
        enumMap.put("已撤销订单", OrderType.Canceled);
        enumMap.put("已执行订单", OrderType.Executed);
        enumMap.put("未执行订单", OrderType.Unexecuted);

        // PersonnelType
        enumMap.put("酒店工作人员", PersonnelType.HotelWorker);
        enumMap.put("网站营销人员", PersonnelType.WebMarketer);
        enumMap.put("网站管理人员", PersonnelType.WebAdministrator);

        // PromotionType
        enumMap.put("生日特惠折扣", PromotionType.BirthdayPromotion);
        enumMap.put("多间预定特惠", PromotionType.MultipleRoomPromotion);
        enumMap.put("特定期间折扣", PromotionType.SpecialTimePromotion);
        enumMap.put("会员折扣", PromotionType.UserLevelPromotion);
        enumMap.put("特定商圈优惠", PromotionType.VIPSpecialAreaPromotion);
        enumMap.put("合作企业优惠", PromotionType.EnterprisePromotion);

        // RoomType
        enumMap.put("单人房", RoomType.Single);
        enumMap.put("双人房", RoomType.Couple);
        enumMap.put("标准房", RoomType.Standard);
        enumMap.put("套房", RoomType.Suite);
        enumMap.put("总统套房", RoomType.PresidentialSuite);
        enumMap.put("商务套房", RoomType.BusinessSuite);
        enumMap.put("大床房", RoomType.Queen);
        enumMap.put("家庭房", RoomType.Family);
        enumMap.put("情侣房", RoomType.Lover);
        enumMap.put("不限", RoomType.All);
    }

    public static Enum getEnum(String name){
        return enumMap.get(name);
    }

    public static String getString(Enum e) {
        // TODO： 注意key不要重复
        Set set = enumMap.keySet();
        Iterator<String> iterator = set.iterator();
        while(iterator.hasNext()){
            String key = iterator.next();
            if(enumMap.get(key).equals(e)){
                return key;
            }
        }

        return null;

    }

}


