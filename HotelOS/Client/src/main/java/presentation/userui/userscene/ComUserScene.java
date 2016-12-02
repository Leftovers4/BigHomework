package presentation.userui.userscene;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import presentation.userui.usercontroller.ComUserSceneController;
import presentation.util.MyWindow;

import java.io.IOException;

/**
 * Created by Hitiger on 2016/11/19.
 * Description : 共同的scene，有侧边栏，底部栏，有一个用于切换界面的Pane
 */
public class ComUserScene extends Scene{

    public ComUserScene(Parent parent, Stage primaryStage) {
        super(parent);
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("/fxml/user/usercommon.fxml"));

        try {
            this.setRoot(fxmlLoader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }

        //配置控制器
        ComUserSceneController comUserSceneController = fxmlLoader.getController();
        comUserSceneController.launch(primaryStage);

        //实现窗口可拖动
        MyWindow.enableWindowDrag(this.getRoot(), primaryStage);
    }
}
