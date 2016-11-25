package presentation.userui.userscene;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.userui.usercontroller.CancelOrderController;

import java.io.IOException;

/**
 * Created by wyj on 2016/11/25.
 */
public class CancelOrderPane extends Pane {

    public CancelOrderPane(Stage primaryStage) {
        loadFxml(primaryStage);
    }

    private void loadFxml(Stage primaryStage) {
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("/fxml/user/cancelOrder.fxml"));
        fxmlLoader.setRoot(this);
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        CancelOrderController cancelOrderController = fxmlLoader.getController();
        cancelOrderController.launch(primaryStage);
    }
}
