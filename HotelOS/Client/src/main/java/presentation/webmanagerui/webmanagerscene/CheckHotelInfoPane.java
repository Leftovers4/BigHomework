package presentation.webmanagerui.webmanagerscene;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.webmanagerui.webmanagercontroller.AddHotelController;
import presentation.webmanagerui.webmanagercontroller.CheckHotelInfoController;

import java.io.IOException;

/**
 * Created by wyj on 2016/12/12.
 */
public class CheckHotelInfoPane extends Pane {

    public CheckHotelInfoPane(Pane mainPane, long hotelID) {
        loadFxml(mainPane, hotelID);
    }

    private void loadFxml(Pane mainPane, long hotelID) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/webmanager/webhotelinfo.fxml"));
        fxmlLoader.setRoot(this);
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        CheckHotelInfoController checkHotelInfoController = fxmlLoader.getController();
        checkHotelInfoController.launch(mainPane, hotelID);
    }
}
