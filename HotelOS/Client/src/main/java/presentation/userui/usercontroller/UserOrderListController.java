package presentation.userui.usercontroller;

import bl.orderbl.impl.OrderBlServiceImpl;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Callback;
import presentation.userui.userscene.CancelOrderPane;
import presentation.util.UserOrderListButtonCell;

/**
 * Created by wyj on 2016/11/22.
 */
public class UserOrderListController {

    private Stage stage;
    private Pane mainPane;

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

    private OrderBlServiceImpl orderBlService;

    public void launch(Stage primaryStage, Pane mainPane) {
        this.stage = primaryStage;
        this.mainPane = mainPane;

        orderStateComBox.getItems().add("全部订单");
        orderStateComBox.getItems().add("已执行订单");
        orderStateComBox.getItems().add("未执行订单");
        orderStateComBox.getItems().add("撤销订单");
        orderStateComBox.getItems().add("异常订单");

        initialData();
    }

    private void initialData() {
        orderIDCol.setCellValueFactory(new PropertyValueFactory<>("orderID"));
        orderTimeCol.setCellValueFactory(new PropertyValueFactory<>("orderTime"));
        orderStateCol.setCellValueFactory(new PropertyValueFactory<>("orderState"));
        hotelNameCol.setCellValueFactory(new PropertyValueFactory<>("hotelName"));
        btnCol.setCellValueFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                userOrderListButtonCell = new UserOrderListButtonCell(stage, mainPane, orderList);
                return userOrderListButtonCell;
            }
        });
        orderList.setItems(getUserOrderList());
    }

    private ObservableList getUserOrderList() {
//        ObservableList<OrderVO> list = FXCollections.observableArrayList(orderBlService.viewFullUserOrderList("000"));
        return null;
    }


    @FXML
    private void cancelOrder() {
        mainPane.getChildren().remove(0);
        mainPane.getChildren().add(new CancelOrderPane(stage));
    }
}
