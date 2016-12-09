package presentation.webmarketerui.webmarketercontroller;

import bl.orderbl.OrderBLService;
import bl.orderbl.impl.OrderBlServiceImpl;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.Pane;
import presentation.util.alert.AlertController;
import presentation.webmarketerui.webmarketerscene.FindOrderPane;
import util.OrderType;
import util.ResultMessage;
import vo.order.OrderVO;

import java.rmi.RemoteException;

/**
 * Created by Hitiger on 2016/11/28.
 * Description :
 */
public class AppealOrderPaneController {

    @FXML
    private Label webOrderPriceLabel;
    @FXML
    private Label orderIdLabel;
    @FXML
    private Label usernameLabel;
    @FXML
    private Label hotelNameLabel;
    //撤销异常订单
    @FXML
    private Label webOrderTypeLabel;
    @FXML
    private RadioButton allCreditBtn;
    @FXML
    private Button cancelAbnOrderBtn;

    private Pane mainPane;
    private AlertController alertController;
    private OrderBLService orderBLService;
    private String orderID;

    public void launch(Pane mainPane, OrderVO orderVO) {
        this.mainPane = mainPane;
        this.orderID =orderVO.orderID;

        alertController = new AlertController();
        initService();
        initLabels(orderVO);
    }

    private void initService() {
        try {
            orderBLService = new OrderBlServiceImpl();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }


    private void initLabels(OrderVO orderVO) {
        orderIdLabel.setText(orderVO.orderID);
        usernameLabel.setText(orderVO.username);
        hotelNameLabel.setText(orderVO.hotelName);
        webOrderPriceLabel.setText(String.valueOf(orderVO.orderPriceVO.actualPrice));

        webOrderTypeLabel.setText(orderVO.orderType.toString());

        if(orderVO.orderType != OrderType.Abnormal){
            cancelAbnOrderBtn.setDisable(true);
            webOrderTypeLabel.setStyle("-fx-text-fill: green");
        }else {
            cancelAbnOrderBtn.setDisable(false);
            webOrderTypeLabel.setStyle("-fx-text-fill: #ff2c14");
        }
    }

    //TODO
    @FXML
    private void cancelAbnOrder(){
        if(allCreditBtn.isSelected()){
            try {
                ResultMessage resultMessage = orderBLService.handleAppeal(orderID, 1);
                if(resultMessage == ResultMessage.Success){
                    if(alertController.showUpdateSuccessAlert("订单申诉成功，返回客户全部信用值","申诉成功")){
                        cancelAbnOrderBtn.setDisable(true);
                        webOrderTypeLabel.setStyle("-fx-text-fill: green");
                        webOrderTypeLabel.setText(OrderType.Canceled.toString());
                    }
                }
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }else {
            try {
                ResultMessage resultMessage = orderBLService.handleAppeal(orderID, 0.5);
                if(resultMessage == ResultMessage.Success){
                    if(alertController.showUpdateSuccessAlert("订单申诉成功，返回客户一半信用值","申诉成功")){
                        cancelAbnOrderBtn.setDisable(true);
                        webOrderTypeLabel.setStyle("-fx-text-fill: green");
                        webOrderTypeLabel.setText(OrderType.Canceled.toString());
                    }
                }
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }
}
