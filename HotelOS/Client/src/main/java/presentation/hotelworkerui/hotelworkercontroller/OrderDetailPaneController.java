package presentation.hotelworkerui.hotelworkercontroller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import presentation.hotelworkerui.hotelworkerscene.FindOrderPane;
import presentation.hotelworkerui.hotelworkerscene.OrderListPane;
import presentation.hotelworkerui.hotelworkerscene.UserReviewPane;
import presentation.util.alert.AlertController;
import util.DateTimeFormat;
import util.OrderType;
import vo.order.OrderVO;

import java.time.format.DateTimeFormatter;

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

    //查看客户评价
    @FXML private Button showReviewBtn;


    private Pane mainPane;
    private AlertController alertController;
    private OrderVO orderVO;
    //是否从更新入住信息进入
    private Boolean isCheckIn;
    //是否从订单列表进入
    private Boolean isFromList;

    public void launch(Pane mainPane,Boolean isCheckIn,Boolean isFromList,OrderVO orderVO) {
        this.mainPane = mainPane;
        this.isFromList = isFromList;
        this.isCheckIn = isCheckIn;
        this.orderVO = orderVO;
        alertController = new AlertController();

        //初始化便签
        initOrderLabel(orderVO);
        initReviewBtn(orderVO.orderType);
    }

    private void initOrderLabel(OrderVO orderVO) {

        orderIDLabel.setText(orderVO.orderID);
        orderTypeLabel.setText(orderVO.orderType.toString());
        orderOriPriceLabel.setText(String.valueOf(orderVO.orderPriceVO.originPrice));
//      TODO  orderProLabel.setText();
        orderActPriceLabel.setText(String.valueOf(orderVO.orderPriceVO.actualPrice));

        generateTimeLabel.setText(orderVO.orderTimeVO.generateTime.format(DateTimeFormat.dateHourFormat));
        lastExecuteTimeLabel.setText(orderVO.orderTimeVO.lastExecuteTime.format(DateTimeFormat.dateHourFormat));
        checkInTimeLabel.setText(orderVO.orderTimeVO.checkinTime == null ? "尚未入住" : orderVO.orderTimeVO.checkinTime.format(DateTimeFormat.dateHourFormat));
        expLeaveTimeLabel.setText(orderVO.orderTimeVO.expectedLeaveTime == null ? "尚未入住" : orderVO.orderTimeVO.expectedLeaveTime.format(DateTimeFormat.dateHourFormat));
        actLeaveTimeLabel.setText(orderVO.orderTimeVO.leaveTime == null ? (orderVO.orderType == OrderType.Executed ? "尚未退房" : "尚未入住") : orderVO.orderTimeVO.leaveTime.format(DateTimeFormat.dateHourFormat));

        userNameLabel.setText(orderVO.username);
        withChildrenLabel.setText(orderVO.withChildren ? "有" : "无");
        peopleAmountLabel.setText(String.valueOf(orderVO.personAmount));
        roomTypeLabel.setText(String.valueOf(orderVO.roomType));
        roomAmountLabel.setText(String.valueOf(orderVO.roomAmount));
        roomIDLabel.setText(orderVO.roomNumber);
    }

    private void initReviewBtn(OrderType orderType) {
        if(orderType != OrderType.Executed) showReviewBtn.setVisible(false);
    }

    @FXML
    private void showReview(){
        mainPane.getChildren().clear();
        mainPane.getChildren().add(new UserReviewPane(mainPane,isCheckIn,isFromList,orderVO));
    }

    @FXML
    private void back(){
        mainPane.getChildren().clear();
        if(isFromList) {
            mainPane.getChildren().add(new OrderListPane(mainPane));
        }else {
            if(isCheckIn) mainPane.getChildren().add(new FindOrderPane(mainPane,isCheckIn));
        }
    }
}
