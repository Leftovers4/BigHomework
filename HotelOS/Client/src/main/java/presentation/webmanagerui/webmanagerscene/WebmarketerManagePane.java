package presentation.webmanagerui.webmanagerscene;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.webmanagerui.webmanagercontroller.WebmarketerManageController;

import java.io.IOException;

/**
 * Created by wyj on 2016/11/29.
 */
public class WebmarketerManagePane extends Pane {

    public WebmarketerManagePane(Stage primaryStage, Pane mainPane) {
        loadFxml(primaryStage, mainPane);
    }

    private void loadFxml(Stage primaryStage, Pane mainPane) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/webmanager/webmanwebmarketerman.fxml"));
        fxmlLoader.setRoot(this);
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        WebmarketerManageController webmarketerManageController = fxmlLoader.getController();
        webmarketerManageController.launch(primaryStage, mainPane);
    }
}
