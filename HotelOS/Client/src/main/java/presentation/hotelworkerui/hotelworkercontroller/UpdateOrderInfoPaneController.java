package presentation.hotelworkerui.hotelworkercontroller;

import bl.orderbl.OrderBLService;
import bl.orderbl.impl.OrderBlServiceImpl;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import presentation.hotelworkerui.hotelworkerscene.FindOrderPane;
import presentation.hotelworkerui.hotelworkerscene.OrderDetailPane;
import presentation.hotelworkerui.hotelworkerscene.OrderListPane;
import presentation.util.alert.AlertController;
import presentation.util.other.CancelDateBefore;
import presentation.util.other.MyComboBox;
import util.DateTimeFormat;
import util.OrderType;
import vo.order.OrderVO;

import java.rmi.RemoteException;
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
    @FXML private Label orderOriPriceLabel;
    @FXML private Label orderProLabel;
    @FXML private Label orderActPriceLabel;

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

    @FXML private Button submitUpdateBtn;

    private Pane mainPane;
    //是否从更新入住信息进入
    private Boolean isCheckIn;
    //是否从订单列表进入
    private Boolean isFromList;
    //提示框控制器
    private AlertController alertController;
    private OrderBLService orderBLService;
    private OrderVO orderVO;

    public void launch(Pane mainPane , Boolean isCheckIn,Boolean isFromList, OrderVO orderVO) {
        this.mainPane = mainPane;
        this.isCheckIn = isCheckIn;
        this.isFromList = isFromList;
        this.orderVO = orderVO;
        alertController = new AlertController();

        setActLeaveTimeComponentsVisible(!isCheckIn);
        setCheckinTimeComponentsVisible(isCheckIn);
        setExpLeaveTimeComponentsVisible(isCheckIn);
        setRoomComponentsVisible(isCheckIn);

        initService();
        //初始化组件
        initSubmitBtn();
        initLabels(orderVO);
        initBox();
        initDatePicker();
    }


    private void initService() {
        try {
            orderBLService = new OrderBlServiceImpl();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    private void initSubmitBtn() {
        submitUpdateBtn.setText(isCheckIn ? (orderVO.orderType == OrderType.Abnormal ? "延迟入住" : "入住") : "退房");
    }

    private void initDatePicker() {
        checkInTimeDatePicker.setDayCellFactory(new CancelDateBefore(checkInTimeDatePicker, LocalDate.now()));
        expLeaveTimeDatePicker.setDayCellFactory(new CancelDateBefore(expLeaveTimeDatePicker, LocalDate.now()));
        expLeaveTimeDatePicker.setValue(orderVO.orderTimeVO.expectedLeaveTime.toLocalDate());
    }

    private void initBox() {
        MyComboBox.initHourBox(checkInTimeHourBox);
        MyComboBox.initHourBox(expLeaveTimeHourBox);
        MyComboBox.initHourBox(actLeaveTimeHourBox);
        MyComboBox.initMinBox(checkInTimeMinBox);
        MyComboBox.initMinBox(expLeaveTimeMinBox);
        MyComboBox.initMinBox(actLeaveTimeMinBox);
    }

    private void initLabels(OrderVO orderVO) {
        updateTitleLabel.setText(isCheckIn ? "更新入住信息" : "更新退房信息");

        orderIDLabel.setText(orderVO.orderID);
        orderTypeLabel.setText(orderVO.orderType.toString());
        orderOriPriceLabel.setText(String.valueOf(orderVO.orderPriceVO.originPrice));
//      TODO  orderProLabel.setText();
        orderActPriceLabel.setText(String.valueOf(orderVO.orderPriceVO.actualPrice));

        generateTimeLabel.setText(orderVO.orderTimeVO.generateTime.format(DateTimeFormat.dateHourFormat));
        exeLeastTimeLabel.setText(orderVO.orderTimeVO.lastExecuteTime.format(DateTimeFormat.dateHourFormat));
        checkInTimeLabel.setText(orderVO.orderTimeVO.checkinTime == null ? "" : orderVO.orderTimeVO.checkinTime.format(DateTimeFormat.dateHourFormat));
        expLeaveTimeLabel.setText(orderVO.orderTimeVO.expectedLeaveTime == null ? "" : orderVO.orderTimeVO.expectedLeaveTime.format(DateTimeFormat.dateHourFormat));

        userNameLabel.setText(orderVO.username);
        withChildrenLabel.setText(orderVO.withChildren ? "有" : "无");
        peopleAmountLabel.setText(String.valueOf(orderVO.personAmount));
        roomTypeLabel.setText(String.valueOf(orderVO.roomType));
        roomAmountLabel.setText(String.valueOf(orderVO.roomAmount));
        roomIDLabel.setText(orderVO.roomNumber == null ? "" : orderVO.roomNumber);
    }

    @FXML
    private void submitUpdate(){
        if(checkInput()){
            //输入合法
            if(isCheckIn){
                //更新入住信息
                LocalDateTime checkinTime = LocalDateTime.of(checkInTimeDatePicker.getValue(), LocalTime.of((int) (checkInTimeHourBox.getValue()),(int)(checkInTimeMinBox.getValue())));
                LocalDateTime expectedLeaveTime = LocalDateTime.of(expLeaveTimeDatePicker.getValue(), LocalTime.of((int) (expLeaveTimeHourBox.getValue()),(int)(expLeaveTimeMinBox.getValue())));
                String roomNumber = roomIDField.getText();

                orderVO.orderTimeVO.checkinTime = checkinTime;
                orderVO.orderTimeVO.expectedLeaveTime = expectedLeaveTime;
                orderVO.roomNumber = roomNumber;

                try {
                    orderBLService.executeOrder(orderVO);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }else{
                //更新退房信息
                LocalDateTime actLeaveTime = LocalDateTime.of(actLeaveTimeDatePicker.getValue(), LocalTime.of((int) (actLeaveTimeHourBox.getValue()),(int)(actLeaveTimeMinBox.getValue())));
                orderVO.orderTimeVO.leaveTime = actLeaveTime;

                try {
                    orderBLService.onlineCheckOut(orderVO);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }

            //更新完成，跳转至订单详情界面
            mainPane.getChildren().clear();
            OrderVO updatedOrderVo = null;
            try {
                updatedOrderVo = orderBLService.searchOrderByID(orderVO.orderID);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
            mainPane.getChildren().add(new OrderDetailPane(mainPane,isCheckIn,isFromList,updatedOrderVo));
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
        roomIDLabel.setVisible(!isVisible);
    }
}
