package presentation.webmarketerui.webmarketercontroller;

import bl.orderbl.OrderBLService;
import bl.orderbl.impl.OrderBlServiceImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.util.Callback;
import presentation.util.alert.AlertController;
import presentation.util.buttoncell.WebMarketListButtonCell;
import util.OrderType;
import vo.order.OrderPriceVO;
import vo.order.OrderVO;

import java.rmi.RemoteException;

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


    private Pane mainPane;
    private AlertController alertController;
    private OrderBLService orderBLService;

    public void launch(Pane mainPane) {
        this.mainPane = mainPane;
        alertController = new AlertController();

        initService();
        initBox();
        initTable();
        initData();
    }

    private void initService() {
        try {
            orderBLService = new OrderBlServiceImpl();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    private void initBox() {
        orderTypeBox.getItems().addAll("所有订单", "未执行订单", "已执行订单", "异常订单", "撤销订单");
        addBoxListener();
    }

    private void initTable() {

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



    }


    private void initData() {
        orderTable.setItems(getOrderVoList());
    }

    private ObservableList<OrderVO> getOrderVoList() {
        ObservableList<OrderVO> list = null;
        try {
            list = FXCollections.observableArrayList(orderBLService.viewFullOrderList());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * TODO 将showOrderList方法更换为 逻辑给的接口
     * 设置组合框的监听
     */
    private void addBoxListener() {
        orderTypeBox.getSelectionModel().selectedItemProperty().addListener(
                (o, oldValue, newValue) -> {
                    switch ((String) newValue) {
//                        case "所有订单":
//                            orderTable.setItems(getOrderVoList());
//                            break;
//                        case "未执行订单":
//                            showOrderList(OrderType.Unexecuted);
//                            break;
//                        case "已执行订单":
//                            showOrderList(OrderType.Executed);
//                            break;
//                        case "异常订单":
//                            showOrderList(OrderType.Abnormal);
//                            break;
                    }
                });
    }

}
