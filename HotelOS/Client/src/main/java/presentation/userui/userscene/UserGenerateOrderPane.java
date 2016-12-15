package presentation.userui.userscene;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.userui.usercontroller.UserGenerateOrderController;
import util.RoomType;

import java.io.IOException;

/**
 * Created by wyj on 2016/11/24.
 */
public class UserGenerateOrderPane extends Pane {

    public UserGenerateOrderPane(Stage primaryStage, Pane mainPane, String userID, long hotelID, RoomType roomType) {
        loadFxml(primaryStage, mainPane, userID, hotelID, roomType);
    }

    private void loadFxml(Stage primaryStage, Pane mainPane, String userID, long hotelID, RoomType roomType) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/user/UserGenerateOrder.fxml"));
        fxmlLoader.setRoot(this);
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        UserGenerateOrderController userGenerateOrderController = fxmlLoader.getController();
        userGenerateOrderController.launch(primaryStage, mainPane, userID, hotelID, roomType);
    }
}
