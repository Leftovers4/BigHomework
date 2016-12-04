package presentation.userui.usercontroller;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.userui.userscene.CancelOrderPane;

/**
 * Created by wyj on 2016/11/22.
 */
public class UserOrderListController {

    private Stage stage;
    private Pane mainPane;

    @FXML private ComboBox orderStateComBox;
    @FXML private DatePicker datebegin;
    @FXML private DatePicker dateend;

    public void launch(Stage primaryStage, Pane mainPane) {
        this.stage = primaryStage;
        this.mainPane = mainPane;

        orderStateComBox.getItems().add("全部订单");
        orderStateComBox.getItems().add("已执行订单");
        orderStateComBox.getItems().add("未执行订单");
        orderStateComBox.getItems().add("撤销订单");
        orderStateComBox.getItems().add("异常订单");
    }


    @FXML
    private void cancelOrder() {
        mainPane.getChildren().remove(0);
        mainPane.getChildren().add(new CancelOrderPane(stage));
    }
}
