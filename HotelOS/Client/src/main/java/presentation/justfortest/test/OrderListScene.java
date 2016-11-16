package test; /**
 * Created by:Hitiger
 * Date: 2016/11/5   Time: 20:26
 * Description:
 */

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

import java.io.IOException;


public class OrderListScene extends MainScene {

    public OrderListScene (Parent root, Stage primaryStage){
        super(root);
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("fxml/orderlistfxml.fxml"));
        try {
           this.setRoot(fxmlLoader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
