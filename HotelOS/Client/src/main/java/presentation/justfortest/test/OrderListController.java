package test;


import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;

/**
 * Created by:Hitiger
 * Date: 2016/11/14   Time: 20:49
 * Description:
 */
public class OrderListController extends CommonController{



    @Override
    @FXML
    protected void testBack(){
        System.out.println( stage);
        stage.setScene(new Scene(new Group(),600,300));
        System.out.println("here0");
    }
}
