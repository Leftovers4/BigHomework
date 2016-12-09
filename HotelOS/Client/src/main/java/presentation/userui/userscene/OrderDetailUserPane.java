package presentation.userui.userscene;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.userui.usercontroller.OrderDetailUserController;

import java.io.IOException;

/**
 * Created by wyj on 2016/11/25.
 */
public class OrderDetailUserPane extends Pane {

    public OrderDetailUserPane(Stage primaryStage, Pane mainPane, String orderID) {
        loadFxml(primaryStage, mainPane, orderID);
    }

    private void loadFxml(Stage primaryStage, Pane mainPane, String orderID) {
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("/fxml/user/orderDetailUser.fxml"));
        fxmlLoader.setRoot(this);
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        OrderDetailUserController orderDetailUserController = fxmlLoader.getController();
        orderDetailUserController.launch(primaryStage, mainPane, orderID);
    }
}
