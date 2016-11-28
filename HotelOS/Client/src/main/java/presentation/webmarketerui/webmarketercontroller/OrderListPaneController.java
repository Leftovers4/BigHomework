package presentation.webmarketerui.webmarketercontroller;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.util.AlertController;

/**
 * Created by Hitiger on 2016/11/28.
 * Description :
 */
public class OrderListPaneController {
    private Stage stage;
    private Pane mainPane;
    private AlertController alertController;
    public void launch(Stage primaryStage,Pane mainPane){
        this.stage = primaryStage;
        this.mainPane = mainPane;
        alertController = new AlertController();
    }

    @FXML
    private void checkOrderDetail(){}

    @FXML
    private void appealOrder(){}

    @FXML
    private void closeWindow(){
        if(alertController.showConfirmExitAlert()) stage.close();
    }

    @FXML
    private void minWindow(){}

    @FXML
    private void back(){}
}
