package test;

import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Created by:Hitiger
 * Date: 2016/11/14   Time: 20:15
 * Description:
 */
public class CommonController {

    protected Stage stage;


    @FXML
    protected void testBack() {
        stage.setScene(new OrderListScene(new Group(),stage));
        System.out.println("here");
    }

    @FXML
    public void testClose() {
        this.stage.close();
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

}
