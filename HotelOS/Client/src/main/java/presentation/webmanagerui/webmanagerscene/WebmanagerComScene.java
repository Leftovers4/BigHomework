package presentation.webmanagerui.webmanagerscene;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import presentation.userui.usercontroller.ComUserSceneController;
import presentation.util.EnableWindowDrag;
import presentation.webmanagerui.webmanagercontroller.WebmanagerComController;

import java.io.IOException;

/**
 * Created by wyj on 2016/11/29.
 */
public class WebmanagerComScene extends Scene {

    public WebmanagerComScene(Parent parent, Stage primaryStage) {
        super(parent);
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("/fxml/webmanager/webmanagercommon.fxml"));

        try {
            this.setRoot(fxmlLoader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }

        //配置控制器
        WebmanagerComController webmanagerComController = fxmlLoader.getController();
        webmanagerComController.launch(primaryStage);

        //实现窗口可拖动
        new EnableWindowDrag(this.getRoot(), primaryStage);
    }
}
