package presentation.hotelworkerui.hotelworkercontroller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.hotelworkerui.hotelworkerscene.FindOrderPane;
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
    @FXML private Label createTimeDayLabel;
    @FXML private Label createTimeMinLabel;

    //生成时间
    @FXML private Label exeLeastTimeDayLabel;
    @FXML private Label exeLeastTimeMinLabel;

    //实际离开时间
    @FXML private Label actLeaveTimeDayLabel;
    @FXML private Label actLeaveTimeMinLabel;
    @FXML private Label actLeaveTimeNullLabel;

    //入住时间
    @FXML private Label checkInTimeDayLabel;
    @FXML private Label checkInTimeMinLabel;
    @FXML private Label checkInTimeNullLabel;

    //预计离开时间
    @FXML private Label expLeaveTimeDayLabel;
    @FXML private Label expLeaveTimeMinLabel;
    @FXML private Label expLeaveTimeNullLabel;

    //入住房间信息
    @FXML private Label  peopleAmountLabel;
    @FXML private Label  withChildrenLabel;
    @FXML private Label  roomTypeLabel;
    @FXML private Label  roomAmountLabel;
    @FXML private Label  roomIDLabel;


    private Stage stage;
    private Pane mainPane;
    private OrderVO orderVO;

    public void launch(Stage primaryStage, Pane mainPane,OrderVO orderVO) {
        this.stage = primaryStage;
        this.mainPane = mainPane;
        this.orderVO = orderVO;

    }

    @FXML
    private void closeWindow(){
        stage.close();
    }

    @FXML
    private void minWindow(){
        stage.setIconified(true);
    }

    @FXML
    private void back(){
//        mainPane.getChildren().remove(0);
//        mainPane.getChildren().add(new FindOrderPane(stage,mainPane));
    }
}
