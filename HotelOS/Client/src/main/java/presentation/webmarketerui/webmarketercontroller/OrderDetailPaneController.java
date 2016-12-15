package presentation.webmarketerui.webmarketercontroller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import presentation.util.alert.AlertController;
import presentation.webmarketerui.webmarketerscene.OrderListPane;
import util.DateTimeFormat;
import util.EnumFactory;
import util.OrderType;
import vo.order.OrderVO;

/**
 * Created by Hitiger on 2016/11/20.
 * Description :
 */
public class OrderDetailPaneController {

    //订单号、状态、价格
    @FXML private Label orderIDLabel;
    @FXML private Label orderTypeLabel;
    @FXML private Label orderOriPriceLabel;
    @FXML private Label orderProLabel;
    @FXML private Label orderActPriceLabel;

    //生成时间
    @FXML private Label generateTimeLabel;

    //最晚执行时间
    @FXML private Label lastExecuteTimeLabel;

    //实际离开时间
    @FXML private Label actLeaveTimeLabel;

    //入住时间
    @FXML private Label checkInTimeLabel;

    //预计离开时间
    @FXML private Label expLeaveTimeLabel;

    //客户名、入住房间信息
    @FXML private Label userNameLabel;
    @FXML private Label peopleAmountLabel;
    @FXML private Label withChildrenLabel;
    @FXML private Label roomTypeLabel;
    @FXML private Label roomAmountLabel;
    @FXML private Label roomIDLabel;

    private Pane mainPane;

    public void launch(Pane mainPane,OrderVO orderVO) {
        this.mainPane = mainPane;

        //初始化便签
        initOrderLabel(orderVO);
    }

    private void initOrderLabel(OrderVO orderVO) {
        orderIDLabel.setText(orderVO.orderID);
        orderTypeLabel.setText(EnumFactory.getString(orderVO.orderType));
        orderOriPriceLabel.setText(String.valueOf(orderVO.orderPriceVO.originPrice));
        orderProLabel.setText(String.valueOf(orderVO.orderPromoInfoVO.promotionType == null ? "无优惠" : EnumFactory.getString(orderVO.orderPromoInfoVO.promotionType)));
        orderActPriceLabel.setText(String.valueOf(orderVO.orderPriceVO.actualPrice));

        generateTimeLabel.setText(orderVO.orderTimeVO.generateTime.format(DateTimeFormat.dateHourFormat));
        lastExecuteTimeLabel.setText(orderVO.orderTimeVO.lastExecuteTime.format(DateTimeFormat.dateHourFormat));
        checkInTimeLabel.setText(orderVO.orderTimeVO.checkinTime == null ? "尚未入住" : orderVO.orderTimeVO.checkinTime.format(DateTimeFormat.dateHourFormat));
        expLeaveTimeLabel.setText(orderVO.orderTimeVO.expectedLeaveTime == null ? "尚未入住" : orderVO.orderTimeVO.expectedLeaveTime.format(DateTimeFormat.dateHourFormat));
        actLeaveTimeLabel.setText(orderVO.orderTimeVO.leaveTime == null ? (orderVO.orderType == OrderType.Executed ? "尚未退房" : "尚未入住") : orderVO.orderTimeVO.leaveTime.format(DateTimeFormat.dateHourFormat));

        roomTypeLabel.setText(EnumFactory.getString(orderVO.roomType));
        roomAmountLabel.setText(String.valueOf(orderVO.roomAmount));
        roomIDLabel.setText(orderVO.roomNumber == null ? "" : orderVO.roomNumber);
        userNameLabel.setText(orderVO.username);
        withChildrenLabel.setText(orderVO.withChildren ? "有" : "无");
        peopleAmountLabel.setText(String.valueOf(orderVO.personAmount));
    }


    @FXML
    private void back(){
        mainPane.getChildren().clear();
        mainPane.getChildren().add(new OrderListPane(mainPane));
    }
}
