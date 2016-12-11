package presentation.webmanagerui.webmanagerscene;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.webmanagerui.webmanagercontroller.UserManageController;

import java.io.IOException;

/**
 * Created by wyj on 2016/11/29.
 */
public class UserManagePane extends Pane {

    public UserManagePane(Stage primaryStage, Pane mainPane) {
        loadFxml(primaryStage, mainPane);
    }

    private void loadFxml(Stage primaryStage, Pane mainPane) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/webmanager/webmanuserman.fxml"));
        fxmlLoader.setRoot(this);
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        UserManageController userManageController = fxmlLoader.getController();
        userManageController.launch(primaryStage, mainPane);
    }
}
