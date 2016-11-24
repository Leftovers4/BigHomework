package util;

import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Hiki on 11/24/2016.
 * Enum工厂，用于通过name获取Enum
 */
public class EnumFactory {

    private final static Map<String, Enum> enumMap = new HashMap<>();

    static{
        // CreditChangedCause
        enumMap.put("CancelOrder", CreditChangedCause.CancelOrder);
        enumMap.put("AbnormalOrder", CreditChangedCause.AbnormalOrder);
        enumMap.put("ExecuteOrder", CreditChangedCause.ExecuteOrder);
        enumMap.put("CancelAbnormalOrder", CreditChangedCause.CancelAbnormalOrder);
        enumMap.put("Recharge", CreditChangedCause.Recharge);

        // HandleAppealResult
        enumMap.put("Reject", HandleAppealResult.Reject);
        enumMap.put("All", HandleAppealResult.All);
        enumMap.put("Half", HandleAppealResult.Half);

        // MemberType
        enumMap.put("None", MemberType.None);
        enumMap.put("NormalMember", MemberType.NormalMember);
        enumMap.put("EnterpriseMember", MemberType.EnterpriseMember);
        enumMap.put("MemberType.Both", MemberType.Both);

        // OrderType
        enumMap.put("Abnormal", OrderType.Abnormal);
        enumMap.put("Canceled", OrderType.Canceled);
        enumMap.put("Executed", OrderType.Executed);
        enumMap.put("Unexecuted", OrderType.Unexecuted);

        // PersonnelType
        enumMap.put("HotelWorker", PersonnelType.HotelWorker);
        enumMap.put("WebMarketer", PersonnelType.WebMarketer);
        enumMap.put("WebAdministrator", PersonnelType.WebAdministrator);

        // PromotionType
        enumMap.put("BirthdayPromotion", PromotionType.BirthdayPromotion);
        enumMap.put("MultipleRoomPromotion", PromotionType.MultipleRoomPromotion);
        enumMap.put("SpecialTimePromotion", PromotionType.SpecialTimePromotion);
        enumMap.put("UserLevelPromotion", PromotionType.UserLevelPromotion);
        enumMap.put("VIPSpecialAreaPromotion", PromotionType.VIPSpecialAreaPromotion);
        enumMap.put("EnterprisePromotion", PromotionType.EnterprisePromotion);

        // RoomType
        enumMap.put("Single", RoomType.Single);
        enumMap.put("Couple", RoomType.Couple);

    }

    public static Enum getEnum(String name){
        return enumMap.get(name);
    }


}


