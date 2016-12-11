package presentation.userui.userscene;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.userui.usercontroller.UserOrderListController;

import java.io.IOException;

/**
 * Created by wyj on 2016/11/22.
 */
public class UserOrderListPane extends Pane {

    public UserOrderListPane(Stage primaryStage, Pane mainPane, String userID) {
        loadFxml(primaryStage, mainPane, userID);
    }

    private void loadFxml(Stage primaryStage, Pane mainPane, String userID) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/user/userorderlist.fxml"));
        fxmlLoader.setRoot(this);
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        UserOrderListController userOrderListController = fxmlLoader.getController();
        userOrderListController.launch(primaryStage, mainPane, userID);
    }
}
