package presentation.util.other;

import javafx.scene.control.Label;
import util.OrderType;

/**
 * Created by Hitiger on 2016/12/17.
 * Description :
 */
public class MyOrderLabel {

    public static void changeColor(OrderType orderType, Label orderTypeLabel){
        if(orderType == OrderType.Abnormal){
            orderTypeLabel.setStyle("-fx-text-fill: #ff2c14");
        }else if(orderType == OrderType.Unexecuted){
            orderTypeLabel.setStyle("-fx-text-fill: orange");
        }else orderTypeLabel.setStyle("-fx-text-fill: #00c100");
    }
}
