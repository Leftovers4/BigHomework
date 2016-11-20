package presentation.hotelworkerui.hotelworkercontroller;

import javafx.fxml.FXML;
import javafx.stage.Stage;

/**
 * Created by Hitiger on 2016/11/20.
 * Description :
 */
public class UpdateOutPaneController {
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

    @FXML
    private void back(){
    }
}
