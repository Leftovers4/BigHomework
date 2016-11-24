package util;

/**
 * Created by Hiki on 2016/10/16.
 */
public enum OrderType {


    /**
     * 未执行订单
     */
    Unexecuted,

    /**
     * 已执行订单
     */
    Executed,

    /**
     * 异常订单
     */
    Abnormal,

    /**
     * 已撤销订单
     */
    Canceled;

    public static OrderType getType(String name) {
        switch (name) {
            case "Unexecuted":
                return OrderType.Unexecuted;
            case "Executed":
                return OrderType.Executed;
            case "Abnormal":
                return OrderType.Abnormal;
            case "Canceled":
                return OrderType.Canceled;
        }
        // TODO：这种方式可能会导致错误，需要对输入有极高的准确性要求
        return null;
    }

}
