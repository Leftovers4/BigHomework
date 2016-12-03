package presentation.webmarketerui.webmarketercontroller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Callback;
import presentation.util.AlertController;
import presentation.util.WebMarketListButtonCell;
import util.OrderType;
import vo.order.OrderPriceVO;
import vo.order.OrderVO;

/**
 * Created by Hitiger on 2016/11/28.
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
    private TableColumn hotelCol;
    @FXML
    private TableColumn typeCol;
    @FXML
    private TableColumn opCol;
    @FXML
    private ComboBox hotelBox;
    @FXML
    private ComboBox orderTypeBox;


    private Stage stage;
    private Pane mainPane;
    private AlertController alertController;
    private ObservableList<OrderVO> orderVoList;

    public void launch(Stage primaryStage, Pane mainPane) {
        this.stage = primaryStage;
        this.mainPane = mainPane;
        alertController = new AlertController();

        initBox();
        initTable();
    }


    private void initBox() {
        orderTypeBox.getItems().addAll("所有订单", "未执行订单", "已执行订单", "异常订单");
        addBoxListener();
    }

    private void initTable() {
        orderVoList = getOrderVoList();

        hotelCol.setCellValueFactory(new PropertyValueFactory<>("hotelName"));
        idCol.setCellValueFactory(new PropertyValueFactory<>("orderID"));
        userCol.setCellValueFactory(new PropertyValueFactory<>("username"));
        typeCol.setCellValueFactory(new PropertyValueFactory<>("orderType"));

        //操作列添加按钮
        opCol.setCellFactory(new Callback<TableColumn<OrderVO, Boolean>, TableCell<OrderVO, Boolean>>() {
            @Override
            public TableCell<OrderVO, Boolean> call(TableColumn<OrderVO, Boolean> param) {
                return new WebMarketListButtonCell(mainPane,orderTable);
            }
        });


        orderTable.setItems(orderVoList);
    }

    private ObservableList<OrderVO> getOrderVoList() {
        ObservableList<OrderVO> list = FXCollections.observableArrayList();
        OrderPriceVO orderPriceVO = new OrderPriceVO(250, 200);

        list.add(new OrderVO());
        return list;
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
