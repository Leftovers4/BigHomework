package presentation.hotelworkerui.hotelworkerscene.commonscene;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * Created by Hitiger on 2016/11/18.
 * Description : 测试程序入口
 */
public class TestLauncher extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(new CommonScene(new Group(),primaryStage));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
