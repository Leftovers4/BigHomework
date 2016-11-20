package presentation.hotelworkerui.hotelworkerscene;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.hotelworkerui.hotelworkercontroller.UpdateOutPaneController;

import java.io.IOException;

/**
 * Created by Hitiger on 2016/11/20.
 * Description :
 */
public class UpdateOutPane extends Pane {
    public UpdateOutPane(Stage primaryStage) {
        loadFxml(primaryStage);
    }

    private void loadFxml(Stage primaryStage) {
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("/fxml/hotelworker/hotelupdateout.fxml"));
        fxmlLoader.setRoot(this);
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        UpdateOutPaneController updateOutPaneController = fxmlLoader.getController();
        updateOutPaneController.launch(primaryStage);
    }
}
