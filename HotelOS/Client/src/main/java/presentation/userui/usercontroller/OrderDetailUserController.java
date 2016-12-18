package presentation.userui.usercontroller;

import bl.hotelbl.HotelBLService;
import bl.hotelbl.impl.HotelBlServiceImpl;
import bl.orderbl.OrderBLService;
import bl.orderbl.impl.OrderBlServiceImpl;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.userui.userscene.CheckMyReviewPane;
import presentation.userui.userscene.EvaluateOrderPane;
import presentation.util.alert.AlertController;
import util.DateTimeFormat;
import util.EnumFactory;
import util.OrderType;
import util.ResultMessage;
import vo.hotel.HotelVO;
import vo.order.OrderVO;
import vo.order.ReviewVO;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.rmi.RemoteException;

/**
 * Created by wyj on 2016/11/25.
 * description: 订单详情
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

    @FXML private ImageView hotelPhoto;

    private OrderBLService orderBlService;
    private HotelBLService hotelBLService;

    private AlertController alertController;

    public void launch(Stage primaryStage, Pane mainPane, String userID, String orderID) {
        this.stage = primaryStage;
        this.mainPane = mainPane;
        this.orderID = orderID;
        this.userID = userID;

        alertController = new AlertController();

        try {
            orderBlService = new OrderBlServiceImpl();
            hotelBLService = new HotelBlServiceImpl();
        } catch (RemoteException e) {
            e.printStackTrace();
        }


        initialData();
        initPhoto();
    }

    private void initPhoto() {
        String newpath = "C:/Leftovers/client/user/hotelImg/";

        try {
            long hotelID = (orderBlService.searchExtraOrderByID(orderID)).hotelID;

            HotelVO hotelVO = hotelBLService.viewBasicHotelInfo(hotelID);

            if (hotelVO != null) {
                if (hotelVO.image != null) {
                    String path = newpath + hotelID + ".jpg";
                    File file = new File(path);

                    if (file.exists()) {
                        Image image = new Image("file:///"+path);
                        hotelPhoto.setImage(image);
                    }
                }
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
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

                    if (reviewVO == null) {
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

            colorOrderType(orderType);

        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }


    @FXML
    private void evaluateOrder() {
        mainPane.getChildren().add(new EvaluateOrderPane(stage, orderID, userID, mainPane));
    }

    @FXML
    private void cancelOrderEvent() {
        boolean confirm = alertController.showConfirmDeleteAlert("确认撤销订单？这可能会扣除你的信用值", "撤销提示");

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

    private void colorOrderType(OrderType orderType) {
        switch (orderType) {
            case Executed:
                ordertypeLabel.setStyle("-fx-text-fill: #2fe17f");
                break;
            case Unexecuted:
                ordertypeLabel.setStyle("-fx-text-fill: #fd9301");
                break;
            case Abnormal:
                ordertypeLabel.setStyle("-fx-text-fill: #dd3333");
                break;
            case Canceled:
                ordertypeLabel.setStyle("-fx-text-fill: crimson");
        }
    }

    @FXML
    private void checkMyReviewEvent() {
        mainPane.getChildren().add(new CheckMyReviewPane(orderID, mainPane));
    }

    @FXML
    private void back(){
        mainPane.getChildren().remove(mainPane.getChildren().size()-1);
    }
}
