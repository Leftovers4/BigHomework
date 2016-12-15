package presentation.userui.usercontroller;

import bl.orderbl.impl.OrderBlServiceImpl;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import presentation.util.alert.AlertController;
import util.DateTimeFormat;
import util.ResultMessage;
import vo.order.OrderVO;

import java.rmi.RemoteException;

/**
 * Created by wyj on 2016/11/25.
 */
public class CancelOrderController {

    private Stage stage;
    private String orderID;

    @FXML private Label checkintimeLabelcan;
    @FXML private Label checkouttimeLabelcan;
    @FXML private Label roomTypeLabelcan;
    @FXML private Label roomNumLabelcan;
    @FXML private Label peopleNumLabelcan;
    @FXML private Label bestpromotionLabelcan;
    @FXML private Label finalpriceLabel;
    @FXML private Label childLabelcan;
    @FXML private Label ordertypeLabel;
    @FXML private Label hotelNameLabel;
    @FXML private Label hotelAddressLabel;
    @FXML private Label hotelServiceLabel;

    private OrderBlServiceImpl orderBlService;

    private AlertController alertController;

    public void launch(Stage primaryStage, String orderID) {
        this.stage = primaryStage;
        this.orderID = orderID;

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

            checkintimeLabelcan.setText(orderVO.orderTimeVO.expectedCheckinTime.format(DateTimeFormat.dateTimeFormat));
            checkouttimeLabelcan.setText(orderVO.orderTimeVO.expectedLeaveTime.format(DateTimeFormat.dateTimeFormat));
            roomTypeLabelcan.setText(String.valueOf(orderVO.roomType));
            roomNumLabelcan.setText(String.valueOf(orderVO.roomAmount));
            childLabelcan.setText(orderVO.withChildren ? "有" : "无");
            peopleNumLabelcan.setText(String.valueOf(orderVO.personAmount));
            if (orderVO.orderPromoInfoVO.promotionType == null) {
                bestpromotionLabelcan.setText("无");
            } else {
                bestpromotionLabelcan.setText(orderVO.orderPromoInfoVO.promotionType.toString());
            }
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
    private void cancelOrderEvent() {
        boolean confirm = alertController.showConfirmDeleteAlert("确认撤销？", "撤销提示");

        if (confirm) {
            try {
                ResultMessage resultMessage = orderBlService.cancelOrder(orderID);

                if (resultMessage == ResultMessage.Success) {
                    System.out.println("cancel success");
                    alertController.showUpdateSuccessAlert("撤销成功！", "撤销提示");
                    initialData();
                } else {
                    System.out.println("cancel failed");
                }

            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }
}
