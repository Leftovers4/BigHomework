package presentation.webmarketerui.webmarketercontroller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.Pane;
import presentation.util.AlertController;
import vo.order.OrderVO;

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
    private RadioButton halfCreditBtn;
    @FXML
    private RadioButton allCreditBtn;
    @FXML
    private Button cancelAbnOrderBtn;

    private Pane mainPane;
    private AlertController alertController;

    public void launch(Pane mainPane, OrderVO orderVO) {
        this.mainPane = mainPane;
        alertController = new AlertController();
        initLabels(orderVO);
    }

    private void initLabels(OrderVO orderVO) {
        orderIdLabel.setText(orderVO.orderID);
        usernameLabel.setText(orderVO.username);
        hotelNameLabel.setText(orderVO.hotelName);
        webOrderPriceLabel.setText(String.valueOf(orderVO.orderPriceVO.actualPrice));

        webOrderTypeLabel.setText(orderVO.orderType.toString());
    }

}
