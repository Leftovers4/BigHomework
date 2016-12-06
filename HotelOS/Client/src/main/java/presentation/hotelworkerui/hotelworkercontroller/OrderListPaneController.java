package presentation.hotelworkerui.hotelworkercontroller;

import blservice_stub.OrderBLService_Stub;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Callback;
import presentation.util.AlertController;
import presentation.util.CancelDateBefore;
import presentation.util.DisableColumnChangeListener;
import presentation.util.HotelListButtonCell;
import util.OrderType;
import vo.order.OrderPriceVO;
import vo.order.OrderVO;

import java.time.LocalDate;


/**
 * Created by Hitiger on 2016/11/20.
 * Description :
 */
public class OrderListPaneController {

    //列表
    @FXML
    private TableView orderTable;
    //列表栏
    @FXML
    private TableColumn idCol;
    @FXML
    private TableColumn userCol;
    @FXML
    private TableColumn priceCol;
    @FXML
    private TableColumn typeCol;
    @FXML
    private TableColumn checkInTimeCol;
    @FXML
    private TableColumn opCol;
    //订单类型框
    @FXML
    private ComboBox orderTypeBox;
    //日期选择器
    @FXML
    private DatePicker createDatePicker;
    @FXML
    private DatePicker exeDatePicker;

    //提示框控制器
    private AlertController alertController;

    private Pane mainPane;
    private ObservableList<OrderVO> orderVoList;
    private OrderBLService_Stub orderBLServiceStub;

    public void launch(Pane mainPane) {
        this.mainPane = mainPane;
        orderBLServiceStub = new OrderBLService_Stub();
        alertController = new AlertController();
        initBox();
        initDatePicker();
        initTable();
    }

    private void initDatePicker() {
        createDatePicker.setDayCellFactory(new CancelDateBefore(createDatePicker, LocalDate.now()));
        exeDatePicker.setDayCellFactory(new CancelDateBefore(createDatePicker, LocalDate.now()));

        createDatePicker.setOnAction(event -> {
            exeDatePicker.setDayCellFactory(new CancelDateBefore(exeDatePicker, createDatePicker.getValue()));
        });
        exeDatePicker.setOnAction(event -> {
            if(createDatePicker.getValue() !=null){
                //TODO 按时间区间筛选订单
            }
        });
    }

    private void initBox() {
        orderTypeBox.getItems().addAll("所有订单", "未执行订单", "已执行订单", "异常订单", "撤销订单");
        orderTypeBox.setValue("所有订单");
        addBoxListener();
    }

    private void initTable() {
        orderVoList = getOrderVoList();

        idCol.setCellValueFactory(new PropertyValueFactory<>("orderID"));
        userCol.setCellValueFactory(new PropertyValueFactory<>("username"));
        priceCol.setCellValueFactory(new PropertyValueFactory<>("actualPrice"));
        typeCol.setCellValueFactory(new PropertyValueFactory<>("orderType"));

        checkInTimeCol.setCellValueFactory(new PropertyValueFactory<>("checkinTime"));
        //操作列添加按钮
        opCol.setCellFactory(new Callback<TableColumn<OrderVO, Boolean>, TableCell<OrderVO, Boolean>>() {
            @Override
            public TableCell<OrderVO, Boolean> call(TableColumn<OrderVO, Boolean> param) {
                return new HotelListButtonCell(mainPane, orderTable);
            }
        });


        orderTable.setItems(orderVoList);

        final TableColumn[] columns = {idCol, userCol, checkInTimeCol, priceCol, typeCol, opCol};
        orderTable.getColumns().addListener(new DisableColumnChangeListener(orderTable,columns));
    }


    /**
     * 设置组合框的监听
     */
    private void addBoxListener() {
        orderTypeBox.getSelectionModel().selectedItemProperty().addListener(
                (o, oldValue, newValue) -> {
                    switch ((String) newValue) {
                        case "所有订单":
                            orderTable.setItems(orderVoList);
                            break;
                        case "未执行订单":
                            showOrderList(OrderType.Unexecuted);
                            break;
                        case "已执行订单":
                            showOrderList(OrderType.Executed);
                            break;
                        case "异常订单":
                            showOrderList(OrderType.Abnormal);
                            break;
                    }
                });
    }

    private ObservableList<OrderVO> getOrderVoList() {
//        for (int i = 0; i< 30 ; i++) {
//
//            list.add(new OrderVO("12345678912345678", 123456, "user1", OrderType.Abnormal, "如家", null, "A110", 2, false, null, null, null, null));
//        }
////      this.generateTime = generateTime;
//        this.expectedCheckinTime = expectedCheckinTime;
//        this.checkinTime = checkinTime;
//        this.expectedLeaveTime = expectedLeaveTime;
//        this.leaveTime = leaveTime;
//        this.lastExecuteTime = lastExecuteTime;
//        this.executeTime = executeTime;
//        this.cancelTime = cancelTime;
//        OrderTimeVO orderTimeVO1 = new OrderTimeVO(LocalDateTime.of(2016, 11, 11, 11, 00), LocalDateTime.of(2016, 11, 11, 20, 00), null, null,
//                null, LocalDateTime.of(2016, 11, 12, 21, 00), null, null);
//        list.add(new OrderVO("12345678912345678", 123456, "user1", OrderType.Abnormal, "如家", null, "A110 A250",
//                2, false, null, orderTimeVO1, orderPriceVO, null));
//
//        OrderTimeVO orderTimeVO2 = new OrderTimeVO(LocalDateTime.of(2016, 11, 11, 11, 00), LocalDateTime.of(2016, 11, 12, 20, 00), LocalDateTime.of(2016, 11, 12, 20, 30), LocalDateTime.of(2016, 11, 14, 20, 00),
//                LocalDateTime.of(2016, 11, 14, 21, 00), LocalDateTime.of(2016, 11, 12, 21, 00), LocalDateTime.of(2016, 11, 12, 20, 30), null);
//        list.add(new OrderVO("12345678912345679", 123456, "user2", OrderType.Executed, "金陵", null, "A110 A250",
//                2, false, null, orderTimeVO2, orderPriceVO, null));
//
//        OrderTimeVO orderTimeVO3 = new OrderTimeVO(LocalDateTime.of(2016, 11, 11, 11, 00), LocalDateTime.of(2016, 11, 11, 20, 00), null, null,
//                null, LocalDateTime.of(2016, 11, 12, 21, 00), null, null);
//        list.add(new OrderVO("12345678910000000", 123456, "user3", OrderType.Unexecuted, "七天", null, "A110 A250",
//                2, false, null, orderTimeVO3, orderPriceVO, null));
//        for (int i = 0; i < 15; i++){
//            list.add(new OrderVO("12345678910000000", 123456, "user3", OrderType.Unexecuted, "七天", null, "A110 A250",
//                    2, false, null, orderTimeVO3, orderPriceVO, null));
//        }


            return FXCollections.observableArrayList(orderBLServiceStub.viewFullHotelOrderList(123456));
    }


    /**
     * 根据传入的订单状态显示相应的订单列表
     *
     * @param orderType 订单状态
     */
    private void showOrderList(OrderType orderType) {
        ObservableList<OrderVO> list = FXCollections.observableArrayList();
        for (OrderVO OrderVO : orderVoList) {
            if (OrderVO.orderType == orderType) {
                list.add(OrderVO);
            }
        }
        orderTable.setItems(list);
        orderTable.refresh();
    }
}
