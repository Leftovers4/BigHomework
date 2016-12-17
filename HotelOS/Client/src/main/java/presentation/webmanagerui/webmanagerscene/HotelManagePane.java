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

    public HotelManagePane(Pane mainPane) {
        loadFxml(mainPane);
    }

    private void loadFxml(Pane mainPane) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/webmanager/webmanhotelman.fxml"));
        fxmlLoader.setRoot(this);
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        HotelManageController hotelManageController = fxmlLoader.getController();
        hotelManageController.launch(mainPane);
    }
}
