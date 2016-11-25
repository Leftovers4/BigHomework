package presentation.userui.userscene;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.userui.usercontroller.RegisterCommonVIPController;

import java.io.IOException;

/**
 * Created by wyj on 2016/11/25.
 */
public class RegisterCommonVIPPane extends Pane {

    public RegisterCommonVIPPane(Stage primaryStage) {
        loadFxml(primaryStage);
    }

    private void loadFxml(Stage primaryStage) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/user/RegisterCommonVIP.fxml"));
        fxmlLoader.setRoot(this);
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        RegisterCommonVIPController registerCommonVIPController = fxmlLoader.getController();
        registerCommonVIPController.launch(primaryStage);
    }
}
