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

    private final static Map<String, Enum> EnumMap = new HashMap<>();
    private final static Map<String, Enum> CreditChangedCauseMap = new HashMap<>();
    private final static Map<String, Enum> HandleAppealResultMap = new HashMap<>();
    private final static Map<String, Enum> MemberTypeMap = new HashMap<>();
    private final static Map<String, Enum> OrderTypeMap = new HashMap<>();
    private final static Map<String, Enum> PersonnelTypeMap = new HashMap<>();
    private final static Map<String, Enum> PromotionTypeMap = new HashMap<>();
    private final static Map<String, Enum> RoomTypeMap = new HashMap<>();




    static{
        // CreditChangedCause
        CreditChangedCauseMap.put("撤销订单", CreditChangedCause.CancelOrder);
        CreditChangedCauseMap.put("异常订单", CreditChangedCause.AbnormalOrder);
        CreditChangedCauseMap.put("执行订单", CreditChangedCause.ExecuteOrder);
        CreditChangedCauseMap.put("撤销异常订单", CreditChangedCause.CancelAbnormalOrder);
        CreditChangedCauseMap.put("信用充值", CreditChangedCause.Recharge);

        // HandleAppealResult
        HandleAppealResultMap.put("驳回", HandleAppealResult.Reject);
        HandleAppealResultMap.put("恢复所有信用值", HandleAppealResult.RecoverAll);
        HandleAppealResultMap.put("恢复一半信用值", HandleAppealResult.RecoverHalf);

        // MemberType
        MemberTypeMap.put("普通用户", MemberType.None);
        MemberTypeMap.put("普通会员", MemberType.NormalMember);
        MemberTypeMap.put("企业会员", MemberType.EnterpriseMember);
        MemberTypeMap.put("至尊会员", MemberType.Both);

        // OrderType
        OrderTypeMap.put("异常订单", OrderType.Abnormal);
        OrderTypeMap.put("已撤销订单", OrderType.Canceled);
        OrderTypeMap.put("已执行订单", OrderType.Executed);
        OrderTypeMap.put("未执行订单", OrderType.Unexecuted);

        // PersonnelType
        PersonnelTypeMap.put("酒店工作人员", PersonnelType.HotelWorker);
        PersonnelTypeMap.put("网站营销人员", PersonnelType.WebMarketer);
        PersonnelTypeMap.put("网站管理人员", PersonnelType.WebAdministrator);

        // PromotionType
        PromotionTypeMap.put("生日特惠折扣", PromotionType.BirthdayPromotion);
        PromotionTypeMap.put("多间预定特惠", PromotionType.MultipleRoomPromotion);
        PromotionTypeMap.put("特定期间折扣", PromotionType.SpecialTimePromotion);
        PromotionTypeMap.put("会员折扣", PromotionType.UserLevelPromotion);
        PromotionTypeMap.put("特定商圈优惠", PromotionType.VIPSpecialAreaPromotion);
        PromotionTypeMap.put("合作企业优惠", PromotionType.EnterprisePromotion);

        // RoomType
        RoomTypeMap.put("单人房", RoomType.Single);
        RoomTypeMap.put("双人房", RoomType.Couple);
        RoomTypeMap.put("标准房", RoomType.Standard);
        RoomTypeMap.put("套房", RoomType.Suite);
        RoomTypeMap.put("总统套房", RoomType.PresidentialSuite);
        RoomTypeMap.put("商务套房", RoomType.BusinessSuite);
        RoomTypeMap.put("大床房", RoomType.Queen);
        RoomTypeMap.put("家庭房", RoomType.Family);
        RoomTypeMap.put("情侣房", RoomType.Lover);
        RoomTypeMap.put("不限", RoomType.All);

        // AllEnum
        EnumMap.putAll(CreditChangedCauseMap);
        EnumMap.putAll(HandleAppealResultMap);
        EnumMap.putAll(MemberTypeMap);
        EnumMap.putAll(OrderTypeMap);
        EnumMap.putAll(PersonnelTypeMap);
        EnumMap.putAll(PromotionTypeMap);
        EnumMap.putAll(RoomTypeMap);

    }

    public static Enum getEnum(String name){
        return EnumMap.get(name);
    }

    public static String getString(Enum e) {
        // TODO： 注意key不要重复
        Set set = EnumMap.keySet();
        Iterator<String> iterator = set.iterator();
        while(iterator.hasNext()){
            String key = iterator.next();
            if(EnumMap.get(key).equals(e)){
                return key;
            }
        }

        return null;
    }

    public static Iterator<String> getAllRoomTypes(){
        return RoomTypeMap.keySet().iterator();
    }

}


