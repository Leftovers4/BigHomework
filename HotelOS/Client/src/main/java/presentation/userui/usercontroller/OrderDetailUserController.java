package presentation.userui.usercontroller;

import bl.orderbl.impl.OrderBlServiceImpl;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.userui.userscene.EvaluateOrderPane;
import util.DateTimeFormat;
import util.OrderType;
import vo.order.OrderVO;

import java.lang.reflect.InvocationTargetException;
import java.rmi.RemoteException;

/**
 * Created by wyj on 2016/11/25.
 */
public class OrderDetailUserController {

    private Stage stage;
    private Pane mainPane;
    private String orderID;
    private String userID;

    @FXML private Label checkInTimeLabeldet;
    @FXML private Label checkOutTimeLabeldet;
    @FXML private Label roomTypeLabeldet;
    @FXML private Label roomNumLabeldet;
    @FXML private Label peopleNumLabeldet;
    @FXML private Label childdet;
    @FXML private Label bestpromotionLabel;
    @FXML private Label finalpriceLabel;
    @FXML private Label ordertypeLabel;
    @FXML private Button evaluateBtn;

    @FXML private Label hotelNameLabel;
    @FXML private Label hotelAddressLabel;
    @FXML private Label hotelServiceLabel;

    private OrderBlServiceImpl orderBlService;

    public void launch(Stage primaryStage, Pane mainPane, String userID, String orderID) {
        this.stage = primaryStage;
        this.mainPane = mainPane;
        this.orderID = orderID;
        this.userID = userID;

        try {
            orderBlService = new OrderBlServiceImpl();
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        initialData();
    }

    private void initialData() {
        try {
            OrderVO orderVO = orderBlService.searchExtraOrderByID(orderID);

            OrderType orderType = orderVO.orderType;

            if (orderType == OrderType.Executed) {
                checkInTimeLabeldet.setText(orderVO.orderTimeVO.checkinTime.format(DateTimeFormat.dateTimeFormat));
                checkOutTimeLabeldet.setText(orderVO.orderTimeVO.leaveTime.format(DateTimeFormat.dateTimeFormat));
            } else {
                checkInTimeLabeldet.setText(orderVO.orderTimeVO.expectedCheckinTime.format(DateTimeFormat.dateTimeFormat));
                checkOutTimeLabeldet.setText(orderVO.orderTimeVO.expectedLeaveTime.format(DateTimeFormat.dateTimeFormat));
            }

            roomTypeLabeldet.setText(orderVO.roomType.toString());
            roomNumLabeldet.setText(String.valueOf(orderVO.roomAmount));
            peopleNumLabeldet.setText(String.valueOf(orderVO.personAmount));
            childdet.setText(orderVO.withChildren ? "有" : "无");

            try {
                orderBlService.getOrderActualPrice(orderVO);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }

            bestpromotionLabel.setText(orderVO.orderPromoInfoVO.promotionType.toString());

            finalpriceLabel.setText(String.valueOf(orderVO.orderPriceVO.actualPrice));
            ordertypeLabel.setText(String.valueOf(orderVO.orderType));

            hotelNameLabel.setText(orderVO.hotelName);
            hotelAddressLabel.setText(orderVO.hotelAddress);
            hotelServiceLabel.setText(orderVO.hotelService);

        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }


    @FXML
    private void evaluateOrder() {
        mainPane.getChildren().remove(0);
        mainPane.getChildren().add(new EvaluateOrderPane(stage, orderID));
    }
}
