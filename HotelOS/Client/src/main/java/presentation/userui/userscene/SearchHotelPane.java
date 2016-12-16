package presentation.userui.userscene;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.userui.usercontroller.UserSearchHotelController;

import java.io.IOException;

/**
 * Created by wyj on 2016/11/19.
 */
public class SearchHotelPane extends Pane {

    public SearchHotelPane(Stage primaryStage, Pane mainPane, String userID) {
        loadFxml(primaryStage, mainPane, userID);
    }

    private void loadFxml(Stage primaryStage, Pane mainPane, String userID) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/user/usersearchhotel.fxml"));
        fxmlLoader.setRoot(this);
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        UserSearchHotelController userSearchHotelController = fxmlLoader.getController();
        userSearchHotelController.launch(primaryStage, mainPane, userID);
    }

}
