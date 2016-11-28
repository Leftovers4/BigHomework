package presentation.webmarketerui.webmarketercontroller;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.util.AlertController;
import presentation.webmarketerui.webmarketerscene.FindOrderPane;

/**
 * Created by Hitiger on 2016/11/28.
 * Description :
 */
public class AppealOrderPaneController {
    private Stage stage;
    private Pane mainPane;
    private AlertController alertController;
    public void launch(Stage primaryStage,Pane mainPane){
        this.stage = primaryStage;
        this.mainPane = mainPane;
        alertController = new AlertController();
    }

    @FXML
    private void closeWindow(){ if(alertController.showConfirmExitAlert()) stage.close();}

    @FXML
    private void minWindow(){}

    @FXML
    private void back(){
        mainPane.getChildren().remove(0);
        mainPane.getChildren().add(new FindOrderPane(stage,mainPane));
    }
}
