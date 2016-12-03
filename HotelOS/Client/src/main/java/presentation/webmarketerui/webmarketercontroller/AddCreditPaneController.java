package presentation.webmarketerui.webmarketercontroller;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.util.AlertController;
import presentation.webmarketerui.webmarketerscene.FindUserPane;

/**
 * Created by Hitiger on 2016/11/28.
 * Description :
 */
public class AddCreditPaneController {
    private Pane mainPane;
    private AlertController alertController;

    public void launch(Pane mainPane) {
        this.mainPane = mainPane;
        alertController = new AlertController();
    }


}
