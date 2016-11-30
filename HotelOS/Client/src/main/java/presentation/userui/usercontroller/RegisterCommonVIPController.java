package presentation.userui.usercontroller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;

/**
 * Created by wyj on 2016/11/25.
 */
public class RegisterCommonVIPController {

    private Stage stage;

    @FXML private Button registerCommonBtn;
    @FXML private CheckBox confirmCommonvipInfo;

    public void launch(Stage primaryStage) {
        this.stage = primaryStage;
    }


    @FXML
    private void checkCommonvipInfo() {
        if (confirmCommonvipInfo.isSelected()) {
            registerCommonBtn.setDisable(false);
        } else {
            registerCommonBtn.setDisable(true);
        }
    }
}
