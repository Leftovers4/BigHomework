package presentation.webmanagerui.webmanagerscene;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.webmanagerui.webmanagercontroller.AddHotelWorkerController;

import java.io.IOException;

/**
 * Created by wyj on 2016/11/30.
 */
public class AddHotelWorkerPane extends Pane {

    public AddHotelWorkerPane(Stage primaryStage) {
        loadFxml(primaryStage);
    }

    private void loadFxml(Stage primaryStage) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/webmanager/addnewhotelworker.fxml"));
        fxmlLoader.setRoot(this);
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        AddHotelWorkerController addHotelWorkerController = fxmlLoader.getController();
        addHotelWorkerController.launch(primaryStage);
    }
}
