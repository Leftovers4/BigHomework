package util;

/**
 * Created by Hiki on 2016/10/16.
 */
public enum PromotionType {



    BirthdayPromotion,

    MultipleRoomPromotion,

    SpecialTimePromotion,

    UserLevelPromotion,

    VIPSpecialAreaPromotion,

    EnterprisePromotion;

    public static PromotionType getType(String name) {
        switch (name) {
            case "BirthdayPromotion":
                return PromotionType.BirthdayPromotion;
            case "MultipleRoomPromotion":
                return PromotionType.MultipleRoomPromotion;
            case "SpecialTimePromotion":
                return PromotionType.SpecialTimePromotion;
            case "UserLevelPromotion":
                return PromotionType.UserLevelPromotion;
            case "VIPSpecialAreaPromotion":
                return PromotionType.VIPSpecialAreaPromotion;
            case "EnterprisePromotion":
                return PromotionType.EnterprisePromotion;

        }
        // TODO：这种方式可能会导致错误，需要对输入有极高的准确性要求
        return null;
    }



}
