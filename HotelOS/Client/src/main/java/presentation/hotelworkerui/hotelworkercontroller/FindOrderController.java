package presentation.hotelworkerui.hotelworkercontroller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.hotelworkerui.hotelworkerscene.OrderDetailPane;
import presentation.hotelworkerui.hotelworkerscene.UpdateCheckInPane;
import presentation.hotelworkerui.hotelworkerscene.UpdateOrderInfoPane;
import presentation.hotelworkerui.hotelworkerscene.UpdateOutPane;
import presentation.util.AlertController;
import util.OrderType;
import vo.order.OrderPriceVO;
import vo.order.OrderTimeVO;
import vo.order.OrderVO;

import java.time.LocalDateTime;

/**
 * Created by Hitiger on 2016/11/21.
 * Description :
 */
public class FindOrderController {
    //选择线上入住后显现的组件
    @FXML private ImageView findOrderImg;
    @FXML private TextField idorNameField;
    @FXML private Button findByIDorNameBtn;
    private Stage stage;
    private Pane mainPane;
    private Boolean isCheckIn;
    private AlertController alertController;
    public void launch(Stage primaryStage, Pane mainPane,Boolean isCheckIn) {
        this.stage = primaryStage;
        this.mainPane = mainPane;
        this.isCheckIn = isCheckIn;
        alertController = new AlertController();
    }

    @FXML private void closeWindow(){
        if(alertController.showConfirmExitAlert()) stage.close();
    }

    @FXML private void minWindow(){
        stage.setIconified(true);
    }

    @FXML private void back(){
        mainPane.getChildren().remove(0);
        if(isCheckIn){
            mainPane.getChildren().add(new UpdateCheckInPane(stage,mainPane));
        }else {
            mainPane.getChildren().add(new UpdateOutPane(stage,mainPane));
        }
    }

    /**
     * 搜索订单
     */
    @FXML private void findOrder(){
        OrderPriceVO orderPriceVO = new OrderPriceVO(250,200);
        OrderTimeVO orderTimeVO = new OrderTimeVO(LocalDateTime.of(2016,11,11,11,11),null,LocalDateTime.of(2016,11,12,8,00),LocalDateTime.of(2016,11,14,11,11),
                LocalDateTime.of(2016,11,15,11,11),LocalDateTime.of(2016,11,12,11,11),null,null);
        OrderTimeVO orderTimeVO2 = new OrderTimeVO(LocalDateTime.of(2016,11,11,11,00),LocalDateTime.of(2016,11,12,20,00),LocalDateTime.of(2016,11,12,20,30),LocalDateTime.of(2016,11,14,20,00),
                null,LocalDateTime.of(2016,11,12,21,00),LocalDateTime.of(2016,11,12,20,30),null);
        OrderVO orderVO = new OrderVO("12345678912345678", 123456, "user1", OrderType.Executed, "如家", null, "A110 A250", 2, false, null, orderTimeVO2, orderPriceVO, null);
        mainPane.getChildren().remove(0);
        mainPane.getChildren().add(new UpdateOrderInfoPane(stage,mainPane,isCheckIn,false,orderVO));
    }
}
