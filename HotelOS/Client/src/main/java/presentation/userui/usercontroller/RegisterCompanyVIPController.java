package presentation.userui.usercontroller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;

/**
 * Created by wyj on 2016/11/25.
 */
public class RegisterCompanyVIPController {

    private Stage stage;

    @FXML private CheckBox confirmCompanyvipInfo;
    @FXML private Button registerCompanyBtn;

    public void launch(Stage primaryStage) {
        this.stage = primaryStage;
    }

    @FXML
    private void checkCompanyvipInfo() {
        if (confirmCompanyvipInfo.isSelected()) {
            registerCompanyBtn.setDisable(false);
        } else {
            registerCompanyBtn.setDisable(true);
        }
    }
}
