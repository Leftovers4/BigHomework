package presentation.userui.usercontroller;

import javafx.fxml.FXML;
import javafx.stage.Stage;

/**
 * Created by wyj on 2016/11/25.
 */
public class CancelOrderController {

    private Stage stage;

    public void launch(Stage primaryStage) {
        this.stage = primaryStage;
    }

    @FXML
    private void closeWindow(){
        stage.close();
    }

    @FXML
    private void minWindow(){
        stage.setIconified(true);
    }
}
