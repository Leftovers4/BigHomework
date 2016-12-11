package presentation.webmanagerui.webmanagerscene;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import presentation.webmanagerui.webmanagercontroller.CheckHotelInfoController;
import presentation.webmanagerui.webmanagercontroller.CheckUserInfoController;

import java.io.IOException;

/**
 * Created by wyj on 2016/12/12.
 */
public class CheckUserInfoPane extends Pane {

    public CheckUserInfoPane(Pane mainPane, String userID) {
        loadFxml(mainPane, userID);
    }

    private void loadFxml(Pane mainPane, String userID) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/webmanager/webuserinfo.fxml"));
        fxmlLoader.setRoot(this);
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        CheckUserInfoController checkUserInfoController = fxmlLoader.getController();
        checkUserInfoController.launch(mainPane, userID);
    }
}
