package presentation.webmanagerui.webmanagerscene;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.webmanagerui.webmanagercontroller.HotelworkerManageController;

import java.io.IOException;

/**
 * Created by wyj on 2016/11/29.
 */
public class HotelWorkerManagePane extends Pane {

    public HotelWorkerManagePane(Stage primaryStage, Pane mainPane) {
        loadFxml(primaryStage, mainPane);
    }

    private void loadFxml(Stage primaryStage, Pane mainPane) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/webmanager/webmanhotelworkerman.fxml"));
        fxmlLoader.setRoot(this);
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        HotelworkerManageController hotelworkerManageController = fxmlLoader.getController();
        hotelworkerManageController.launch(primaryStage, mainPane);
    }
}
