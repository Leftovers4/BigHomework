package presentation.webmanagerui.webmanagerscene;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.webmanagerui.webmanagercontroller.HotelManageController;

import java.io.IOException;

/**
 * Created by wyj on 2016/11/29.
 */
public class HotelManagePane extends Pane {

    public HotelManagePane(Stage primaryStage) {
        loadFxml(primaryStage);
    }

    private void loadFxml(Stage primaryStage) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/webmanager/webmanhotelman.fxml"));
        fxmlLoader.setRoot(this);
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        HotelManageController hotelManageController = fxmlLoader.getController();
        hotelManageController.launch(primaryStage);
    }
}
