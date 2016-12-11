package presentation.hotelworkerui.hotelworkerscene;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.hotelworkerui.hotelworkercontroller.RegisterRoomPaneController;

import java.io.IOException;

/**
 * Created by Hitiger on 2016/11/16.
 * Description :
 */
public class RegisterRoomPane  extends Pane {
    public RegisterRoomPane() {
        loadFxml();
    }

    private void loadFxml() {
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getClassLoader().getResource("fxml/hotelworker/hotelroomregister.fxml"));
        fxmlLoader.setRoot(this);
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        RegisterRoomPaneController registerRoomPaneController = fxmlLoader.getController();
        registerRoomPaneController.launch();
    }
}
