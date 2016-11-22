package presentation.hotelworkerui.hotelworkercontroller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Created by Hitiger on 2016/11/20.
 * Description :
 */
public class UpdateOutPaneController {
    private Stage stage;
    private Pane mainPane;

    //选择入住方式的组件
    @FXML Button outOnlineBtn;
    @FXML Button outOfflineBtn;

    public void launch(Stage primaryStage,Pane mainPane) {
        this.stage = primaryStage;
        this.mainPane = mainPane;
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
    private void outOnline(){}

    @FXML
    private void outOffline(){}
}
