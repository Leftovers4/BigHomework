package util;

/**
 * Created by Hiki on 2016/10/16.
 */
public enum PromotionType {

    /**
     * Birthday hotel promotion type.
     */
    BIRTHDAY_HP,

    /**
     * Enterprise hotel promotion type.
     */
    ENTERPRISE_HP,

    /**
     * Multi rooms hotel promotion type.
     */
    MULTI_ROOMS_HP,

    /**
     * Special time hotel promotion type.
     */
    SPECIAL_TIME_HP,

    /**
     * User level web promotion type.
     */
    USER_LEVEL_WP,

    /**
     * Special time web promotion type.
     */
    SPECIAL_TIME_WP,

    /**
     * Vip special area web promotion type.
     */
    VIP_SPECIAL_AREA_WP,

    /**
     * Level strategy web promotion type.
     */
    LEVEL_STRATEGY_WP,

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
