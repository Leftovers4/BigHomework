package presentation.userui.usercontroller;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.userui.userscene.InfoPane;

/**
 * Created by Hitiger on 2016/11/19.
 * Description : 客户主界面控制器，负责基本信息、浏览订单、搜索酒店等界面的跳转
 */
public class ComUserSceneController {

    @FXML private Pane mainPane;

    public void launch(Stage primaryStage){
        mainPane.getChildren().add(new InfoPane(primaryStage));
    }


}
