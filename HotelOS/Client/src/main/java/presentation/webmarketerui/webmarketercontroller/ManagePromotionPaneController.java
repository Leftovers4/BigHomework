package presentation.webmarketerui.webmarketercontroller;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.util.AlertController;

/**
 * Created by Hitiger on 2016/11/28.
 * Description :
 */
public class ManagePromotionPaneController {
    private Stage stage;
    private AlertController alertController;

    public void launch(Stage primaryStage) {
        this.stage = primaryStage;
        alertController = new AlertController();
    }

    @FXML
    private void addTimePromotion() {
    }

    @FXML
    private void modifyTimePromotion() {
    }

    @FXML
    private void deleteTimePromotion() {
    }

    @FXML
    private void confirmTimeAdd() {
    }

    @FXML
    private void cancelTimeAdd() {
    }

    @FXML
    private void addMemPromotion() {
    }

    @FXML
    private void modifyMemPromotion() {
    }

    @FXML
    private void deleteMemPromotion() {
    }

    @FXML
    private void confirmMemAdd() {
    }

    @FXML
    private void cancelMemAdd() {
    }

    @FXML
    private void closeWindow() {
        if (alertController.showConfirmExitAlert()) stage.close();
    }

    @FXML
    private void minWindow() {
    }

    @FXML
    private void back() {
    }
}
