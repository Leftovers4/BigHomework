package presentation.hotelworkerui.hotelworkercontroller;

import blservice_stub.OrderBLService_Stub;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.hotelworkerui.hotelworkerscene.OrderDetailPane;
import presentation.hotelworkerui.hotelworkerscene.UpdateOrderInfoPane;
import util.OrderType;
import vo.order.OrderPriceVO;
import vo.order.OrderTimeVO;
import vo.order.OrderVO;

import java.time.LocalDate;
import java.time.LocalDateTime;


/**
 * Created by Hitiger on 2016/11/20.
 * Description :
 */
public class OrderListPaneController {

    //列表
    @FXML private TableView orderTable;
    //列表栏
    @FXML private TableColumn idCol;
    @FXML private TableColumn userCol;
    @FXML private TableColumn priceCol;
    @FXML private TableColumn typeCol;
    @FXML private TableColumn exetimeCol;
    //订单类型框
    @FXML private ComboBox orderTypeBox;
    //日期选择器
    @FXML private DatePicker createDatePicker;
    @FXML private DatePicker exeDatePicker;

    private Stage stage;
    private Pane mainPane;
    private ObservableList<OrderVO> orderVoList;
    private OrderBLService_Stub orderBLServiceStub;

    public void launch(Stage primaryStage,Pane mainPane) {
        this.stage = primaryStage;
        this.mainPane = mainPane;
        orderBLServiceStub = new OrderBLService_Stub();
        initBox();
        initData();
    }

    private void initBox() {
        orderTypeBox.getItems().addAll("所有订单", "未执行订单", "已执行订单","异常订单");
        orderTypeBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue observable, String oldValue, String newValue) {
                switch (newValue){
                    case "所有订单" :
                        showAllOrders();
                        break;
                    case "未执行订单" :
                        showUnexecutedOrders();
                        break;
                    case "已执行订单" :
                        showExecutedOrders();
                        break;
                    case "异常订单" :
                        showAbnormalOrders();
                        break;
                }
            }
        });
    }

    private void initData() {
        orderVoList = getOrderVoList();

        idCol.setCellValueFactory(new PropertyValueFactory<>("orderID"));
        userCol.setCellValueFactory(new PropertyValueFactory<>("username"));
        priceCol.setCellValueFactory(new PropertyValueFactory<>("actualPrice"));
        typeCol.setCellValueFactory(new PropertyValueFactory<>("orderType"));

//        orderTable.getSelectionModel().selectedItemProperty()

        orderTable.setItems(orderVoList);
    }

    private ObservableList<OrderVO> getOrderVoList() {
        ObservableList<OrderVO> list= FXCollections.observableArrayList();
//        for (int i = 0; i< 30 ; i++) {
//
//            list.add(new OrderVO("12345678912345678", 123456, "user1", OrderType.Abnormal, "如家", null, "A110", 2, false, null, null, null, null));
//        }
        OrderPriceVO orderPriceVO = new OrderPriceVO(250,200);
        OrderTimeVO orderTimeVO = new OrderTimeVO(LocalDateTime.of(2016,11,11,11,11),null,LocalDateTime.of(2016,11,12,8,00),LocalDateTime.of(2016,11,14,11,11),
                LocalDateTime.of(2016,11,15,11,11),LocalDateTime.of(2016,11,12,11,11),null,null);
        list.add(new OrderVO("12345678912345678", 123456, "user1", OrderType.Abnormal, "如家", null, "A110 A250",
                2, false, null, orderTimeVO, orderPriceVO, null));
        list.add(new OrderVO("12345678912345679", 123456, "user2", OrderType.Executed, "金陵", null, "A110 A250",
                2, false, null, orderTimeVO, orderPriceVO, null));
        list.add(new OrderVO("12345678910000000", 123456, "user3", OrderType.Unexecuted, "七天", null, "A110 A250",
                2, false, null, orderTimeVO, orderPriceVO, null));
        return list;
    }

    /**
     * 查看订单详情
     */
    @FXML
    private void checkOrderDetail(){
        OrderVO orderVO = (OrderVO) orderTable.getSelectionModel().getSelectedItem();
        mainPane.getChildren().remove(0);
        mainPane.getChildren().add(new OrderDetailPane(stage,mainPane,orderVO));
    }

    /**
     * 客户入住
     */
    @FXML
    private void checkIn(){
        OrderVO orderVO = (OrderVO) orderTable.getSelectionModel().getSelectedItem();
        mainPane.getChildren().remove(0);
        mainPane.getChildren().add(new UpdateOrderInfoPane(stage,mainPane,true,true,orderVO));
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
    }






    private void showAbnormalOrders() {
        ObservableList<OrderVO> list= FXCollections.observableArrayList();
        for (OrderVO OrderVO : orderVoList){
            if(OrderVO.orderType == OrderType.Abnormal){
                list.add(OrderVO);
            }
        }
        orderTable.setItems(list);
    }
    private void showUnexecutedOrders() {
        ObservableList<OrderVO> list= FXCollections.observableArrayList();
        for (OrderVO OrderVO : orderVoList){
            if(OrderVO.orderType == OrderType.Unexecuted){
                list.add(OrderVO);
            }
        }
        orderTable.setItems(list);
    }
    private void showExecutedOrders() {
        ObservableList<OrderVO> list= FXCollections.observableArrayList();
        for (OrderVO OrderVO : orderVoList){
            if(OrderVO.orderType == OrderType.Executed){
                list.add(OrderVO);
            }
        }
        orderTable.setItems(list);
    }
    private void showAllOrders() {
        orderTable.setItems(orderVoList);
    }

}
