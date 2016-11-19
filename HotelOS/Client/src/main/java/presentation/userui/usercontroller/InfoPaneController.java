package presentation.userui.usercontroller;

import javafx.fxml.FXML;
import javafx.stage.Stage;
/**
 * Created by Hitiger on 2016/11/19.
 * Description : 客户基本信息控制器，负责查看和编辑信息界面的跳转
 */
public class InfoPaneController {

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
