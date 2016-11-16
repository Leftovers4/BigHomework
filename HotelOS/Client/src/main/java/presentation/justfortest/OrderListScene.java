///**
// * Created by:Hitiger
// * Date: 2016/11/5   Time: 20:26
// * Description:
// */
//
//import javafx.application.Application;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.stage.Stage;
//
//import java.io.IOException;
//
//public class OrderListScene extends Application {
//
//    public static void main(String[] args) {
//        launch(args);
//    }
//
//    @Override
//    public void start(Stage primaryStage) throws IOException {
//        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("orderListSceneFxml.fxml"));
//        Parent root= fxmlLoader.load();
//        Controller controller = fxmlLoader.getController();
//        controller.setStage(primaryStage);
//        primaryStage.setTitle("Hello World");
//        primaryStage.setScene(new Scene(root));
//        primaryStage.show();
//    }
//}
////