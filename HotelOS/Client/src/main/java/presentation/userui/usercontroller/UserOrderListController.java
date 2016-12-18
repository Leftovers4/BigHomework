package presentation.userui.usercontroller;

import bl.orderbl.OrderBLService;
import bl.orderbl.impl.OrderBlServiceImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Callback;
import presentation.util.buttoncell.UserOrderListButtonCell;
import util.EnumFactory;
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
    private boolean isFromNewOrder;

    @FXML private ComboBox orderStateComBox;
    @FXML private TextField searchField;
    @FXML private TableColumn orderIDCol;
    @FXML private TableColumn orderTimeCol;
    @FXML private TableColumn orderStateCol;
    @FXML private TableColumn orderReviewCol;
    @FXML private TableColumn hotelNameCol;
    @FXML private TableColumn btnCol;
    @FXML private TableView orderList;

    private UserOrderListButtonCell userOrderListButtonCell;
    private OrderBLService orderBlService;

    public void launch(Stage primaryStage, Pane mainPane, String userID, boolean isFromNewOrder) {
        this.stage = primaryStage;
        this.mainPane = mainPane;
        this.userID = userID;
        this.isFromNewOrder = isFromNewOrder;

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
        orderTimeCol.setCellValueFactory(new PropertyValueFactory<>("generateTime"));
        orderStateCol.setCellValueFactory(new PropertyValueFactory<>("orderType"));
        orderReviewCol.setCellValueFactory(new PropertyValueFactory<>("hasReview"));
        hotelNameCol.setCellValueFactory(new PropertyValueFactory<>("hotelName"));
        btnCol.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                userOrderListButtonCell = new UserOrderListButtonCell(stage, mainPane, orderList, userID);
                return userOrderListButtonCell;
            }
        });
        if (isFromNewOrder) {
            orderList.setItems(getTypeOrderList());
            orderStateComBox.setValue(EnumFactory.getString(OrderType.Unexecuted));
        } else {
            orderList.setItems(getFullOrderList());
        }
    }
    private ObservableList getFullOrderList() {
        ObservableList<OrderVO> list = null;
        try {
            list = FXCollections.observableArrayList(orderBlService.viewFullUserOrderList(userID));
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return list;
    }
    private ObservableList getTypeOrderList() {
        ObservableList<OrderVO> list = null;
        try {
            list = FXCollections.observableArrayList(orderBlService.viewTypeUserOrderList(userID, OrderType.Unexecuted));
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
                                orderList.setItems(getFullOrderList());
                                break;
                            case "已执行订单":
                                orderList.setItems(FXCollections.observableArrayList(orderBlService.viewTypeUserOrderList(userID, OrderType.Executed)));
                                break;
                            case "未执行订单":
                                orderList.setItems(FXCollections.observableArrayList(orderBlService.viewTypeUserOrderList(userID, OrderType.Unexecuted)));
                                break;
                            case "异常订单":
                                orderList.setItems(FXCollections.observableArrayList(orderBlService.viewTypeUserOrderList(userID, OrderType.Abnormal)));
                                break;
                            case "撤销订单":
                                orderList.setItems(FXCollections.observableArrayList(orderBlService.viewTypeUserOrderList(userID, OrderType.Canceled)));
                                break;
                        }
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
        );
    }


    @FXML
    private void searchOrderByID() {
        OrderVO orderVO = null;
        ObservableList<OrderVO> list = FXCollections.observableArrayList();
        try {
            orderVO = orderBlService.searchOrderByID(searchField.getText());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if(orderVO != null) list.add(orderVO);
        orderList.setItems(list);
    }
}
