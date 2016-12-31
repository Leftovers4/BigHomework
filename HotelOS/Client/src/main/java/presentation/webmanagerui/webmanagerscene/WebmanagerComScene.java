package presentation.webmanagerui.webmanagerscene;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import presentation.util.other.MyWindow;
import presentation.webmanagerui.webmanagercontroller.WebmanagerComController;

import java.io.IOException;

/**
 * Created by wyj on 2016/11/29.
 */
public class WebManagerComScene extends Scene {

    public WebManagerComScene(Parent parent, Stage primaryStage) {
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
        MyWindow.enableWindowDrag(this.getRoot(), primaryStage);
    }
}
