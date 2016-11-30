package presentation.webmanagerui.webmanagerscene;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.webmanagerui.webmanagercontroller.AddHotelController;

import java.io.IOException;

/**
 * Created by wyj on 2016/11/30.
 */
public class AddHotelPane extends Pane {

    public AddHotelPane(Stage primaryStage) {
        loadFxml(primaryStage);
    }

    private void loadFxml(Stage primaryStage) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/webmanager/addhotel.fxml"));
        fxmlLoader.setRoot(this);
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        AddHotelController addHotelController = fxmlLoader.getController();
        addHotelController.launch(primaryStage);
    }
}
