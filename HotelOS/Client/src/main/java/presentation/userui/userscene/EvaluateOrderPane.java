package presentation.userui.userscene;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.userui.usercontroller.EvaluateOrderController;

import java.io.IOException;

/**
 * Created by wyj on 2016/11/25.
 */
public class EvaluateOrderPane extends Pane {

    public EvaluateOrderPane(Stage primaryStage, String orderID, String userID, Pane mainPane) {
        loadFxml(primaryStage, orderID, userID, mainPane);
    }

    private void loadFxml(Stage primaryStage, String orderID, String userID, Pane mainPane) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/user/evaluateorder.fxml"));
        fxmlLoader.setRoot(this);
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        EvaluateOrderController evaluateOrderController = fxmlLoader.getController();
        evaluateOrderController.launch(primaryStage, orderID, userID, mainPane);
    }
}
