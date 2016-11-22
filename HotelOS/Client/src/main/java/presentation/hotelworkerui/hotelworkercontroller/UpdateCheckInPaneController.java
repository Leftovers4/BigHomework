package presentation.hotelworkerui.hotelworkercontroller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.hotelworkerui.hotelworkerscene.FindOrderPane;
import presentation.hotelworkerui.hotelworkerscene.OrderDetailPane;

/**
 * Created by Hitiger on 2016/11/20.
 * Description :
 */
public class UpdateCheckInPaneController {

    //选择入住方式的组件
    @FXML Button checkinOnlineBtn;
    @FXML Button checkinOfflineBtn;
    @FXML Label checkinOnlineLabel;
    @FXML Label checkinOfflineLabel;

    private Stage stage;
    private Pane mainPane;

    public void launch(Stage primaryStage,Pane mainPane) {
        this.mainPane = mainPane;
        this.stage = primaryStage;
    }
    @FXML
    private void closeWindow(){
        stage.close();
    }

    @FXML
    private void minWindow(){
        stage.setIconified(true);
    }

    @FXML
    private void back(){
    }

    /**
    * 线上入住
    */
    @FXML
    private void checkinOnline(){
        mainPane.getChildren().remove(0);
        mainPane.getChildren().add(new FindOrderPane(stage,mainPane,true));
    }

    /**
     * 线下入住
     */
    @FXML
    private void checkinOffline(){

    }

}
