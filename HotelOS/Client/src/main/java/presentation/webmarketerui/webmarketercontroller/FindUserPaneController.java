package presentation.webmarketerui.webmarketercontroller;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.util.AlertController;
import presentation.webmarketerui.webmarketerscene.AddCreditPane;

/**
 * Created by Hitiger on 2016/11/28.
 * Description :
 */
public class FindUserPaneController {
    private Pane mainPane;
    private AlertController alertController;
    public void launch(Pane mainPane){
        this.mainPane = mainPane;
        alertController = new AlertController();
    }

    @FXML
    private void findUser(){
        mainPane.getChildren().remove(0);
        mainPane.getChildren().add(new AddCreditPane(mainPane));
    }

}
