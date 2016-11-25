package presentation.hotelworkerui.hotelworkercontroller;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.hotelworkerui.hotelworkerscene.FindOrderPane;
import presentation.hotelworkerui.hotelworkerscene.OrderListPane;
import vo.order.OrderVO;

/**
 * Created by Hitiger on 2016/11/22.
 * Description :
 */
public class UpdateOrderInfoPaneController {
    //订单号、状态、价格
    @FXML private Label orderIDLabel;
    @FXML private Label orderTypeLabel;
    @FXML private Label orderPriceLabel;

    //生成时间
    @FXML private Label generateTimeLabel;

    //最晚执行时间
    @FXML private Label exeLeastTimeLabel;

    //入住时间
    @FXML private Label      checkInTimeLabel;
    @FXML private DatePicker checkinTimeDatePicker;
    @FXML private TextField  checkinTimeField;

    //预计离开时间
    @FXML private Label      expLeaveTimeLabel;
    @FXML private DatePicker expLeaveTimeDatePicker;
    @FXML private TextField  expLeaveTimeField;

    //实际离开时间
    @FXML private Label      actLeaveTimeLabel;
    @FXML private DatePicker actLeaveTimeDatePicker;
    @FXML private TextField  actLeaveTimeField;

    //客户名、入住房间信息
    @FXML private Label userNameLabel;
    @FXML private Label peopleAmountLabel;
    @FXML private Label withChildrenLabel;
    @FXML private Label roomTypeLabel;
    @FXML private Label roomAmountLabel;
    @FXML private Label roomIDLabel;
    @FXML private TextField roomIDField;

    private Stage stage;
    private Pane mainPane;
    private Boolean isCheckIn;
    private Boolean isFromList;

    public void launch(Stage primaryStage, Pane mainPane , Boolean isCheckIn,Boolean isFromList, OrderVO orderVO) {
        this.stage = primaryStage;
        this.mainPane = mainPane;
        this.isCheckIn = isCheckIn;
        this.isFromList = isFromList;

        setActLeaveTimeComponentsVisible(!isCheckIn);
        setCheckinTimeComponentsVisible(isCheckIn);
        setExpLeaveTimeComponentsVisible(isCheckIn);
        setRoomComponentsVisible(isCheckIn);

        //初始化组件
        initComponents(orderVO);
    }

    private void initComponents(OrderVO orderVO) {
        orderIDLabel.setText(orderVO.orderID);
        orderTypeLabel.setText(orderVO.orderType.toString());
        orderPriceLabel.setText(String.valueOf(orderVO.orderPriceVO.actualPrice));

        generateTimeLabel.setText(orderVO.orderTimeVO.generateTime.toString());
        exeLeastTimeLabel.setText(orderVO.orderTimeVO.lastExecuteTime.toString());

        userNameLabel.setText(orderVO.username);
        peopleAmountLabel.setText(String.valueOf(orderVO.personAmount));
        withChildrenLabel.setText(orderVO.withChildren ? "有" : "无");
//        roomTypeLabel.setText();
//        roomAmountLabel;
    }

    @FXML
    private void submitUpdate(){

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
        mainPane.getChildren().remove(0);
        if(isFromList){
            mainPane.getChildren().add(new OrderListPane(stage,mainPane));
        }else mainPane.getChildren().add(new FindOrderPane(stage,mainPane,isCheckIn));


    }

    private void setActLeaveTimeComponentsVisible(Boolean isVisible){
        actLeaveTimeLabel.setVisible(isVisible);
        actLeaveTimeDatePicker.setVisible(isVisible);
        actLeaveTimeField.setVisible(isVisible);
    }

    private void setCheckinTimeComponentsVisible(Boolean isVisible){
        checkinTimeDatePicker.setVisible(isVisible);
        checkinTimeField.setVisible(isVisible);
    }

    private void setExpLeaveTimeComponentsVisible(Boolean isVisible){
        expLeaveTimeDatePicker.setVisible(isVisible);
        expLeaveTimeField.setVisible(isVisible);
    }

    private void setRoomComponentsVisible(Boolean isVisible){
        roomIDField.setVisible(isVisible);
    }
}
