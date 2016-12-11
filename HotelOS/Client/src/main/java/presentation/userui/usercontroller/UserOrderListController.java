package presentation.userui.usercontroller;

import bl.orderbl.impl.OrderBlServiceImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Callback;
import presentation.userui.userscene.CancelOrderPane;
import presentation.util.buttoncell.UserOrderListButtonCell;
import util.OrderType;
import vo.order.OrderVO;

import java.rmi.RemoteException;

/**
 * Created by wyj on 2016/11/22.
 */
public class UserOrderListController {

    private Stage stage;
    private Pane mainPane;
    private String userID;
    private String orderID;

    @FXML private ComboBox orderStateComBox;
    @FXML private DatePicker datebegin;
    @FXML private DatePicker dateend;

    @FXML private TableColumn orderIDCol;
    @FXML private TableColumn orderTimeCol;
    @FXML private TableColumn orderStateCol;
    @FXML private TableColumn hotelNameCol;
    @FXML private TableColumn btnCol;
    @FXML private TableView orderList;

    private UserOrderListButtonCell userOrderListButtonCell;
    private OrderType choseOrderType = null;
    private OrderBlServiceImpl orderBlService;

    public void launch(Stage primaryStage, Pane mainPane, String userID) {
        this.stage = primaryStage;
        this.mainPane = mainPane;
        this.userID = userID;

        try {
            orderBlService = new OrderBlServiceImpl();
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        initialComBox();
        initialOrderListData();
    }

    /**
     * 查看全部订单
     */
    private void initialOrderListData() {
        orderIDCol.setCellValueFactory(new PropertyValueFactory<>("orderID"));
        orderTimeCol.setCellValueFactory(new PropertyValueFactory<>("orderTimeVO"));
        orderStateCol.setCellValueFactory(new PropertyValueFactory<>("orderType"));
        hotelNameCol.setCellValueFactory(new PropertyValueFactory<>("hotelName"));
        btnCol.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                userOrderListButtonCell = new UserOrderListButtonCell(stage, mainPane, orderList, userID);
                return userOrderListButtonCell;
            }
        });
        orderList.setItems(getOrderList());
    }
    private ObservableList getOrderList() {
        ObservableList<OrderVO> list = null;
        try {
            list = FXCollections.observableArrayList(orderBlService.viewFullUserOrderList(userID));
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return list;
    }


    /**
     * 初始化订单类型选框数据
     */
    private void initialComBox() {
        orderStateComBox.getItems().addAll("全部订单", "未执行订单", "已执行订单", "异常订单", "撤销订单");
        addComBoxListener();
    }
    /**
     * 订单类型选框添加监听
     */
    private void addComBoxListener() {
        orderStateComBox.getSelectionModel().selectedItemProperty().addListener(
                (o, oldValue, newValue) -> {
                    try {
                        switch ((String) newValue) {
                            case "全部订单":
                                orderList.setItems(getOrderList());
                                choseOrderType = null;
                                break;
                            case "已执行订单":
                                orderList.setItems(FXCollections.observableArrayList(orderBlService.viewTypeUserOrderList(userID, OrderType.Executed)));
                                choseOrderType = OrderType.Executed;
                                break;
                            case "未执行订单":
                                orderList.setItems(FXCollections.observableArrayList(orderBlService.viewTypeUserOrderList(userID, OrderType.Unexecuted)));
                                choseOrderType = OrderType.Unexecuted;
                                break;
                            case "异常订单":
                                orderList.setItems(FXCollections.observableArrayList(orderBlService.viewTypeUserOrderList(userID, OrderType.Abnormal)));
                                choseOrderType = OrderType.Abnormal;
                                break;
                            case "撤销订单":
                                orderList.setItems(FXCollections.observableArrayList(orderBlService.viewTypeUserOrderList(userID, OrderType.Canceled)));
                                choseOrderType = OrderType.Canceled;
                                break;
                        }
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
        );
    }


    @FXML
    private void cancelOrder() {
        mainPane.getChildren().remove(0);
        mainPane.getChildren().add(new CancelOrderPane(stage, orderID));
    }
}
