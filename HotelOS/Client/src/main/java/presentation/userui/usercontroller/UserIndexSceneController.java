package presentation.userui.usercontroller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * Created by wyj on 2016/11/17.
 */
public class UserIndexSceneController {

    Stage stage;
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    /**
     * 关闭窗口
     */
    public void closeWindow() {
        stage.close();
    }

    /**
     * 最小化窗口
     */
    public void minimizeWindow() {
        stage.setIconified(true);
    }
}
