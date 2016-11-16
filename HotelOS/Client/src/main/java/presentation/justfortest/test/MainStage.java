package test;
/**
 * Created by:Hitiger
 * Date: 2016/11/14   Time: 20:09
 * Description:
 */

import javafx.application.Application;
import javafx.scene.Group;
import javafx.stage.Stage;


public class MainStage extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new MainScene(new Group(), primaryStage));
        primaryStage.show();
    }
}
