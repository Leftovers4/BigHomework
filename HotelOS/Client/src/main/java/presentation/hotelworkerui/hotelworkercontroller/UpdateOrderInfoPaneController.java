package presentation.hotelworkerui.hotelworkercontroller;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.hotelworkerui.hotelworkerscene.FindOrderPane;
import presentation.hotelworkerui.hotelworkerscene.OrderDetailPane;
import presentation.hotelworkerui.hotelworkerscene.OrderListPane;
import presentation.util.AlertController;
import presentation.util.CancelDateBefore;
import util.OrderType;
import vo.order.OrderTimeVO;
import vo.order.OrderVO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * Created by Hitiger on 2016/11/22.
 * Description :
 */
public class UpdateOrderInfoPaneController {
    //标题
    @FXML private Label updateTitleLabel;
    //订单号、状态、价格
    @FXML private Label orderIDLabel;
    @FXML private Label orderTypeLabel;
    @FXML private Label orderPriceLabel;

    //生成时间
    @FXML private Label generateTimeLabel;

    //最晚执行时间
    @FXML private Label exeLeastTimeLabel;

    //入住时间
    @FXML private Label checkInTimeLabel;
    @FXML private DatePicker checkInTimeDatePicker;
    @FXML private ComboBox checkInTimeHourBox;
    @FXML private ComboBox checkInTimeMinBox;

    //预计离开时间
    @FXML private Label      expLeaveTimeLabel;
    @FXML private DatePicker expLeaveTimeDatePicker;
    @FXML private ComboBox expLeaveTimeHourBox;
    @FXML private ComboBox expLeaveTimeMinBox;

    //实际离开时间
    @FXML private Label      actLeaveTimeLabel;
    @FXML private DatePicker actLeaveTimeDatePicker;
    @FXML private ComboBox  actLeaveTimeHourBox;
    @FXML private ComboBox  actLeaveTimeMinBox;

    //客户名、入住房间信息
    @FXML private Label userNameLabel;
    @FXML private Label peopleAmountLabel;
    @FXML private Label withChildrenLabel;
    @FXML private Label roomTypeLabel;
    @FXML private Label roomAmountLabel;
    @FXML private Label roomIDLabel;
    @FXML private TextField roomIDField;

    private Pane mainPane;
    //是否从更新入住信息进入
    private Boolean isCheckIn;
    //是否从订单列表进入
    private Boolean isFromList;
    //提示框控制器
    private AlertController alertController;
    private OrderVO orderVO;

    public void launch(Pane mainPane , Boolean isCheckIn,Boolean isFromList, OrderVO orderVO) {
        this.mainPane = mainPane;
        this.isCheckIn = isCheckIn;
        this.isFromList = isFromList;
        this.orderVO = orderVO;

        setActLeaveTimeComponentsVisible(!isCheckIn);
        setCheckinTimeComponentsVisible(isCheckIn);
        setExpLeaveTimeComponentsVisible(isCheckIn);
        setRoomComponentsVisible(isCheckIn);

        alertController = new AlertController();
        //初始化组件
        initLabels(orderVO);
        initBox();
        initDatePicker();
    }

    private void initDatePicker() {
        checkInTimeDatePicker.setDayCellFactory(new CancelDateBefore(checkInTimeDatePicker, LocalDate.now()));
        expLeaveTimeDatePicker.setDayCellFactory(new CancelDateBefore(expLeaveTimeDatePicker, LocalDate.now()));
        expLeaveTimeDatePicker.setValue(orderVO.orderTimeVO.expectedLeaveTime.toLocalDate());
    }

    private void initBox() {

        for (int i = 0; i < 24; i++){
            checkInTimeHourBox.getItems().add(i);
            expLeaveTimeHourBox.getItems().add(i);
            actLeaveTimeHourBox.getItems().add(i);
        }

        for (int i = 0; i < 60; i++){
            checkInTimeMinBox.getItems().add(i);
            expLeaveTimeMinBox.getItems().add(i);
            actLeaveTimeMinBox.getItems().add(i);
        }

        checkInTimeHourBox.setValue(LocalDateTime.now().getHour());
        expLeaveTimeHourBox.setValue(LocalDateTime.now().getHour());
        actLeaveTimeHourBox.setValue(LocalDateTime.now().getHour());
        checkInTimeMinBox.setValue(LocalDateTime.now().getMinute());
        expLeaveTimeMinBox.setValue(LocalDateTime.now().getMinute());
        actLeaveTimeMinBox.setValue(LocalDateTime.now().getMinute());
    }

