package presentation.hotelworkerui.hotelworkercontroller;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.util.AlertController;

/**
 * Created by Hitiger on 2016/11/23.
 * Description :
 */
public class UpdateOfflinePaneController {

    private Stage stage;
    private Pane mainPane;
    private AlertController alertController;

    public void launch(Stage primaryStage, Pane mainPane) {
        this.stage = primaryStage;
        this.mainPane = mainPane;
        alertController = new AlertController();
    }

    @FXML
    private void closeWindow(){
        if(alertController.showConfirmExitAlert()) stage.close();
    }

    @FXML
    private void minWindow(){
        stage.setIconified(true);
    }

    @FXML
    private void back(){}
}
