package presentation.justfortest;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by Hitiger on 2016/11/19.
 * Description :
 */
public class PeopleScene extends Application{
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("/fxml/hotelworker/orderListSceneFxml.fxml"));
        Parent root= fxmlLoader.load();
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
