package presentation.hotelworkerui.hotelworkerscene.commonscene;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import presentation.hotelworkerui.hotelworkercontroller.CommonSceneController;

import java.io.IOException;

/**
 * Created by Hitiger on 2016/11/18.
 * Description : 共同的scene，有侧边栏，底部栏，有一个用于切换界面的Pane
 */
public class CommonScene extends Scene{

    public CommonScene(Parent parent, Stage primaryStage) {
        super(parent);
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("/fxml/hotelworker/hotelcommon.fxml"));

        try {
            this.setRoot(fxmlLoader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }

        //配置控制器
        CommonSceneController commonSceneController = fxmlLoader.getController();
        commonSceneController.launch(primaryStage);
    }
}
