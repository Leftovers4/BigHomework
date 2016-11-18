package presentation.userui.userscene;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import presentation.userui.usercontroller.UserIndexSceneController;

import java.io.IOException;

/**
 * Created by wyj on 2016/11/17.
 */
public class UserIndexScene extends Scene {

    private double xOffset = 0;
    private double yOffset = 0;

    public UserIndexScene(Parent parent, Stage primaryStage) {
        super(parent);
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("/fxml/user/UserCommon.fxml"));
        Parent root= null;
        try {
            root = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.setRoot(root);

        //配置控制器
        UserIndexSceneController loginSceneController = fxmlLoader.getController();
        loginSceneController.setStage(primaryStage);

        //实现窗口可拖动
        enableWindowDrag(root,primaryStage);
    }

    /**
     * 实现窗口可拖动
     * @param root
     * @param primaryStage
     */
    private void enableWindowDrag(Parent root, Stage primaryStage) {
        root.setOnMousePressed((MouseEvent event) -> {
            event.consume();
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });
        root.setOnMouseDragged((MouseEvent event) -> {
            event.consume();
            primaryStage.setX(event.getScreenX() - xOffset);
            primaryStage.setY(event.getScreenY() - yOffset);
        });
    }
}
