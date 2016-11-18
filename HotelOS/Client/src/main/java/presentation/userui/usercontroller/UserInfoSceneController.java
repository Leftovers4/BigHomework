package presentation.userui.usercontroller;

import javafx.stage.Stage;

/**
 * Created by wyj on 2016/11/18.
 */
public class UserInfoSceneController {

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
