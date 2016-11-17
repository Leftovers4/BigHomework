package presentation.util;

import javafx.fxml.FXML;
import javafx.stage.Stage;

/**
 * Created by Hitiger on 2016/11/16.
 * Description : 具有控制窗口关闭、最小化；返回的控制器
 */
public class CommonController {

    Stage stage;
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    /**
     * 关闭窗口
     */
    @FXML
    protected void closeWindow(){
        stage.close();
    }

    /**
     * 最小化窗口
     */
    @FXML
    protected void minWindow(){
        stage.setIconified(true);
    }

    /**
     * 返回上一步操作界面
     */
    @FXML
    protected void backScene(){}

}
