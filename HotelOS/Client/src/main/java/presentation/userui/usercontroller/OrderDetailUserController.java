package presentation.userui.usercontroller;

import bl.orderbl.OrderBLService;
import bl.orderbl.impl.OrderBlServiceImpl;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.userui.userscene.CheckMyReviewPane;
import presentation.userui.userscene.EvaluateOrderPane;
import presentation.util.alert.AlertController;
import util.DateTimeFormat;
import util.EnumFactory;
import util.OrderType;
import util.ResultMessage;
import vo.order.OrderVO;
import vo.order.ReviewVO;

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

    @FXML private Label checkinbeforeLabel;
    @FXML private Label checkoutbeforeLabel;

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

    @FXML private Button cancelBtn;
    @FXML private Button checkMyReviewBtn;

    private OrderBLService orderBlService;

    private AlertController alertController;

    public void launch(Stage primaryStage, Pane mainPane, String userID, String orderID) {
        this.stage = primaryStage;
        this.mainPane = mainPane;
        this.orderID = orderID;
        this.userID = userID;

        alertController = new AlertController();

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
            ReviewVO reviewVO = orderBlService.viewOrderReview(orderID);

            OrderType orderType = orderVO.orderType;

            if (orderType == OrderType.Executed) {
                if (orderVO.orderTimeVO.leaveTime == null) {
                    checkinbeforeLabel.setText("入住时间：");
                    checkoutbeforeLabel.setText("预计离开时间：");
                    checkInTimeLabeldet.setText(orderVO.orderTimeVO.checkinTime.format(DateTimeFormat.dateTimeFormat));
                    checkOutTimeLabeldet.setText(orderVO.orderTimeVO.expectedLeaveTime.format(DateTimeFormat.dateTimeFormat));
                    evaluateBtn.setVisible(false);
                    checkMyReviewBtn.setVisible(false);
                } else {
                    checkinbeforeLabel.setText("入住时间：");
                    checkoutbeforeLabel.setText("离开时间：");
                    checkInTimeLabeldet.setText(orderVO.orderTimeVO.checkinTime.format(DateTimeFormat.dateTimeFormat));
                    checkOutTimeLabeldet.setText(orderVO.orderTimeVO.leaveTime.format(DateTimeFormat.dateTimeFormat));

                    if (reviewVO.reviewTime == null) {
                        evaluateBtn.setVisible(true);
                        checkMyReviewBtn.setVisible(false);
                    } else {
                        evaluateBtn.setVisible(false);
                        checkMyReviewBtn.setVisible(true);
                    }
                }

                cancelBtn.setVisible(false);
            } else {
                checkinbeforeLabel.setText("预计入住时间：");
                checkoutbeforeLabel.setText("预计离开时间：");
                checkInTimeLabeldet.setText(orderVO.orderTimeVO.expectedCheckinTime.format(DateTimeFormat.dateTimeFormat));
                checkOutTimeLabeldet.setText(orderVO.orderTimeVO.expectedLeaveTime.format(DateTimeFormat.dateTimeFormat));

                if (orderType == OrderType.Unexecuted) {
                    cancelBtn.setVisible(true);
                    evaluateBtn.setVisible(false);
                    checkMyReviewBtn.setVisible(false);
                } else {
                    cancelBtn.setVisible(false);
                    evaluateBtn.setVisible(false);
                    checkMyReviewBtn.setVisible(false);
                }
            }

            roomTypeLabeldet.setText(EnumFactory.getString(orderVO.roomType));
            roomNumLabeldet.setText(String.valueOf(orderVO.roomAmount));
            peopleNumLabeldet.setText(String.valueOf(orderVO.personAmount));
            childdet.setText(orderVO.withChildren ? "有" : "无");


            if (orderVO.orderPromoInfoVO.promotionType != null) {
                bestpromotionLabel.setText(EnumFactory.getString(orderVO.orderPromoInfoVO.promotionType));
            } else {
                bestpromotionLabel.setText("无");
            }

            finalpriceLabel.setText(String.valueOf(orderVO.orderPriceVO.actualPrice));
            ordertypeLabel.setText(EnumFactory.getString(orderVO.orderType));

            hotelNameLabel.setText(orderVO.hotelName);
            hotelAddressLabel.setText(orderVO.hotelAddress);
            if (orderVO.hotelService == null) {
                hotelServiceLabel.setText("");
            } else {
                hotelServiceLabel.setText(orderVO.hotelService);
            }

        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }


    @FXML
    private void evaluateOrder() {
        mainPane.getChildren().remove(0);
        mainPane.getChildren().add(new EvaluateOrderPane(stage, orderID, userID));
    }

    @FXML
    private void cancelOrderEvent() {
        boolean confirm = alertController.showConfirmDeleteAlert("确认撤销订单？", "撤销提示");

        if (confirm) {
            try {
                ResultMessage resultMessage = orderBlService.cancelOrder(orderID);

                if (resultMessage == ResultMessage.Success) {
                    System.out.println("cancel success");

                    initialData();
                } else {
                    System.out.println("cancel failed");
                }

            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

    }

    @FXML
    private void checkMyReviewEvent() {
        mainPane.getChildren().remove(0);
        mainPane.getChildren().add(new CheckMyReviewPane(orderID));
    }

    @FXML
    private void back(){
        mainPane.getChildren().remove(mainPane.getChildren().size()-1);
    }
}
