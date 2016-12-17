package presentation.hotelworkerui.hotelworkerscene;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import presentation.hotelworkerui.hotelworkercontroller.ComWorkerSceneController;
import presentation.util.other.MyWindow;

import java.io.IOException;

/**
 * Created by Hitiger on 2016/11/18.
 * Description : 共同的scene，有侧边栏，底部栏，有一个用于切换界面的Pane
 */
public class ComWorkerScene extends Scene{

    public ComWorkerScene(Parent parent, Stage primaryStage, long hotelID) {
        super(parent);
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("/fxml/hotelworker/hotelcommon.fxml"));

        try {
            this.setRoot(fxmlLoader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }

        //配置控制器
        ComWorkerSceneController comWorkerSceneController = fxmlLoader.getController();
        comWorkerSceneController.launch(primaryStage, hotelID);

        //实现窗口可拖动
        MyWindow.enableWindowDrag(this.getRoot(), primaryStage);
    }
}
