package presentation.hotelworkerui.hotelworkercontroller;

import blservice_stub.OrderBLService_Stub;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import util.OrderType;
import vo.order.OrderVO;


/**
 * Created by Hitiger on 2016/11/20.
 * Description :
 */
public class OrderListPaneController {

    //列表
    @FXML private TableView orderlistTable;
    //列表栏
    @FXML private TableColumn idCol;
    @FXML private TableColumn userCol;
    @FXML private TableColumn amountCol;
    @FXML private TableColumn typeCol;
    @FXML private TableColumn exetimeCol;
    //订单类型框
    @FXML private ComboBox orderTypeBox;
    //日期选择器
    @FXML private DatePicker createDatePicker;
    @FXML private DatePicker exeDatePicker;

    private Stage stage;
    private ObservableList<OrderVO> ordervoList;
    private OrderBLService_Stub orderBLServiceStub;

    public void launch(Stage primaryStage) {
        this.stage = primaryStage;
        orderBLServiceStub = new OrderBLService_Stub();
        initData();
    }

    private void initData() {
        ordervoList = getOrderVoList();

        idCol.setCellValueFactory(new PropertyValueFactory<>("orderID"));
        userCol.setCellValueFactory(new PropertyValueFactory<>("username"));
        amountCol.setCellValueFactory(new PropertyValueFactory<>("personAmount"));
        typeCol.setCellValueFactory(new PropertyValueFactory<>("orderType"));

        orderlistTable.setItems(ordervoList);
    }

    private ObservableList<OrderVO> getOrderVoList() {
        ObservableList<OrderVO> list= FXCollections.observableArrayList();
        for (int i = 0; i< 30 ; i++) {
            list.add(new OrderVO("12345678912345678", 123456, "user1", OrderType.Abnormal, "如家", null, "5", 2, false, null, null, null, null));
        }
        return list;
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

}