    private void initLabels(OrderVO orderVO) {
        updateTitleLabel.setText(isCheckIn ? "更新入住信息" : "更新退房信息");

        orderIDLabel.setText(orderVO.orderID);
        orderTypeLabel.setText(orderVO.orderType.toString());
        orderPriceLabel.setText(String.valueOf(orderVO.orderPriceVO.actualPrice));

        generateTimeLabel.setText(orderVO.orderTimeVO.generateTime.toString());
        exeLeastTimeLabel.setText(orderVO.orderTimeVO.lastExecuteTime.toString());
        checkInTimeLabel.setText(orderVO.orderTimeVO.checkinTime == null ? "" : orderVO.orderTimeVO.checkinTime.toString());
        expLeaveTimeLabel.setText(orderVO.orderTimeVO.expectedLeaveTime == null ? "" : orderVO.orderTimeVO.expectedLeaveTime.toString());

        userNameLabel.setText(orderVO.username);
        peopleAmountLabel.setText(String.valueOf(orderVO.personAmount));
        withChildrenLabel.setText(orderVO.withChildren ? "有" : "无");
        //TODO roomIDLabel.setText();
    }

    @FXML
    private void submitUpdate(){
        if(checkInput()){
            //输入合法
            if(isCheckIn){
                //更新入住信息
                LocalDateTime checkinTime = LocalDateTime.of(checkInTimeDatePicker.getValue(), LocalTime.of((int) (checkInTimeHourBox.getValue()),(int)(checkInTimeMinBox.getValue())));
                orderVO.orderTimeVO.checkinTime = checkinTime;
                LocalDateTime expectedLeaveTime = LocalDateTime.of(expLeaveTimeDatePicker.getValue(), LocalTime.of((int) (expLeaveTimeHourBox.getValue()),(int)(expLeaveTimeMinBox.getValue())));
                orderVO.orderTimeVO.expectedLeaveTime = expectedLeaveTime;
                String roomNumber = roomIDField.getText();
                orderVO.roomNumber = roomNumber;
                orderVO.orderType = OrderType.Executed;
            }else{
                //更新退房信息
                LocalDateTime actLeaveTime = LocalDateTime.of(actLeaveTimeDatePicker.getValue(), LocalTime.of((int) (actLeaveTimeHourBox.getValue()),(int)(actLeaveTimeMinBox.getValue())));
                orderVO.orderTimeVO.leaveTime = actLeaveTime;
            }


            mainPane.getChildren().remove(0);
            mainPane.getChildren().add(new OrderDetailPane(mainPane,isCheckIn,isFromList,orderVO));
        }else {
            //输入不合法
            alertController.showInputWrongAlert("请将入住信息填写完整","提交失败");
        }
    }

    /**
     * 检查更新订单 所填的信息是否合法
     * @return
     */
    private boolean checkInput() {
        if(isCheckIn){
            //检查入住时间，预计离开时间，房间号
            if(checkInTimeDatePicker.getValue() == null || expLeaveTimeDatePicker.getValue() == null
                    || roomIDField.getText().isEmpty()){
                return false;
            }
        }else{
            //检查实际离开时间
            if(actLeaveTimeDatePicker.getValue() == null) return false;
        }
        return true;
    }

    @FXML
    private void back(){
        mainPane.getChildren().clear();
        if(isFromList) {
            mainPane.getChildren().add(new OrderListPane(mainPane));
        }else mainPane.getChildren().add(new FindOrderPane(mainPane,isCheckIn));
    }


    private void setActLeaveTimeComponentsVisible(Boolean isVisible){
        actLeaveTimeLabel.setVisible(isVisible);
        actLeaveTimeDatePicker.setVisible(isVisible);
        actLeaveTimeHourBox.setVisible(isVisible);
        actLeaveTimeMinBox.setVisible(isVisible);
    }

    private void setCheckinTimeComponentsVisible(Boolean isVisible){
        checkInTimeLabel.setVisible(!isVisible);
        checkInTimeDatePicker.setVisible(isVisible);
        checkInTimeHourBox.setVisible(isVisible);
        checkInTimeMinBox.setVisible(isVisible);
    }

    private void setExpLeaveTimeComponentsVisible(Boolean isVisible){
        expLeaveTimeLabel.setVisible(!isVisible);
        expLeaveTimeDatePicker.setVisible(isVisible);
        expLeaveTimeHourBox.setVisible(isVisible);
        expLeaveTimeMinBox.setVisible(isVisible);
    }

    private void setRoomComponentsVisible(Boolean isVisible){
        roomIDField.setVisible(isVisible);
    }
}
