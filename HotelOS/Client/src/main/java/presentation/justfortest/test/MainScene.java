package test;

import javafx.beans.NamedArg;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by:Hitiger
 * Date: 2016/11/14   Time: 19:54
 * Description:
 */
public class MainScene extends Scene{

    public MainScene(Parent root, Stage primaryStage) {
        super(root);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/mainfxml.fxml"));
        try {
            this.setRoot(fxmlLoader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }

        CommonController controller = fxmlLoader.getController();
        controller.setStage(primaryStage);
    }

    public MainScene(Parent root) {
        super(root);
    }
}
