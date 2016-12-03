package presentation.webmarketerui.webmarketercontroller;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.util.AlertController;
import presentation.webmarketerui.webmarketerscene.AppealOrderPane;

/**
 * Created by Hitiger on 2016/11/28.
 * Description :
 */
public class FindOrderPaneController {
    private Pane mainPane;
    private AlertController alertController;

    public void launch(Pane mainPane) {
        this.mainPane = mainPane;
        alertController = new AlertController();
    }

    @FXML
    private void findOrder() {
        mainPane.getChildren().remove(0);
        mainPane.getChildren().add(new AppealOrderPane(mainPane));
    }

}
