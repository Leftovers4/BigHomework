import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

/**
 * Created by:Hitiger
 * Date: 2016/11/9   Time: 19:54
 * Description:
 */
public class DetailsScene extends Scene{


    public DetailsScene(Parent root){
        super(root);
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("detailsFxml.fxml"));
        Parent parentRoot= null;
        try {
            parentRoot = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.setRoot(parentRoot);
    }
}
