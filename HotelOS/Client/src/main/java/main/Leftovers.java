package main;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import presentation.loginui.loginscene.LoginScene;
import presentation.util.EnableWindowDrag;

/**
 * Created by Hitiger on 2016/11/17.
 * Description : 程序入口
 */
public class Leftovers extends Application{


    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(new LoginScene(new Group(),primaryStage));
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
