package presentation.userui.usercontroller;

import bl.orderbl.impl.OrderBlServiceImpl;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.userui.userscene.CheckMyReviewPane;
import presentation.userui.userscene.EvaluateOrderPane;
import util.DateTimeFormat;
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
            ReviewVO reviewVO = orderBlService.viewOrderReview(orderID);

            OrderType orderType = orderVO.orderType;

            if (orderType == OrderType.Executed) {
                if (orderVO.orderTimeVO.leaveTime == null) {
                    checkInTimeLabeldet.setText(orderVO.orderTimeVO.checkinTime.format(DateTimeFormat.dateTimeFormat));
                    checkOutTimeLabeldet.setText(orderVO.orderTimeVO.expectedLeaveTime.format(DateTimeFormat.dateTimeFormat));
                    evaluateBtn.setVisible(false);
                    checkMyReviewBtn.setVisible(false);
                } else {
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


            if (orderVO.orderPromoInfoVO.promotionType != null) {
                bestpromotionLabel.setText(orderVO.orderPromoInfoVO.promotionType.toString());
            } else {
                bestpromotionLabel.setText("无");
            }

            finalpriceLabel.setText(String.valueOf(orderVO.orderPriceVO.actualPrice));
            ordertypeLabel.setText(String.valueOf(orderVO.orderType));

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

    @FXML
    private void checkMyReviewEvent() {
        mainPane.getChildren().remove(0);
        mainPane.getChildren().add(new CheckMyReviewPane(orderID));
    }
}
