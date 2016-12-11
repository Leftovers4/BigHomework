package presentation.userui.userscene;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.userui.usercontroller.UserHotelInfoController;

import java.io.IOException;

/**
 * Created by wyj on 2016/12/11.
 */
public class UserHotelInfoPane extends Pane {

    public UserHotelInfoPane(Stage primaryStage, Pane mainPane, String userID, Long hotelID) {
        loadFxml(primaryStage, mainPane, userID, hotelID);
    }

    private void loadFxml(Stage primaryStage, Pane mainPane, String userID, Long hotelID) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/user/checkHotelinfo.fxml"));
        fxmlLoader.setRoot(this);
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        UserHotelInfoController userHotelInfoController = fxmlLoader.getController();
        userHotelInfoController.launch(primaryStage, mainPane, userID, hotelID);
    }
}
