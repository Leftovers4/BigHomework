package presentation.userui.usercontroller;

import javafx.fxml.FXML;
import javafx.stage.Stage;

import javax.swing.text.TableView;

/**
 * Created by wyj on 2016/11/25.
 */
public class CreditRecordController {


    private Stage stage;
    @FXML private TableView recordtable;

    public void launch(Stage primaryStage) {
        this.stage = primaryStage;
    }


}