package presentation.webmarketerui.webmarketercontroller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import presentation.util.AlertController;
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
    @FXML private Label orderPriceLabel;

    //生成时间
    @FXML private Label generateTimeLabel;

    //最晚执行时间
    @FXML private Label exeLeastTimeLabel;

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

    //查看客户评价
    @FXML private Button showReviewBtn;
    @FXML private Button backBtn;


    private Pane mainPane;
    private AlertController alertController;
    private OrderVO orderVO;
    //是否从更新入住信息进入
    private Boolean isCheckIn;
    //是否从订单列表进入
    private Boolean isFromList;

    public void launch(Pane mainPane,OrderVO orderVO) {
        this.mainPane = mainPane;
        this.orderVO = orderVO;
        this.isFromList = isFromList;
        this.isCheckIn = isCheckIn;
        alertController = new AlertController();

        //初始化便签
        initOrderLabel(orderVO);
    }

    private void initOrderLabel(OrderVO orderVO) {

        orderIDLabel.setText(orderVO.orderID);
        orderTypeLabel.setText(orderVO.orderType.toString());
        orderPriceLabel.setText(String.valueOf(orderVO.orderPriceVO.actualPrice));

        generateTimeLabel.setText(orderVO.orderTimeVO.generateTime.toString());
        exeLeastTimeLabel.setText(orderVO.orderTimeVO.lastExecuteTime.toString());
        checkInTimeLabel.setText(orderVO.orderTimeVO.checkinTime == null ? "尚未入住" : orderVO.orderTimeVO.checkinTime.toString());
        expLeaveTimeLabel.setText(orderVO.orderTimeVO.expectedLeaveTime == null ? "尚未入住" : orderVO.orderTimeVO.expectedLeaveTime.toString());
        actLeaveTimeLabel.setText(orderVO.orderTimeVO.leaveTime == null ? (orderVO.orderType == OrderType.Executed ? "尚未退房" : "尚未入住") : orderVO.orderTimeVO.leaveTime.toString());

        userNameLabel.setText(orderVO.username);
        peopleAmountLabel.setText(String.valueOf(orderVO.personAmount));
        withChildrenLabel.setText(orderVO.withChildren ? "有" : "无");
        roomIDLabel.setText(orderVO.roomNumber);
    }


    @FXML
    private void back(){
    }
}
