package presentation.userui.usercontroller;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.userui.userscene.EvaluateOrderPane;

/**
 * Created by wyj on 2016/11/25.
 */
public class OrderDetailUserController {

    private Stage stage;
    private Pane mainPane;

    public void launch(Stage primaryStage, Pane mainPane) {
        this.stage = primaryStage;
        this.mainPane = mainPane;
    }


    @FXML
    private void evaluateOrder() {
        mainPane.getChildren().remove(0);
        mainPane.getChildren().add(new EvaluateOrderPane(stage));
    }
}
